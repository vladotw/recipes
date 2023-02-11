package pro.sky.java.course3.recipes.services;

import pro.sky.java.course3.recipes.exception.NotFoundException;
import pro.sky.java.course3.recipes.model.Recipe;

public interface RecipeService {

    Recipe getRecipe(Integer id) throws NotFoundException;

    Recipe addRecipe(Recipe recipe);

}
