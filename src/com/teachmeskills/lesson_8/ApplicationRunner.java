package com.teachmeskills.lesson_8;

import com.teachmeskills.lesson_8.document_parser.IParser;
import com.teachmeskills.lesson_8.fabric.ParserFabric;
import com.teachmeskills.lesson_8.model.account.Account;
import com.teachmeskills.lesson_8.model.card.BaseCard;
import com.teachmeskills.lesson_8.model.card.MasterCard;
import com.teachmeskills.lesson_8.model.card.VisaCard;
import com.teachmeskills.lesson_8.model.client.BaseClient;
import com.teachmeskills.lesson_8.model.client.IndividualClient;
import com.teachmeskills.lesson_8.model.client.LegalClient;
import com.teachmeskills.lesson_8.model.document.Check;
import com.teachmeskills.lesson_8.transfer.impl.MasterCardTransferService;
import com.teachmeskills.lesson_8.transfer.impl.VisaCardTransferService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ApplicationRunner {
    public static void main(String[] args) {
        System.out.print("Enter the path to the file: ");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();

        try {
            IParser parser = ParserFabric.createParser(filePath);
            parser.parseFile(filePath);

            List<BaseClient> clients = new ArrayList<>();
            clients.add(new IndividualClient("Client_001", new Account[]{
                    new Account("11831111MTB", 3200), new Account("000012", 135)},
                    new BaseCard[]{
                            new MasterCard("0000AA", 100, new Date(), "Client_1", "USD", "RUB", 1200),
                            new VisaCard("0002AC", 120, new Date(), "Client_1", "USD", 2, 430)}));
            clients.add(new LegalClient("Client_002", new Account[]{
                    new Account("22222222ALFA", 4300), new Account("000022", 1200)},
                    new BaseCard[]{
                            new MasterCard("0003AB", 700, new Date(), "Client_2", "EUR", "RUB", 800),
                            new VisaCard("0004FB", 190, new Date(), "Client_2", "EUR", 1, 700)}));
            clients.add(new IndividualClient("Client_003", new Account[]{
                    new Account("00003100VTB", 3000), new Account("000032", 500)},
                    new BaseCard[]{
                            new MasterCard("0005VA", 331, new Date(), "Client_3", "USD", "RUB", 1500),
                            new VisaCard("0006BN", 676, new Date(), "Client_3", "USD", 3, 400)}));
            clients.add(new LegalClient("Client_004", new Account[]{
                    new Account("00550041BLB", 8000), new Account("000042", 2000)},
                    new BaseCard[]{
                            new MasterCard("0007MP", 441, new Date(), "Client_4", "GBP", "RUB", 900),
                            new VisaCard("0008BY", 442, new Date(), "Client_4", "GBP", 4, 600)}));

            performTransfers(clients);

        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void performTransfers(List<BaseClient> clients) {
        MasterCardTransferService masterCardTransfer = new MasterCardTransferService();
        VisaCardTransferService visaCardTransfer = new VisaCardTransferService();

        transferBetweenCards(masterCardTransfer, (MasterCard) clients.get(0).getCards()[0], (MasterCard) clients.get(1).getCards()[0], 200);
        transferFromCardToAccount(visaCardTransfer, (VisaCard) clients.get(1).getCards()[1], clients.get(0).getAccounts()[1], 100);
        transferBetweenCards(masterCardTransfer, (MasterCard) clients.get(2).getCards()[0], (MasterCard) clients.get(3).getCards()[0], 300);
        transferFromCardToAccount(visaCardTransfer, (VisaCard) clients.get(3).getCards()[1], clients.get(2).getAccounts()[1], 150);
    }

    private static void transferBetweenCards(MasterCardTransferService transferService, MasterCard fromCard, MasterCard toCard, int amount) {
        fromCard.showBaseInfo();
        Check check = transferService.transferFromCardToCard(fromCard, toCard, amount);
        check.showCheckInfo();
        fromCard.showBaseInfo();
    }

    private static void transferFromCardToAccount(VisaCardTransferService transferService, VisaCard fromCard, Account toAccount, int amount) {
        fromCard.showBaseInfo();
        Check check = transferService.transferFromCardToAccount(fromCard, toAccount, amount);
        check.showCheckInfo();
        fromCard.showBaseInfo();
    }
}