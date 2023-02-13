package pro.sky.java.course3.recipes.services;

import pro.sky.java.course3.recipes.exception.NotFoundException;
import pro.sky.java.course3.recipes.model.Recipe;

import java.util.Map;

public interface RecipeService {

    Recipe getRecipe(Integer id);

    Recipe addRecipe(Recipe recipe);

    Map<Integer, Recipe> getAllRecipes();

    Recipe editRecipe(int id, Recipe recipe);

    boolean deleteRecipe(int id);
}
