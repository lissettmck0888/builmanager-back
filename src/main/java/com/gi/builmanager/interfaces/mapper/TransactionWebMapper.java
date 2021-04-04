package com.gi.builmanager.interfaces.mapper;

import com.gi.builmanager.domain.model.billing.Transaction;
import com.gi.builmanager.domain.model.billing.TransactionDetails;
import com.gi.builmanager.interfaces.dto.PaymentDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TransactionWebMapper {

    public Transaction toModel(PaymentDto paymentDto){
        return Transaction.builder()
                //.id(TransactionId.builder().build())
                .details(TransactionDetails.builder()
                        .date(LocalDateTime.now())
                        .type("Abono")
                        .amount(paymentDto.getAmount())
                        .propertyId(paymentDto.getPropertyId())
                        .expenseId(paymentDto.getExpenseId())
                        .build()
                ).build();
    }
}
