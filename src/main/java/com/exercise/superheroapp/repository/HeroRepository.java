package com.exercise.superheroapp.repository;

import com.exercise.superheroapp.entity.HeroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroRepository extends JpaRepository<HeroEntity, Long> {

    List<HeroEntity> getAllByFirstName(String firstName);
}