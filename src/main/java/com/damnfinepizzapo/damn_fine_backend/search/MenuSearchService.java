package com.damnfinepizzapo.damn_fine_backend.search;

import com.damnfinepizzapo.damn_fine_backend.drinks_menu.repository.DrinkRepository;
import com.damnfinepizzapo.damn_fine_backend.drinks_menu.repository.HouseCocktailRepository;
import com.damnfinepizzapo.damn_fine_backend.drinks_menu.repository.LibationRepository;
import com.damnfinepizzapo.damn_fine_backend.drinks_menu.repository.MocktailRepository;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository.*;
import org.hibernate.mapping.Any;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuSearchService {
    private final DrinkRepository drinkRepository;
    private final HouseCocktailRepository houseCocktailRepository;
    private final MocktailRepository mocktailRepository;
    private final LibationRepository libationRepository;
    private final AppetizerRepository appetizerRepository;
    private final CheeseRepository cheeseRepository;
    private final DessertRepository dessertRepository;
    private final MeatRepository meatRepository;
    private final PizzaRepository pizzaRepository;
    private final SaladRepository saladRepository;
    private final SandoRepository sandoRepository;
    private final SauceRepository sauceRepository;
    private final SideRepository sideRepository;
    private final VeggieRepository veggieRepository;

    public MenuSearchService(
            DrinkRepository drinkRepository,
            HouseCocktailRepository houseCocktailRepository,
            MocktailRepository mocktailRepository,
            LibationRepository libationRepository,
            AppetizerRepository appetizerRepository,
            CheeseRepository cheeseRepository,
            DessertRepository dessertRepository,
            MeatRepository meatRepository,
            PizzaRepository pizzaRepository,
            SaladRepository saladRepository,
            SandoRepository sandoRepository,
            SauceRepository sauceRepository,
            SideRepository sideRepository,
            VeggieRepository veggieRepository
    ) {
        this.drinkRepository = drinkRepository;
        this.houseCocktailRepository = houseCocktailRepository;
        this.mocktailRepository = mocktailRepository;
        this.libationRepository = libationRepository;
        this.appetizerRepository = appetizerRepository;
        this.cheeseRepository = cheeseRepository;
        this.dessertRepository = dessertRepository;
        this.meatRepository = meatRepository;
        this.pizzaRepository = pizzaRepository;
        this.saladRepository = saladRepository;
        this.sandoRepository = sandoRepository;
        this.sauceRepository = sauceRepository;
        this.sideRepository = sideRepository;
        this.veggieRepository = veggieRepository;
    }

    public List<String> searchMenu(String name) {
        List<String> results = new ArrayList<>();
        results.addAll(drinkRepository.searchByDrinkName(name));
        results.addAll(houseCocktailRepository.searchByCocktailName(name));
        results.addAll(mocktailRepository.searchByMocktailName(name));
        results.addAll(libationRepository.searchByLibationName(name));
        results.addAll(appetizerRepository.searchByAppName(name));
        results.addAll(cheeseRepository.searchByCheeseName(name));
        results.addAll(dessertRepository.searchByDessertName(name));
        results.addAll(meatRepository.searchByMeatName(name));
        results.addAll(pizzaRepository.searchByPizzaName(name));
        results.addAll(saladRepository.searchBySaladName(name));
        results.addAll(sandoRepository.searchBySandoName(name));
        results.addAll(sauceRepository.searchBySauceName(name));
        results.addAll(sideRepository.searchBySideName(name));
        results.addAll(veggieRepository.searchByVeggieName(name));
        return results;
    }
}
