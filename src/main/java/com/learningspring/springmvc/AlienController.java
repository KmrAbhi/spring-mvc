package com.learningspring.springmvc;

import com.learningspring.springmvc.model.Alien;
import com.learningspring.springmvc.repository.AlienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlienController {
    @Autowired
    AlienRepository alienRepository;
    @GetMapping("aliens")
    public List<Alien> getAliens(){

        return alienRepository.findAll();
    }

    @GetMapping("alien/{id}")
    public Optional<Alien> getAlien(@PathVariable Integer id){
        return alienRepository.findById(id);
    }

    @PostMapping("createAlien")
    public Alien saveAlien(@RequestBody Alien alien){
        return alienRepository.save(alien);
    }
}
