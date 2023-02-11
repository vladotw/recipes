package pro.sky.java.course3.recipes.controllers;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course3.recipes.exception.NotFoundException;
import pro.sky.java.course3.recipes.model.Ingredient;
import pro.sky.java.course3.recipes.services.IngredientService;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping("/id")
    public Ingredient addIngredient(Ingredient ingredient) {
        return ingredientService.addIngredient(ingredient);
    }

    @GetMapping
    public Ingredient getIngredient(@RequestParam Integer id) throws NotFoundException {
        return ingredientService.getIngredient(id);
    }

}
