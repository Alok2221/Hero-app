package com.exercise.superheroapp.service;

import com.exercise.superheroapp.dto.HeroDtoRequest;
import com.exercise.superheroapp.dto.HeroDtoResponse;

import java.util.List;

public interface HeroService {

    List<HeroDtoResponse> get(String firstName);

    HeroDtoResponse get(Long id);

    HeroDtoResponse save(HeroDtoRequest heroDtoRequest);

    HeroDtoRequest update(Long id, HeroDtoRequest heroDtoRequest);

    void delete(Long id);
}