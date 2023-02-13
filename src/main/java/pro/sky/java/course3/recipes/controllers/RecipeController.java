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

    public RecipeController(RecipeService recipeService) {

        this.recipeService = recipeService;
    }

    @GetMapping("/{id}")
    public Recipe getRecipe(@PathVariable Integer id) {
        return recipeService.getRecipe(id);
    }

    @PostMapping
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }


}
