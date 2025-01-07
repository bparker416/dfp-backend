package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository.PizzaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<Pizza> getAllPizza() {
        return pizzaRepository.findAll();
    }

    public List<Pizza> getAllActivePizza() { return pizzaRepository.findAllActive(); }

    public Pizza createPizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public Optional<Pizza> getPizzaById(int id) {
        return pizzaRepository.findById(id);
    }

    public Pizza updatePizza(int id, Pizza pizza) {
        return pizzaRepository.findById(id)
                .map(item -> {
                    item.setPizza_name(pizza.getPizza_name());
                    item.setSmall_price(pizza.getSmall_price());
                    item.setLarge_price(pizza.getLarge_price());
                    item.setPizza_description(pizza.getPizza_description());
                    item.setAdditional_text(pizza.getAdditional_text());
                    item.setPizza_active(pizza.isPizza_active());
                    return pizzaRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found."));
    }

    public void deletePizza(int id) {
        pizzaRepository.deleteById(id);
    }

    // Toggle pizza_active
    public Pizza togglePizzaActive(int id) {
        return pizzaRepository.findById(id)
                .map(item -> {
                    item.setPizza_active(!item.isPizza_active());
                    return pizzaRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found."));
    }
}