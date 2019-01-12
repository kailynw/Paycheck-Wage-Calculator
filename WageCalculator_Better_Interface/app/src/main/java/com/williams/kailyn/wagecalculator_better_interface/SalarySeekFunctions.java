package com.williams.kailyn.wagecalculator_better_interface;

import android.widget.EditText;
import android.widget.SeekBar;

public class SalarySeekFunctions {
    private SeekBar salarySeek;
    private EditText salary;

    public SalarySeekFunctions(SeekBar salarySeek, EditText salary){
        this.salary=salary;
        this.salarySeek=salarySeek;
        changeSalary();
    }

    private void changeSalary(){
        salarySeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String total= progress+"";
                salary.setText(total);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}

        });
    }
}
