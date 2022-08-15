package com.learningspring.springmvc;

import com.learningspring.springmvc.repository.AlienRepository;
import com.learningspring.springmvc.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Optional;


@Controller
public class HomeController
{
    @Autowired
    AlienRepository alienRepository;
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
        alienRepository.save(a);
        return "result";
    }
    @GetMapping("getAliens")
    public String getAliens(Model m){
        List<Alien> aliens = alienRepository.findAll();
        System.out.println(aliens);
        m.addAttribute("aliens", aliens);
        return "showAliens";
    }
    @GetMapping("getAlien")
    public String getAlien(@RequestParam int id, Model m){
        Optional<Alien> alien = alienRepository.findById(id);
        m.addAttribute("aliens", alien);
        return "showAliens";
    }
}
