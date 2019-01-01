package com.williams.kailyn.wagecalculator_better_interface;

import java.util.HashMap;

public class StateTax {
    private HashMap<String,Double> map= new HashMap<>();

    public StateTax(){
        addedStates();
    }

    private void addedStates() {

        map.put("Alabama", .0901);
        map.put("Alaska", .0176);
        map.put("Arizona",.0825);
        map.put("Arkansas",.0930);
        map.put("California", .0825);
        map.put("Colorado",.075);
        map.put("Connecticut",.0635);
        map.put("Delaware", 0.00);
        map.put("Florida",.068);
        map.put("Georgia",.070 );
        map.put("Hawaii",.0435 );
        map.put("Idaho", .0603);
        map.put("Illinois",.0864);
        map.put("Indiana",.0700);
        map.put("Iowa",.068);
        map.put("Kansas",.0862);
        map.put("Kentucky", .06);
        map.put("Louisiana",.0998);
        map.put("Maine", .055);
        map.put("Maryland",.06);
        map.put("Massachusetts",.0625);
        map.put("Michigan",.06);
        map.put("Minnesota",.073);
        map.put("Missouri",.0789);
        map.put("Montana",0.00);
        map.put("Nebraska",.0689);
        map.put("Nevada",.0798);
        map.put("New Hampshire",0.00);
        map.put("New Jersey", .0685);
        map.put("New Mexico",  .0755);
        map.put("New York", .0849);
        map.put("North Carolina",.069);
        map.put("North Dakota",.0678);
        map.put("Ohio", .0714);
        map.put("Oklahoma",.0886);
        map.put("Oregon",0.00);
        map.put("Pennsylvania",.0634);
        map.put("Rhode Island",.07);
        map.put("South Carolina", .0722);
        map.put("South Dakota", .0639);
        map.put("Tennessee",.0946);
        map.put("Texas",.0819);
        map.put("Utah", .0676);
        map.put("Vermont",.0618);
        map.put("Virginia",.0563);
        map.put("Washington", .0892);
        map.put("West Virginia",.0629);
        map.put("Wisconsin",.0542);
        map.put("Wyoming",.0540);
        map.put("D.C.",.0575);



    }

    public double getTaxPercentage(String state){

        return map.get(state);
    }
}
