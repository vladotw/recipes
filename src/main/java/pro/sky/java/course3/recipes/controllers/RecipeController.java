package pro.sky.java.course3.recipes.controllers;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course3.recipes.exception.NotFoundException;
import pro.sky.java.course3.recipes.model.Recipe;
import pro.sky.java.course3.recipes.services.IngredientService;
import pro.sky.java.course3.recipes.services.RecipeService;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService, RecipeService step, RecipeService ingredient) {

        this.recipeService = recipeService;
    }

    @GetMapping("/id")
    public Recipe getRecipe(Integer id) throws NotFoundException {
        return recipeService.getRecipe(id);
    }

    @PostMapping
    public Recipe addRecipe(@RequestParam Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }


}
