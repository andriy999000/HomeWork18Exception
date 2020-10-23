package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nЗадание 1");
        int[] arr = {1,5,3,2};
        ArrayExceptionTest.printArray(arr,-1,3);

        System.out.println("\nЗадание 2");

        BankCard card1 = new BankCard();
        int[] documents = card1.cardRegistrationData(card1);
        int id1 = documents[0];
        int password1 = documents[1];
        MoneyTransactionUtil.addCardArray(card1);

        BankCard card2 = new BankCard();
        int[] documents2 = card2.cardRegistrationData(card2);
        int id2 = documents2[0];
        int password2 = documents2[1];
        MoneyTransactionUtil.sendTo(id2,10000.99);

        System.out.println("Проверка до перевода денег: " + "\nБаланс карты 1 --->" + card1.getCashaccount() + "\nБаланс карты 1 --->" + card2.getCashaccount());
        System.out.println();
        System.out.print("Превод денег: ");
        try{
            MoneyTransactionUtil.sendTo(id2,password2,5000.55,id1);
        }catch (AccountException e){
            System.out.println("Ошибка с реквизитами банка.Возможно, номер карты отправителя и получателя совпадают");
        }catch (MoneyValueExeption e){
            System.out.println("Ошибка с суммой отправки.Сумма должна быть больше 0. Сумма не должна превышать лимит в 100 000");
        }
        System.out.println();

        System.out.println("Проверка после перевода денег:" + "\nБаланс карты 1 --->" + card1.getCashaccount() + "\nБаланс карты 1 --->" + card2.getCashaccount());

//        System.out.println("Чтобы перейти к следуйшему заданию(4) где образуется исключение нажмите Enter ");
//        String sc = scanner.nextLine();
        System.out.println("Задание 4");

        try {
            StackOverFlowTest.test();
        }catch (StackOverflowError e) {
            System.out.println("Произошла ошибка: " + e);
        }

        System.out.println("finish");
    }
}
