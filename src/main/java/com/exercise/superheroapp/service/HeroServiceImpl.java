package com.exercise.superheroapp.service;

import com.exercise.superheroapp.dto.HeroDtoRequest;
import com.exercise.superheroapp.dto.HeroDtoResponse;
import com.exercise.superheroapp.entity.HeroEntity;
import com.exercise.superheroapp.repository.HeroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@Transactional
@RequiredArgsConstructor
public class HeroServiceImpl implements HeroService {

    private final HeroRepository heroRepository;

    @Override
    public List<HeroDtoResponse> get(String firstName) {
        return heroRepository.getAllByFirstName(firstName)
                .stream()
                .map(HeroDtoResponse::new)
                .collect(toList());
    }

    @Override
    public HeroDtoResponse get(Long id) {
        return new HeroDtoResponse(heroRepository.getById(id));
    }

    @Override
    public HeroDtoResponse save(HeroDtoRequest heroDtoRequest) {
        HeroEntity heroEntity = new HeroEntity();
        copyProperties(heroDtoRequest, heroEntity);
        HeroEntity saveHero = heroRepository.save(heroEntity);
        return new HeroDtoResponse(saveHero);
    }

    @Override
    public HeroDtoRequest update(Long id, HeroDtoRequest heroDtoRequest) {
        HeroEntity heroToUpdate = heroRepository.getById(id);
        copyProperties(heroDtoRequest, heroToUpdate);
        return new HeroDtoRequest(heroToUpdate);
    }

    @Override
    public void delete(Long id) {
        heroRepository.deleteById(id);
    }
}
