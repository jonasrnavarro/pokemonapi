package com.exam.pokemonapi.controller;

import com.exam.pokemonapi.model.Pokemon;
import com.exam.pokemonapi.service.PokemonService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/{name}")
    public Pokemon getPokemonByName(@PathVariable @NotNull String name) {
        return pokemonService.getPokemon(name);
    }

    @GetMapping("/id/{id}")
    public Pokemon getPokemonById(@PathVariable int id) {
        return pokemonService.getPokemonById(id);
    }
}
