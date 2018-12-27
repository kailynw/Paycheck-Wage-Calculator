package com.williams.kailyn.wagecalculator_better_interface;

import android.widget.EditText;
import android.widget.SeekBar;

public class HourlyFunctions {

    private SeekBar hourlyRateSeek;
    private SeekBar hoursSeek;

    public HourlyFunctions(SeekBar hourlyRateSeek, SeekBar hoursSeek){
        this.hourlyRateSeek = hourlyRateSeek;
        this.hoursSeek =hoursSeek;

    }

    //Change Wage using seekBar
    public void changeWage( final EditText hourlyRate) {
        hourlyRateSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String total = progress + "";

                hourlyRate.setText(total);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


        // Change Hours using seekBar
        public void changeHours( final EditText hours) {
            hoursSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    String total= progress+"";

                    hours.setText(total);

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
        }
}
