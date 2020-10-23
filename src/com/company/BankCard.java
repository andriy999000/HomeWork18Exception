package com.company;

import java.util.Random;

public class BankCard {
    private int id;
    private int cash_account = 0;
    private int cash_account_PENNIES = 0;
    private int password;
    private boolean b = true;
    //private BankCard[] arrayCard;
    public static int numberСards = 0;




//    {
//        while (cash_account_PENNIES >= 100){
//            cash_account_PENNIES -= 100;
//            cash_account++;
//
//        }
//    }


    public BankCard() {
        int value = 1000;
        Random r = new Random();
        value += r.nextInt(999);
        id = value;
        value = 1000 + r.nextInt(999);
        password = value;
        numberСards++;
        //arrayCard = new BankCard[numberСards];




    }
    public BankCard(int key){
        if (key == -1){
            b = false;
            id = -1;
        }
    }

    public int getId() {
        return id;
    }

    public double getCashaccount(){
        double z = (double)cash_account;
        double x = (double)cash_account_PENNIES / 100;

        return z + x;
    }


    public void replenishment(double money){
        if(id != -1) {
            int arr[] = calculation(money);
            while (arr[1] >= 100) {
                arr[1] -= 100;
                arr[0]++;
            }
            this.cash_account = +arr[0];
            this.cash_account_PENNIES = +arr[1];
        }else {
            throw new RuntimeException();
        }




    }

    private static int[] calculation(double v){
        int[] arr = new int[2];
        arr[0] = (int)v;
        double a  = ((v - (double)arr[0]) * 100) + 1;
        arr[1] = (int)a;
        return arr;

    }


    public boolean withdrawScore(int password,double summ){
        if (this.password == password || id != -1){
            if (summ <= this.getCashaccount()){

                int arr[] = calculation(summ);


                this.cash_account -= arr[0];
                this.cash_account_PENNIES -= arr[1];
                return true;

            }
        }
        return false;

    }


    public int[] cardRegistrationData(BankCard link){
        if (b) {
            int[] a = {id, password};
            MoneyTransactionUtil.addCardArray(link);
            b = false;
            return a;
        }
        System.out.println("Попытка повторного получения пароля и номера карты\nСработала зашита от взлома");
        int[] ar = {-1};
        return ar;

    }






}
