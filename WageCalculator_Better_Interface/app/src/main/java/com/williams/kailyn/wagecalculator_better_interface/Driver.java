package com.williams.kailyn.wagecalculator_better_interface;

import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Locale;

public class Driver {
    public static void main(String[]args){
        StateTax spinner= new StateTax();
        String helo="15050505";


    }

    public static String moneyFormat(String string){
        double number= Double.parseDouble(string);
        NumberFormat numberFormat= NumberFormat.getCurrencyInstance(Locale.US);

        return numberFormat.format(number);

    }
}
