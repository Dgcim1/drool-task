package ru.dgcim.drooltask.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RequestBean {
    private BigDecimal amount;
    private int quantity;
}
