package com.gi.builmanager.infrastructure.hibernate.mapper;

import com.gi.builmanager.domain.model.expense.Expense;
import com.gi.builmanager.domain.model.expense.ExpenseDetails;
import com.gi.builmanager.domain.model.expense.ExpenseId;
import com.gi.builmanager.domain.model.expense.ExpenseItemValue;
import com.gi.builmanager.infrastructure.hibernate.entity.DetalleGastoComun;
import com.gi.builmanager.infrastructure.hibernate.entity.GastoComun;
import com.gi.builmanager.infrastructure.hibernate.repository.GastoComunRepository;
import com.gi.builmanager.infrastructure.hibernate.repository.ItemGastoComunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ExpenseMapper implements RepositoryMapper<Expense, GastoComun> {

    @Autowired
    private GastoComunRepository gastoComunRepository;
    @Autowired
    private ItemGastoComunRepository itemGastoComunRepository;

    @Override
    public Expense fromRepositoryType(GastoComun gastoComun) {

        if (Objects.isNull(gastoComun))
            return null;

        List<ExpenseItemValue> expenseItemValueList = gastoComun.getListaDetalleGastoComun().stream()
                .map(detalleGastoComun -> ExpenseItemValue.builder()
                        .id(detalleGastoComun.getIdDetalleGastoComun())
                        .type(detalleGastoComun.getItemGastoComun().getTipo())
                        .name(detalleGastoComun.getItemGastoComun().getNombre())
                        .description(detalleGastoComun.getItemGastoComun().getDescripcion())
                        .amount(detalleGastoComun.getMonto())
                        .build())
                .collect(Collectors.toList());

        return Expense.builder()
                .id(ExpenseId.builder().id(gastoComun.getIdGastoComun()).build())
                .details(ExpenseDetails.builder()
                        .state(gastoComun.getEstado())
                        .period(gastoComun.getPeriodo())
                        .totalAmount(gastoComun.getMontoTotal())
                        .expenseItemValues(expenseItemValueList)
                        .build())
                .build();
    }

    @Override
    public GastoComun toRepository(Expense expense) {

        GastoComun retrieved = null;
        try {
            retrieved = gastoComunRepository.findById(expense.getId().getId()).orElseThrow(IllegalArgumentException::new);
        }catch (IllegalArgumentException | NullPointerException e) {
            retrieved = GastoComun.builder()
                    .estado(expense.getDetails().getState())
                    .periodo(expense.getDetails().getPeriod())
                    .listaDetalleGastoComun(new ArrayList<>())
                    .build();
        }

        final GastoComun gastoComun = retrieved;
        List<DetalleGastoComun> detalleGastoComunList = expense.getDetails().getExpenseItemValues().stream()
                .map(expenseItem -> {
                    Optional<DetalleGastoComun> detalleOptional = gastoComun.getListaDetalleGastoComun().stream()
                            .filter(detalleGastoComun -> detalleGastoComun.getIdDetalleGastoComun().equals(expenseItem.getId()))
                            .findFirst();
                    return detalleOptional.orElse(DetalleGastoComun.builder()
                            .itemGastoComun(itemGastoComunRepository.findByNombre(expenseItem.getName()))
                            .gastoComun(gastoComun)
                            .monto(expenseItem.getAmount())
                            .build()
                    );
                }).collect(Collectors.toList());

        retrieved.setEstado(expense.getDetails().getState());
        retrieved.setMontoTotal(expense.getDetails().getTotalAmount());
        retrieved.getListaDetalleGastoComun().clear();
        retrieved.getListaDetalleGastoComun().addAll(detalleGastoComunList);

        return retrieved;
    }
}
