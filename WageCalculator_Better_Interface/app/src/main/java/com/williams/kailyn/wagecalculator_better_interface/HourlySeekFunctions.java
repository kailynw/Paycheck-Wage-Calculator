package com.williams.kailyn.wagecalculator_better_interface;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

////////////////////////////////////////
// Functions for Hourly Employee SeekBar
//  **Changes Wage and Hours
////////////////////////////////////////

public class HourlySeekFunctions {

    private SeekBar hourlyRateSeek;
    private SeekBar hoursSeek;
    private TextView preTaxedText;
    private EditText hours;
    private EditText hourlyRate;

    public HourlySeekFunctions(SeekBar hourlyRateSeek, SeekBar hoursSeek, TextView preTaxedText, EditText hours, EditText hourlyRate){
        this.hourlyRateSeek = hourlyRateSeek;
        this.hoursSeek =hoursSeek;
        this.preTaxedText = preTaxedText;
        this.hours= hours;
        this.hourlyRate=hourlyRate;

    }

    //Change Wage using seekBar
    public void changeWage( ) {
        hourlyRateSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String total = progress + "";
                hourlyRate.setText(total);
                if(isNullTextFields()) {
                    return;
                }
                else{
                    String money = moneyFormat(new WageCalculator(Double.parseDouble(hourlyRate.getText().toString()), Double.parseDouble(hours.getText().toString())).wageCalc() + "");
                    preTaxedText.setText("Pre-Taxed: " +money);
                }



            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }


        // Change Hours using seekBar
        public void changeHours( ) {
            hoursSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    String total= progress+"";
                    hours.setText(total);

                    if(isNullTextFields()) {
                        return;
                    }
                    else{
                        String money= moneyFormat(new WageCalculator(Double.parseDouble(hourlyRate.getText().toString()), Double.parseDouble(hours.getText().toString())).wageCalc() + "");
                        preTaxedText.setText("Pre-Taxed: "+ money);
                    }






                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) { }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) { }
            });
        }

    private  String moneyFormat(String string){
        double number= Double.parseDouble(string);
        NumberFormat numberFormat= NumberFormat.getCurrencyInstance(Locale.US);

        return numberFormat.format(number);
    }

    public boolean isNullTextFields(){
        if(TextUtils.isEmpty(hours.getText().toString())||TextUtils.isEmpty(hourlyRate.getText().toString()))
            return true;
        else
            return false;
    }
}
//                            }