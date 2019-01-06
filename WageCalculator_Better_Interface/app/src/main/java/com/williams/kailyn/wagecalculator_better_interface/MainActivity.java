package com.williams.kailyn.wagecalculator_better_interface;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private SeekBar hourlyRateSeek;
    private Spinner stateSpinner;
    private Spinner statusSpinner;
    private SeekBar hoursSeek;
    private EditText hourlyRate;
    private EditText hours;
    private TextView result;
    private TextView preTaxedText;
    private Button calculateButton;
    private RadioGroup payFrequencyGroup;
    private StateTax stateTax= new StateTax(); //Gets state tax by matching spinner choice(State) with key-value pair(State Tax Percentage)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //RadioButtons/ RadioGroup
        payFrequencyGroup= findViewById(R.id.payFrequencyGroup);

        //Spinner
        stateSpinner= findViewById(R.id.stateSpinner);
        ArrayAdapter<CharSequence> adapter1= ArrayAdapter.createFromResource(this,R.array.States,android.R.layout.simple_spinner_dropdown_item);
        stateSpinner.setAdapter(adapter1);

        statusSpinner= findViewById(R.id.statusSpinner);
        ArrayAdapter<CharSequence>  adapter2= ArrayAdapter.createFromResource(this,R.array.Martial_Status,android.R.layout.simple_spinner_dropdown_item);
        statusSpinner.setAdapter(adapter2);

        //SeekBars
        hourlyRateSeek= findViewById(R.id.hourlyRateSeek);
        hoursSeek= findViewById(R.id.hoursSeek);


        //TextFields
        hourlyRate= findViewById(R.id.hourlyRate);
        hours= findViewById(R.id.hours);


        //Functions for SeekBar
        preTaxedText= findViewById(R.id.preTaxedText);
        HourlySeekFunctions hourlySeekFunctions = new HourlySeekFunctions(hourlyRateSeek,hoursSeek,preTaxedText,hours,hourlyRate);
        hourlySeekFunctions.changeHours();
        hourlySeekFunctions.changeWage();
        calculateWage();
    }


    public void calculateWage(){
        calculateButton= findViewById(R.id.calculateButton);
        result= findViewById(R.id.result);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //State Tax Percentage
                String state= stateSpinner.getSelectedItem().toString(); //Gets Item from spinner
                double stateTaxPerc= stateTax.getTaxPercentage(state);  //Tax for each state

                //Federal Tax Status
                String status= statusSpinner.getSelectedItem().toString();

                //Pay Frequency
                int checked= payFrequencyGroup.getCheckedRadioButtonId();
                RadioButton radioButton= findViewById(checked);
                String payFrequency=radioButton.getText().toString();


                if(isNullTextFields(hourlyRate,hours))
                    return;
                double wage= Double.parseDouble(hourlyRate.getText().toString());
                double hrs= Double.parseDouble(hours.getText().toString());
                WageCalculator wageCalculator= new WageCalculator(wage, hrs);

                System.out.println(payFrequency);
                result.setText(salaryCalculation(wageCalculator.wageCalc(),status,stateTaxPerc,payFrequency));
            }
        });
    }

    //Checks if EditText fields are empty
    public boolean isNullTextFields(EditText text1, EditText text2){
        if(TextUtils.isEmpty(text1.getText().toString())|| TextUtils.isEmpty(text2.getText().toString())){
            Toast.makeText(getApplicationContext(), "Empty Fields", Toast.LENGTH_SHORT).show();
            return true;
        }
        else
            return false;
    }

    public String salaryCalculation(double salary, String status, double stateTaxPerc, String radioText){
        FederalTax federalTax= new FederalTax(status, salary);
        double taxedSalary= salary - (salary*(stateTaxPerc + federalTax.getFederalTaxPerc()));
        return moneyFormat(taxedSalary*payFrequencyAmount(radioText)+"");
    }

    public double payFrequencyAmount(String radioText){

        if(radioText.equals("Weekly"))
            return 52;
        else if(radioText.equals("Monthly"))
            return 12;
        else if(radioText.equals("Semi-Annual"))
            return 2;
        else
            return 1;
    }

    private  String moneyFormat(String string){
        double number= Double.parseDouble(string);
        NumberFormat numberFormat= NumberFormat.getCurrencyInstance(Locale.US);
        return numberFormat.format(number);
    }

}
