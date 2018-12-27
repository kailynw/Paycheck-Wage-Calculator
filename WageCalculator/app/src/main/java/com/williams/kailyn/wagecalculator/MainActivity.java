package com.williams.kailyn.wagecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button= findViewById(R.id.calcButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText hourlyPayInput= findViewById(R.id.hourlyPayInput);
                EditText hourInput= findViewById(R.id.hourInput);
                TextView output= findViewById(R.id.output);

                if(isNullTextFields(hourlyPayInput,hourInput)){
                    Toast.makeText(getApplicationContext(),"Empty Text Field", Toast.LENGTH_SHORT);
                    return;
                }
                double wage= Double.parseDouble(hourlyPayInput.getText().toString());
                double hour= Double.parseDouble(hourInput.getText().toString());

                WageCalculator calc= new WageCalculator(wage,hour);
                output.setText(calc.wageCalc() +" ");
            }
        });



    }

    public boolean isNullTextFields(EditText text1, EditText text2){

        if(TextUtils.isEmpty(text1.toString())|| TextUtils.isEmpty(text2.toString())){
            return true;
        }
        else return false;
    }


}
