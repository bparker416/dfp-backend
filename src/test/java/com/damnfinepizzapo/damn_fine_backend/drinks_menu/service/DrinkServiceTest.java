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
    void testUpdateDrink() {
        // Arrange
        int drinkId = 1;
        Drink existingDrink = new Drink();
        existingDrink.setDrink_id(drinkId);
        existingDrink.setDrink_name("Coke");
        existingDrink.setDrink_price(2);
        existingDrink.setDrink_description("soda");
        existingDrink.setDrink_active(true);

        Drink updatedDrink = new Drink();
        updatedDrink.setDrink_name("Not Coke");
        updatedDrink.setDrink_price(4);
        updatedDrink.setDrink_description("Not soda");
        updatedDrink.setDrink_active(false);

        when(drinkRepository.findById(drinkId)).thenReturn(Optional.of(existingDrink));
        when(drinkRepository.save(existingDrink)).thenReturn(existingDrink);

        // Act
        Drink result = drinkService.updateDrink(drinkId, updatedDrink);

        // Assert
        assertNotNull(result);
        assertEquals("Pepsi", result.getDrink_name());
        assertEquals(3, result.getDrink_price());
        assertEquals("Another soda", result.getDrink_description());
        assertFalse(result.isDrink_active());

        // Verify interactions
        verify(drinkRepository, times(1)).findById(drinkId);
        verify(drinkRepository, times(1)).save(existingDrink);
    }

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