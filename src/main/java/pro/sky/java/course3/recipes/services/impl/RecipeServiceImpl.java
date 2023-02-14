package pro.sky.java.course3.recipes.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course3.recipes.exception.NotFoundException;
import pro.sky.java.course3.recipes.model.Recipe;
import pro.sky.java.course3.recipes.services.RecipeService;

import java.util.*;

@Service
public class RecipeServiceImpl implements RecipeService {

    private static int id = 0;
    private final Map<Integer, Recipe> recipeMap = new HashMap<>();

    @Override
    public Recipe addRecipe(Recipe recipe) {
        return recipeMap.put(id++, recipe);
    }

    @Override
    public Recipe getRecipe(Integer id) {

        Recipe recipe = recipeMap.get(id);

        if (recipe == null) {
            throw new NotFoundException(recipe.toString());
        }

        return recipe;
    }

    @Override
    public Map<Integer, Recipe> getAllRecipes() {

        return recipeMap;
    }

    @Override
    public Recipe editRecipe(int id, Recipe recipe) {

        if (recipeMap.containsKey(id)) {
            recipeMap.put(id, recipe);
            return recipe;
        }

        return null;
    }

    @Override
    public boolean deleteRecipe(int id) {
        if (recipeMap.containsKey(id)) {
            recipeMap.remove(id);
            return true;
        }

        return false;
    }
}



