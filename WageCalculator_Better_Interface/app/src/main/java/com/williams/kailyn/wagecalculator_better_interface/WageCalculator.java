package com.williams.kailyn.wagecalculator_better_interface;// WageCalculator.java           Author: B. Rowe
// Performs approximate calculations for pay based on 
// hourly wage and number of hours.

public class WageCalculator
{
   private double hrlyWage = 0.00;
   private double weeklyHours = 0.00;
   private double weeklySalary = 0.00;
   private final double FULLTIMEHOURS = 40;

   public WageCalculator(double wage, double hrs)
   {
      hrlyWage = wage;
      weeklyHours = hrs;
   }   
   
   public double wageCalc()
   {
      double result = 0.00;
      double OTHours = weeklyHours - FULLTIMEHOURS;
      double OTPayRate = hrlyWage * 1.5;
      double OTWage = OTHours * OTPayRate;
      double RegWage = FULLTIMEHOURS * hrlyWage;
      
      if (weeklyHours <= FULLTIMEHOURS)
      {
         result = hrlyWage * weeklyHours;
      }
      else
      {
         result = RegWage + OTWage;
      }
      return result;
   }
}