package pro.sky.java.course3.recipes.services;

import pro.sky.java.course3.recipes.exception.NotFoundException;
import pro.sky.java.course3.recipes.model.Ingredient;

import java.util.Map;

public interface IngredientService {

    Ingredient getIngredient(Integer id);
    Ingredient addIngredient(Ingredient ingredient);

    Map<Integer, Ingredient> getAllIngredients();

    Ingredient editIngredient(int id, Ingredient ingredient);

    boolean deleteIngredient(int id);
}
