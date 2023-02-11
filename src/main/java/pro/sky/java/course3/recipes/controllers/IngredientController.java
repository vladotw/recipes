package pro.sky.java.course3.recipes.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/id")
    public Ingredient addIngredient(Ingredient ingredient) {
        return ingredientService.addIngredient(ingredient);
    }

    @PostMapping
    public Ingredient getIngredient(Integer id) throws NotFoundException {
        return ingredientService.getIngredient(id);
    }

}
