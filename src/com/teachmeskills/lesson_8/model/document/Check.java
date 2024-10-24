package com.teachmeskills.lesson_8.model.document;
import com.teachmeskills.lesson_8.model.card.BaseCard;

import java.util.Date;

// TODO добавить поля: сумма перевода, дата перевода, номер счета или номер карты
// TODO создать метод для вывода информации о чеке на экран

public class Check {
    public int transferAmount;
    public Date transferDate;
    public BaseCard card;

    public Check(int transferAmount, Date transferDate, BaseCard card) {
        this.transferAmount = transferAmount;
        this.transferDate = transferDate;
        this.card = card;
    }

    public void showCheckInfo(){
        System.out.println("TRANSFER CHECK");
        System.out.println("Transfer from card: " + card.cardNumber);
        System.out.println("Date: " + transferDate);
        System.out.println("Amount: " + transferAmount);





    }
}