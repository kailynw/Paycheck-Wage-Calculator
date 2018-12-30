package com.williams.kailyn.wagecalculator_better_interface;

import java.util.ArrayList;
import java.util.HashMap;

public class StateTaxSpinner {
    public HashMap map= new HashMap();

    public StateTaxSpinner(){
        addedStates();
    }

    public void addedStates() {
        map.put("Alabama", 2.5);
        map.put("Alaska", 4.05);
    }

}
