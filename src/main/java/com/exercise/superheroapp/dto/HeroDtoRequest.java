package com.exercise.superheroapp.dto;

import com.exercise.superheroapp.entity.HeroEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeroDtoRequest {

    private String firstName;
    private String lastName;
    private String nickName;

    public HeroDtoRequest() {
    }

    public HeroDtoRequest(HeroEntity heroEntity) {
        this.firstName = heroEntity.getFirstName();
        this.lastName = heroEntity.getLastName();
        this.nickName = heroEntity.getNickName();
    }
}