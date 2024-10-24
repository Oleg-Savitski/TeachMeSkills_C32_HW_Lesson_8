package com.teachmeskills.lesson_8.model.document;

import java.time.LocalDate;

// TODO добавить поля на свое усмотрение

public class Invoice {
    private String invoiceNumber; // Номер инвойса
    private String recipient; // Получатель
    private String sender;  // Отправитель
    private double amount; // Сумма
    private LocalDate date; // Дата

    public Invoice(String invoiceNumber, String recipient, double amount, String sender, LocalDate date) {
        this.invoiceNumber = invoiceNumber;
        this.recipient = recipient;
        this.amount = amount;
        this.sender = sender;
        this.date = date;
    }
}