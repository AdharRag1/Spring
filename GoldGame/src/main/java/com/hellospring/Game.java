package com.hellospring;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

public class Game {

    @GetMapping("/")
    public String index(HttpSession session, Model model) {
        if (session.getAttribute("gold") == null) {
            session.setAttribute("gold", 0);
            session.setAttribute("activities", new ArrayList<String>());
        }
        model.addAttribute("gold", session.getAttribute("gold"));
        model.addAttribute("activities", session.getAttribute("activities"));
        return "index";
    }

  
	@PostMapping("/process")
    public String process(HttpSession session, String place) {
        Random rand = new Random();
        int gold = (int) session.getAttribute("gold");
        List<String> activities = (List<String>) session.getAttribute("activities");
        int earnings = 0;
        String activity = "";

        switch (place) {
            case "farm":
                earnings = rand.nextInt(11) + 10; 
                activity = "You entered a farm and earned " + earnings + " gold";// need JS function to add time ?? 
                break;
            case "cave":
                earnings = rand.nextInt(6) + 5; 
                activity = "You entered a cave and earned " + earnings + " gold";
                break;
            case "house":
                earnings = rand.nextInt(4) + 2;
                activity = "You entered a house and earned " + earnings + " gold";
                break;
            case "quest":
                earnings = rand.nextInt(101) - 50; 
                if (earnings >= 0) {
                    activity = "You went on a quest and earned " + earnings + " gold";
                } else {
                    activity = "You went on a quest and lost " + Math.abs(earnings) + " gold. OUCH";// css to master colors... or bootstrap
                }
                break;
        }

        gold += earnings;
        activities.add(0, activity); 
        session.setAttribute("gold", gold);
        session.setAttribute("activities", activities);

        return "redirect:/";
    }
}
