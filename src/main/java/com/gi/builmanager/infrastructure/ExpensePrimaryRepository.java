package com.gi.builmanager.infrastructure;

import com.gi.builmanager.domain.model.expense.Expense;
import com.gi.builmanager.domain.model.expense.ExpenseItemValue;
import com.gi.builmanager.domain.model.expense.ExpenseRepository;
import com.gi.builmanager.infrastructure.hibernate.entity.GastoComun;
import com.gi.builmanager.infrastructure.hibernate.repository.GastoComunRepository;
import com.gi.builmanager.infrastructure.hibernate.repository.PlantillaGastosOrdinariosRepository;
import com.gi.builmanager.infrastructure.mapper.ExpenseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ExpensePrimaryRepository implements ExpenseRepository {

    @Autowired
    private ExpenseMapper expenseMapper;

    @Autowired
    private GastoComunRepository gastoComunRepository;
    @Autowired
    private PlantillaGastosOrdinariosRepository plantillaGastosOrdinariosRepository;

    @Override
    public Expense retrieveCurrentExpense() {
        return expenseMapper.fromRepositoryType(gastoComunRepository.findByEstado("Actual"));
    }

    @Override
    public Expense retrieveOpenedExpense() {
        return expenseMapper.fromRepositoryType(gastoComunRepository.findByEstado("Abierto"));

    }

    @Override
    public Expense retrieveLastClosedExpense() {
        Optional<GastoComun> optionalGastoComun = gastoComunRepository.findUltimoGastoComunCerrado();
        return optionalGastoComun.map(gastoComun -> expenseMapper.fromRepositoryType(gastoComun)).orElse(null);
    }

    @Override
    public List<ExpenseItemValue> retrieveOrdinaryExpenses() {
        return plantillaGastosOrdinariosRepository.findByActivoEqualsTrue().stream()
                .map(plantillaGastosOrdinarios -> ExpenseItemValue.builder()
                        .amount(plantillaGastosOrdinarios.getMonto())
                        .description(plantillaGastosOrdinarios.getItemGastoComun().getDescripcion())
                        .name(plantillaGastosOrdinarios.getItemGastoComun().getNombre())
                        .type(plantillaGastosOrdinarios.getItemGastoComun().getTipo())
                        .build()
                )
                .collect(Collectors.toList());
    }

    @Override
    public Expense getById(Integer id) {
        return expenseMapper.fromRepositoryType(gastoComunRepository.findById(id).orElse(null));
    }

    @Override
    public Integer save(Expense aggregate) {
        GastoComun gastoComun = expenseMapper.toRepository(aggregate);
        gastoComunRepository.save(gastoComun);
        return 1;
    }

    @Override
    public Integer saveAll(List<Expense> aggregate) {
        return null;
    }

}
