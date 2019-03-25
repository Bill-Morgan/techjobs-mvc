package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

import static org.launchcode.models.JobData.*;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController extends TechJobsController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("searchType", "all");
//        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }


    // TODO #1 - Create handler to process search request and display results
    @RequestMapping(value = "results")
    public String results(@RequestParam String searchType, @RequestParam String searchTerm, Model model){

        model.addAttribute("searchType", searchType);
//        model.addAttribute("columns", ListController.columnChoices);
        model.addAttribute("searchTerm", searchTerm);
        if (searchType.equals(("all"))) {
            model.addAttribute("jobs", findByValue(searchTerm));
        } else {
            model.addAttribute("jobs", findByColumnAndValue(searchType, searchTerm));
        }
        return "search";
    }

}
