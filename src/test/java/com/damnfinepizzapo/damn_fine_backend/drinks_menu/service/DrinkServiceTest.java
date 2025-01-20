package com.damnfinepizzapo.damn_fine_backend.drinks_menu.service;

import com.damnfinepizzapo.damn_fine_backend.drinks_menu.entity.Drink;
import com.damnfinepizzapo.damn_fine_backend.drinks_menu.repository.DrinkRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DrinkServiceTest {


    @Mock
    private DrinkRepository drinkRepository;

    @InjectMocks
    private DrinkService drinkService;


    @Test
    void testUpdateDrinkNotFound() {
        // Arrange
        int drinkId = 1;
        Drink updatedDrink = new Drink();
        when(drinkRepository.findById(drinkId)).thenReturn(Optional.empty());

        // Act & Assert
        Exception exception = assertThrows(RuntimeException.class, () -> {
            drinkService.updateDrink(drinkId, updatedDrink);
        });

        assertEquals("Item not found.", exception.getMessage());
        verify(drinkRepository, times(1)).findById(drinkId);
        verify(drinkRepository, never()).save(any(Drink.class));
    }

    @Test
    void testDeleteDrink() {
        // Arrange
        int drinkId = 1;
        doNothing().when(drinkRepository).deleteById(drinkId);

        // Act
        drinkService.deleteDrink(drinkId);

        // Assert
        verify(drinkRepository, times(1)).deleteById(drinkId);
    }
}