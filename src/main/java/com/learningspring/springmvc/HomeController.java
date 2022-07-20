package com.learningspring.springmvc;

import model.Alien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController
{
    @RequestMapping("/")
    public String home(){
        return "index";
    }
    @RequestMapping("add")
    public ModelAndView add(@RequestParam("num1") int i, @RequestParam("num2") int j){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("result");
        int sum = i+j;
        mv.addObject("num3", sum);
        return mv;
    }
    @PostMapping("addAlien")
    public String addAlien( @ModelAttribute Alien a, Model m){

        m.addAttribute("alien", a);
        return "result";
    }
    @GetMapping("getAliens")
    public String getAliens(Model m){
        List<Alien> aliens = Arrays.asList(new Alien(007, "Kumar"), new Alien(  12, "Abhishek"));
        m.addAttribute("result", aliens);
        return "showAliens";
    }
}
