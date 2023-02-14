package pro.sky.java.course3.recipes.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.course3.recipes.model.Ingredient;
import pro.sky.java.course3.recipes.services.IngredientService;

import java.util.Map;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping
    public ResponseEntity<Ingredient> addIngredient(@RequestBody Ingredient ingredient) {
        return ResponseEntity.ok(ingredientService.addIngredient(ingredient));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredient(@PathVariable Integer id) {
        Ingredient ingredient = ingredientService.getIngredient(id);

        return ResponseEntity.ok(ingredient);
    }

    @GetMapping
    public ResponseEntity<Map<Integer, Ingredient>> getAllIngredients() {

        return ResponseEntity.ok(ingredientService.getAllIngredients());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> editIngredient(@PathVariable Integer id, @RequestBody Ingredient ingredient) {
        ingredient = ingredientService.editIngredient(id, ingredient);

        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable int id) {
        if (ingredientService.deleteIngredient(id)) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
