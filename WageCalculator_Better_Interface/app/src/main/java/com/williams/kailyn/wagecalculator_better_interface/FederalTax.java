package com.williams.kailyn.wagecalculator_better_interface;

public class FederalTax {

    private String status;
    private double salary;

    public FederalTax(String status, double salary){
        this.status=status;
        this.salary=salary;
    }

    public double getFederalTaxPerc() {
        switch (status) {
            case "Single":
                return singlePerc();
            case "Married (Jointly)":
                return marriedFilingJointPerc();
            case "Married (Separately)":
                return marriedFilingSeperatePerc();
            case "Head of Household":
                return headOfHouseholdPerc();
        }
        return -1;
    }

    private double marriedFilingJointPerc(){
        if(salary>0 && salary<=19050)
            return .10;
        else if(salary>19050 && salary<=77400)
            return .12;
        else if(salary>77400 && salary<=165000)
            return .22;
        else if(salary>165000 && salary<=315000)
            return .24;
        else if(salary>315000 && salary<=400000)
            return .32;
        else if(salary>400000 && salary<=600000)
            return .35;
        else
            return .37;
    }

    private double singlePerc(){
        if(salary>0 && salary<=9525)
            return .10;
        else if(salary>9525 && salary<=38700)
            return .12;
        else if(salary>38700 && salary<=82500)
            return .22;
        else if(salary>82500 && salary<=157500)
            return .24;
        else if(salary>157500 && salary<=200000)
            return .32;
        else if(salary>200000 && salary<=500000)
            return .35;
        else
            return .37;
    }

    private double marriedFilingSeperatePerc(){

        if(salary>0 && salary<=9525)
            return .10;
        else if(salary>9525 && salary<=38700)
            return .12;
        else if(salary>38700 && salary<=82500)
            return .22;
        else if(salary>82500 && salary<=157500)
            return .24;
        else if(salary>157500 && salary<=200000)
            return .32;
        else if(salary>200000 && salary<=300000)
            return .35;
        else
            return .37;
    }

    private double headOfHouseholdPerc(){
        if(salary>0 && salary<=13600)
            return .10;
        else if(salary>13600 && salary<=51800)
            return .12;
        else if(salary>51800 && salary<=82500)
            return .22;
        else if(salary>82500 && salary<=157500)
            return .24;
        else if(salary>157500 && salary<=200000)
            return .32;
        else if(salary>200000 && salary<=500000)
            return .35;
        else
            return .37;
    }
}