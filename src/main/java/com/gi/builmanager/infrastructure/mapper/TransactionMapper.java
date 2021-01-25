package com.gi.builmanager.infrastructure.mapper;

import com.gi.builmanager.domain.model.billing.Transaction;
import com.gi.builmanager.domain.model.billing.TransactionDetails;
import com.gi.builmanager.domain.model.billing.TransactionId;
import com.gi.builmanager.infrastructure.hibernate.entity.Movimiento;
import com.gi.builmanager.infrastructure.hibernate.repository.GastoComunRepository;
import com.gi.builmanager.infrastructure.hibernate.repository.UnidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TransactionMapper implements RepositoryMapper<Transaction, Movimiento> {

    @Autowired
    private GastoComunRepository gastoComunRepository;
    @Autowired
    private UnidadRepository unidadRepository;

    @Override
    public Transaction fromRepositoryType(Movimiento movimiento) {
        return Transaction.builder()
                .id(TransactionId.builder().id(movimiento.getId()).build())
                .details(TransactionDetails.builder()
                        .expenseId(movimiento.getGastoComun().getIdGastoComun())
                        .propertyId(movimiento.getUnidad().getIdUnidad())
                        .type(movimiento.getTipo())
                        .amount(movimiento.getMonto())
                        .date(movimiento.getFecha())
                        .build()
                )
                .build();
    }

    @Override
    public Movimiento toRepository(Transaction transaction) {
        Movimiento movimiento = Movimiento.builder()
                .gastoComun(gastoComunRepository.findById(transaction.getDetails().getExpenseId()).orElseThrow(IllegalArgumentException::new))
                .unidad(unidadRepository.findById(transaction.getDetails().getPropertyId()).orElseThrow(IllegalArgumentException::new))
                .fecha(LocalDateTime.now())
                .monto(transaction.getDetails().getAmount())
                .tipo(transaction.getDetails().getType())
                .build();
        //repositoryHelper.fillEntity(transaction, movimiento);
        return movimiento;
    }
}
