package com.hellospring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class Counter {

    @GetMapping("/")
    public String home(HttpSession session) {
        Integer counter = (Integer) session.getAttribute("counter");
        if (counter == null) {
            counter = 0;
        }
        counter++;
        session.setAttribute("counter", counter);
        return "home";
    }

    @GetMapping("/counter")
    public String counter(HttpSession session, Model model) {
        Integer counter = (Integer) session.getAttribute("counter");
        if (counter == null) {
            counter = 0;
        }
        model.addAttribute("counter", counter);
        return "counter";
    }
    @GetMapping("/incrementByTwo")
    public String incrementByTwo(HttpSession session) {
        Integer counter = (Integer) session.getAttribute("counter");
        if (counter == null) {
            counter = 0;
        }
        counter += 2;
        session.setAttribute("counter", counter);
        return "incrementByTwo";
    }

    @PostMapping("/reset")
    public String reset(HttpSession session) {
        session.setAttribute("counter", 0);
        return "redirect:/counter";
    }
}
