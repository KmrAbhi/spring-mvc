package com.learningspring.springmvc.repository;

import com.learningspring.springmvc.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AlienRepository extends JpaRepository<Alien, Integer> {
}
