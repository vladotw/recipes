package pro.sky.java.course3.recipes.services;

import pro.sky.java.course3.recipes.exception.NotFoundException;
import pro.sky.java.course3.recipes.model.Ingredient;

public interface IngredientService {

    Ingredient getIngredient(Integer id);
    Ingredient addIngredient(Ingredient ingredient);

}
