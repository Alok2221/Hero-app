package com.exercise.superheroapp.dto;

import com.exercise.superheroapp.entity.HeroEntity;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;

@Getter
public class HeroDtoResponse {

    private Long id;

    @JsonUnwrapped
    private final HeroDtoRequest heroDtoRequest;

    public HeroDtoResponse(HeroEntity heroEntity) {
        this.id = heroEntity.getId();
        this.heroDtoRequest = new HeroDtoRequest(heroEntity);
    }
}