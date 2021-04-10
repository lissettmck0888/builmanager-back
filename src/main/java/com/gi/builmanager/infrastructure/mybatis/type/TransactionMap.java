package com.gi.builmanager.infrastructure.mybatis.type;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionMap {

    private Long id;
    private Integer propertyId;
    private Integer expenseId;
    private LocalDateTime date;
    private Double amount;
    private String type;
}
