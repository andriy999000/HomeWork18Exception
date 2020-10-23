package com.company;

import java.util.Arrays;

public class MoneyTransactionUtil {
    private MoneyTransactionUtil() {}
    private static int[] arrayId;
    private static BankCard[] arrayCard;

    public static BankCard converterId(int id){
        for (int i = 0; i < arrayId.length; i++) {
            if (arrayId[i] == id){
                return arrayCard[i];
            }

        }

        BankCard error = new BankCard(-1);
        return error;

    }

    public static void addCardArray(BankCard link){
        try {
            BankCard[] arrayD = Arrays.copyOf(arrayCard, arrayCard.length+1);
            int[] arrayD2 = Arrays.copyOf(arrayId, arrayId.length+1);

            arrayD[arrayD.length-1] = link;
            arrayD2[arrayD.length-1] = link.getId();

            arrayCard = arrayD;
            arrayId = arrayD2;

        }catch (NullPointerException e){
            arrayCard = new BankCard[1];
            arrayId = new int[1];
            arrayCard[0] = link;
            arrayId[0] = link.getId();


        }
    }



    public static boolean sendTo(int id1,int password,double moneySum,int id2) throws RuntimeException {
        if (id1 == id2){
            throw new AccountException ();
        }
        if (moneySum <= 0.0 || moneySum > 100000.0){
            throw new MoneyValueExeption();
        }


        if(converterId(id1).withdrawScore(password,moneySum)){
            converterId(id2).replenishment(moneySum);
            System.out.println("Сумма "+moneySum+", со счета " + id1 +
                    " успешно переведена на счет " + id2);
            return true;
        }
        return false;

    }

    public static void sendTo(int id1,double moneySum) throws RuntimeException {
        converterId(id1).replenishment(moneySum);
        if (moneySum <= 0.0 || moneySum > 100000.0){
            throw new MoneyValueExeption();
        }
    }
}
