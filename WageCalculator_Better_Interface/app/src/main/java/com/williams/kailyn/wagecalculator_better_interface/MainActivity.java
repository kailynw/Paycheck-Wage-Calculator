package com.williams.kailyn.wagecalculator_better_interface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SeekBar hourlyRateSeek;
    private Spinner spinner;
    private SeekBar hoursSeek;
    private EditText hourlyRate;
    private EditText hours;
    private TextView result;
    private Button calculateButton;
    private StateTax stateTax= new StateTax(); //Gets state tax by matching spinner choice(State) with key-value pair(Tax Percentage)
    private double tax=0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Spinner
        spinner= findViewById(R.id.stateSpinner);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.States,android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        String state= spinner.getSelectedItem().toString(); //Gets Item from spinner
        tax= stateTax.getTaxPercentage(state);




        //SeekBars
        hourlyRateSeek= findViewById(R.id.hourlyRateSeek);
        hoursSeek= findViewById(R.id.hoursSeek);

        //TextFields
        hourlyRate= findViewById(R.id.hourlyRate);
        hours= findViewById(R.id.hours);


        //Functions for SeekBar
        HourlyFunctions hourlyFunctions = new HourlyFunctions(hourlyRateSeek,hoursSeek);
        hourlyFunctions.changeHours(hours);
        hourlyFunctions.changeWage(hourlyRate);
        calculateWage();
    }


    public void calculateWage(){
        calculateButton= findViewById(R.id.calculateButton);
        result= findViewById(R.id.result);


        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String state= spinner.getSelectedItem().toString(); //Gets Item from spinner
                tax= stateTax.getTaxPercentage(state);  //Tax for each state
                if(isNullTextFields(hourlyRate,hours))
                    return;
                double wage= Double.parseDouble(hourlyRate.getText().toString());
                double hrs= Double.parseDouble(hours.getText().toString());
                WageCalculator wageCalculator= new WageCalculator(wage, hrs);

                result.setText(tax+" ");
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
}
