package com.williams.kailyn.wagecalculator_better_interface;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class WageResults extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wage_results);


        //TextViews
        TextView preTaxedResult= findViewById(R.id.preTaxedResult);
        TextView federaTaxResult= findViewById(R.id.federalTaxResult);
        TextView stateTaxResult= findViewById(R.id.stateTaxResult);
        TextView afterTaxResult= findViewById(R.id.afterTaxResult);

        Intent intent= getIntent();
        Bundle extraInfo= intent.getExtras();
        if(extraInfo!=null) {
            preTaxedResult.setText(extraInfo.getString("PRE_TAX"));
            federaTaxResult.setText("-" + extraInfo.getString("FEDERAL_TAX"));
            stateTaxResult.setText("-" + extraInfo.getString("STATE_TAX"));
            afterTaxResult.setText(extraInfo.getString("SALARY"));
        }

    }
}
