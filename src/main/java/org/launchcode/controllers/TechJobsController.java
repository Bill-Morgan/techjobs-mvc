package org.launchcode.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

public class TechJobsController {

    private static HashMap<String, String> actionChoices = createActionChoices();
    private static HashMap<String, String> columnChoices = createColumnChoices();


    private static HashMap<String, String> createActionChoices() {
        HashMap<String,String> myMap = new HashMap<>();
        myMap.put("search", "Search");
        myMap.put("list", "List");
        return myMap;
    }

    private static HashMap<String, String> createColumnChoices() {
        HashMap<String, String> myMap = new HashMap<>();
        myMap.put("core competency", "Skill");
        myMap.put("employer", "Employer");
        myMap.put("location", "Location");
        myMap.put("position type", "Position Type");
        myMap.put("all", "All");
        return myMap;
    }

    @ModelAttribute("actions")
    public static HashMap<String, String> getActionChoices() {
        return actionChoices;
    }

    @ModelAttribute("columns")
    public static HashMap<String, String> getColumnChoices() {
        return columnChoices;
    }

    public static String getColumnChoicesValue(String column){
        return columnChoices.get(column);
    }

}
