package pro.sky.java.course3.recipes.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Recipe {

    private String name;
    private int cookingTime;
    List<Ingredient> ingredientList;
    List<String> stepList;
}
