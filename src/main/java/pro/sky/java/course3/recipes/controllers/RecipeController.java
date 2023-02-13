package pro.sky.java.course3.recipes.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.course3.recipes.model.Recipe;
import pro.sky.java.course3.recipes.services.RecipeService;

import java.util.Map;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {

        this.recipeService = recipeService;
    }

    @GetMapping
    public ResponseEntity<Map<Integer, Recipe>> getAllRecipes() {

        if (recipeService.getAllRecipes() == null) {                       // если метод возвращает null
            return ResponseEntity.notFound().build();   // возвращается 404
        }
        return ResponseEntity.ok(recipeService.getAllRecipes());           // иначе возвращается ингредиент в теле
    }

    @PostMapping
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
        return ResponseEntity.ok(recipeService.addRecipe(recipe));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> editRecipe(@PathVariable Integer id, @RequestBody Recipe recipe) {
        recipe = recipeService.editRecipe(id, recipe);

        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable int id) {
        if (recipeService.deleteRecipe(id)) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
