package pro.sky.java.course3.recipes.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course3.recipes.exception.NotFoundException;
import pro.sky.java.course3.recipes.model.Ingredient;
import pro.sky.java.course3.recipes.services.IngredientService;

import java.util.*;


@Service
public class IngredientServiceImpl implements IngredientService {

    private final Map<Integer, Ingredient> ingredientMap = new HashMap<>();
    private static int id = 1;

    @Override
    public Ingredient addIngredient(Ingredient ingredient){

        return ingredientMap.put(id++, ingredient);
    }

    @Override
    public Ingredient getIngredient(Integer id) {
        Ingredient ingredient = ingredientMap.get(id);

        if (ingredient == null) {
            throw new NotFoundException(ingredient.toString());
        }
        return ingredient;
    }

    @Override
    public Map<Integer, Ingredient> getAllIngredients() {

        return ingredientMap;
    }

    @Override
    public Ingredient editIngredient(int id, Ingredient ingredient) {

        if (ingredientMap.containsKey(id)) {
            ingredientMap.put(id, ingredient);
            return ingredient;
        }

        return null;
    }

    @Override
    public boolean deleteIngredient(int id) {
        if (ingredientMap.containsKey(id)) {
            ingredientMap.remove(id);
            return true;
        }

        return false;
    }
}
