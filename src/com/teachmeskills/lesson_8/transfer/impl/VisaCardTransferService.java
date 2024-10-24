package com.teachmeskills.lesson_8.transfer.impl;

import com.teachmeskills.lesson_8.model.account.Account;
import com.teachmeskills.lesson_8.model.card.BaseCard;
import com.teachmeskills.lesson_8.model.document.Check;
import com.teachmeskills.lesson_8.transfer.CardTransferService;
import com.teachmeskills.lesson_8.utils.Constants;

import java.util.Date;

public class VisaCardTransferService implements CardTransferService {

    @Override
    public Check transferFromCardToCard(BaseCard sendingCard, BaseCard receivingCard, int amountTransfer) {
        return processTransfer(sendingCard, receivingCard, amountTransfer);
    }

    @Override
    public Check transferFromCardToAccount(BaseCard sendingCard, Account receivingAccount, int amountTransfer) {
        return processTransfer(sendingCard, receivingAccount, amountTransfer);
    }

    private Check processTransfer(BaseCard sendingCard, Object receivingEntity, int amountTransfer) {
        if (amountTransfer < 0) {
            System.out.println("Transfer amount cannot be negative.");
            return null;
        }

        if (!sendingCard.checkCardLimitTransfer(amountTransfer)) {
            System.out.println("Transfer limit exceeded. Amount: " + amountTransfer +
                    ", Limit: " + Constants.TRANSFER_LIMIT_VISA_CARD);
            return new Check(0, new Date(), sendingCard);
        }

        if (sendingCard.amount < amountTransfer) {
            System.out.println("Insufficient funds. Available: " + sendingCard.amount +
                    ", Requested: " + amountTransfer);
            return new Check(0, new Date(), sendingCard);
        }

        sendingCard.amount -= amountTransfer;
        if (receivingEntity instanceof BaseCard) {
            ((BaseCard) receivingEntity).amount += amountTransfer;
        } else if (receivingEntity instanceof Account) {
            ((Account) receivingEntity).amount += amountTransfer;
        }

        return new Check(amountTransfer, new Date(), sendingCard);
    }
}