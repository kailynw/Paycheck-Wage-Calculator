package com.williams.kailyn.wagecalculator_better_interface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SeekBar hourlyRateSeek;
    private SeekBar hoursSeek;
    private EditText hourlyRate;
    private EditText hours;
    private TextView result;
    private Button calculateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SeekBars
        hourlyRateSeek= findViewById(R.id.hourlyRateSeek);
        hoursSeek= findViewById(R.id.hoursSeek);

        //TextFields
        hourlyRate= findViewById(R.id.hourlyRate);
        hours= findViewById(R.id.hours);

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
                if(isNullTextFields(hourlyRate,hours))
                    return;
                double wage= Double.parseDouble(hourlyRate.getText().toString().substring(1));
                double hrs= Double.parseDouble(hours.getText().toString());
                WageCalculator wageCalculator= new WageCalculator(wage, hrs);

                result.setText(wageCalculator.wageCalc()+" ");
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
