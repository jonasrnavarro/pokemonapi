package com.exam.pokemonapi.service;

import com.exam.pokemonapi.dto.PokemonDTO;
import com.exam.pokemonapi.exception.PokemonNotFoundException;
import com.exam.pokemonapi.model.Pokemon;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;

@Service
public class PokemonService {
    private static final String POKE_API_URL = "https://pokeapi.co/api/v2/pokemon/";

    private final RestTemplate restTemplate;

    public PokemonService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Pokemon getPokemon(@NotNull String name) {
        String url = POKE_API_URL + name.toLowerCase();

        try {
            PokemonDTO pokemonDTO = restTemplate.getForObject(url, PokemonDTO.class);
            return mapToPokemon(pokemonDTO);
        } catch (HttpClientErrorException.NotFound e) {
           throw new PokemonNotFoundException(name + " not found.");
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while getting data from PokeAPI.");
        }
    }

    public Pokemon getPokemonById(int id) {
        String url = POKE_API_URL + id;
        try {
            PokemonDTO pokemonDTO = restTemplate.getForObject(url, PokemonDTO.class);
            return mapToPokemon(pokemonDTO);
        } catch (HttpClientErrorException.NotFound e) {
            throw new PokemonNotFoundException(id + " not found.");
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while getting data from PokeAPI.");
        }
    }

    private Pokemon mapToPokemon(PokemonDTO pokemonDTO) {
        Pokemon pokemon = new Pokemon();
        pokemon.setId(pokemonDTO.getId());
        pokemon.setName(pokemonDTO.getName());
        pokemon.setTypes(pokemonDTO.getTypes().stream().map(type -> type.getType().getName()).collect(Collectors.toList()));

        pokemon.setMoves(pokemonDTO.getMoves().stream().limit(4).map(move -> move.getMove().getName()).collect(Collectors.toList()));
        return pokemon;
    }
}
