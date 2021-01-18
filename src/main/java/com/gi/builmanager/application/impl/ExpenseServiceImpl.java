package com.gi.builmanager.application.impl;

import com.gi.builmanager.application.ExpenseService;
import com.gi.builmanager.domain.model.assignment.AssignmentRepository;
import com.gi.builmanager.domain.model.assignment.Property;
import com.gi.builmanager.domain.model.billing.Billing;
import com.gi.builmanager.domain.model.billing.BillingRepository;
import com.gi.builmanager.domain.model.billing.Transaction;
import com.gi.builmanager.domain.model.billing.TransactionRepository;
import com.gi.builmanager.domain.model.expense.Expense;
import com.gi.builmanager.domain.model.expense.ExpenseItemValue;
import com.gi.builmanager.domain.model.expense.ExpenseRepository;
import com.gi.builmanager.domain.model.expenseconfig.ExpenseItem;
import com.gi.builmanager.domain.model.expenseconfig.ExpenseItemDetails;
import com.gi.builmanager.domain.model.expenseconfig.ExpenseItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private ExpenseItemRepository expenseItemRepository;
    @Autowired
    private BillingRepository billingRepository;
    @Autowired
    private AssignmentRepository assignmentRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void updateExpense(Expense expense) {
        checkIfOrdinaryExpensesExist(expense.getDetails().getExpenseItemValues());
        expenseRepository.save(expense);
    }

    private void checkIfOrdinaryExpensesExist(List<ExpenseItemValue> expenseItemList) {
        List<ExpenseItem> items = expenseItemRepository.allExtraordinary();

        expenseItemList.forEach(expenseItem -> {
            Optional<ExpenseItem> optionalExpenseItem = items.stream()
                    .filter(item -> item.getDetails().getName().equalsIgnoreCase(expenseItem.getName()))
                    .findFirst();

            if (!optionalExpenseItem.isPresent()) {
                expenseItemRepository.save(ExpenseItem.builder()
                        .details(ExpenseItemDetails.builder()
                                .name(expenseItem.getName())
                                .description(expenseItem.getDescription())
                                .type(expenseItem.getType())
                                .build())
                        .build());
            }
        });
    }

    @Override
    public void terminateOpenedExpense() {

        Expense currentExpense = expenseRepository.retrieveCurrentExpense();
        if (Objects.nonNull(currentExpense)){
            currentExpense.closeExpense();
            expenseRepository.save(currentExpense);
        }

        Expense openedExpense = expenseRepository.retrieveOpenedExpense();
        openedExpense.terminateExpensePeriod(expenseRepository.retrieveOrdinaryExpenses());

        expenseRepository.save(openedExpense);
        expenseRepository.save(Expense.newExpense(openedExpense.getDetails().getPeriod()));

    }

    @Override
    public void generateDebt() {

        Expense closedExpense = expenseRepository.retrieveLastClosedExpense();
        LocalDate closedPeriod = Objects.nonNull(closedExpense) ? closedExpense.getDetails().getPeriod() : LocalDate.now();

        Expense currentExpense = expenseRepository.retrieveCurrentExpense();
        Double totalSquareMeters = assignmentRepository.usedSquareMetersTotal();


        List<Billing> closedPeriodPropertyBillingList = billingRepository.getBillingByPeriod(closedPeriod);
        List<Transaction> closedPeriodPropertyPaymentsList = transactionRepository.retrieveClosedPeriodPaymentsList();

        Map<Object, Double> billingByPropertyMapper = billingByPropertyMapper(closedPeriodPropertyBillingList);
        Map<Object, Double> paymentsByPropertyMapper = paymentsByPropertyMapper(closedPeriodPropertyPaymentsList);

        assignmentRepository.activeAssignments().forEach(assignment -> {

            Property mainProperty = assignment.mainProperty();

            Double apportionFactor = assignment.getDetails().getTotalSquareMeters() / totalSquareMeters;

            Double billingTotal = getOrDefault(billingByPropertyMapper, mainProperty.getId(), 0.0);
            Double paymentsTotal = getOrDefault(paymentsByPropertyMapper, mainProperty.getId(), 0.0);

            Billing billing = Billing.from(currentExpense, mainProperty, apportionFactor, billingTotal, paymentsTotal);

            //FIXME: PERSIST BILLING
            billingRepository.save(billing);
        });
    }

    private Map<Object, Double> billingByPropertyMapper(List<Billing> billingList) {

        if (Objects.isNull(billingList)) return null;

        return billingList.stream()
                .collect(Collectors.groupingBy(
                        billing -> billing.getDetails().getMainPropertyId(),
                        Collectors.summingDouble(value -> value.getDetails().getBalance())
                ));
    }

    private Map<Object, Double> paymentsByPropertyMapper(List<Transaction> paymentList) {

        if (Objects.isNull(paymentList)) return null;

        return paymentList.stream()
                .collect(Collectors.groupingBy(
                        billing -> billing.getDetails().getPropertyId(),
                        Collectors.summingDouble(value -> value.getDetails().getAmount())
                ));
    }

    private <T> T getOrDefault(Map<Object, T> mapper, Object key, T defaultValue) {
        if (Objects.isNull(mapper) || !mapper.containsKey(key))
            return defaultValue;
        return mapper.get(key);
    }

}
