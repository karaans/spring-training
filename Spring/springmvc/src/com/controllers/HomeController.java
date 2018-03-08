package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping
    public String handleRequest() {
        System.out.println("HomeController.handleRequest");
        return "index";
    }

    @RequestMapping("/message")
    public ModelAndView handleMessageRequest(@RequestParam String message, HttpServletResponse response) {
        System.out.println("HomeController.handleMessageRequest: " + message);
        String formattedMessage = "Welcome " + message;
        Cookie cookie = new Cookie("myCookie", "Hello " + message);
        response.addCookie(cookie);
        return new ModelAndView("index", "fMsg", formattedMessage);
    }

    @RequestMapping("/cookie")
    public String handleCookieRequest(@CookieValue("myCookie") String myCookie, Model model) {
        System.out.println("HomeController.handleCookieRequest");
        model.addAttribute("testCookie",myCookie);
        return "index";
    }
}
