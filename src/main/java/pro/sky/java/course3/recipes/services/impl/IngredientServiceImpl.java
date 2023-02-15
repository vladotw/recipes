package pro.sky.java.course3.recipes.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.java.course3.recipes.exception.NotFoundException;
import pro.sky.java.course3.recipes.model.Ingredient;
import pro.sky.java.course3.recipes.services.FilesService;
import pro.sky.java.course3.recipes.services.IngredientService;

import java.util.*;


@Service
public class IngredientServiceImpl implements IngredientService {

    private Map<Integer, Ingredient> ingredientMap = new HashMap<>();
    private static int id = 1;
    private final FilesService ingredientFileService;

    public IngredientServiceImpl(FilesService ingredientFileService) {
        this.ingredientFileService = ingredientFileService;
    }

    private void saveToIngredientFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(ingredientMap);
            ingredientFileService.saveToIngredientFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFromIngredientFile() {
        String json = ingredientFileService.readFromIngredientFile();

        try {
            ingredientMap = new ObjectMapper().readValue(json, new TypeReference<HashMap<Integer, Ingredient>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Ingredient addIngredient(Ingredient ingredient){
        if (!StringUtils.isBlank(ingredient.getName())) {
            saveToIngredientFile();
            return ingredientMap.put(id++, ingredient);
        }
        return null;
    }

    @Override
    public Ingredient getIngredient(Integer id) {
        readFromIngredientFile();
        Ingredient ingredient = ingredientMap.get(id);

        if (ingredient == null) {
            throw new NotFoundException(ingredient.toString());
        }
        return ingredient;
    }

    @Override
    public Map<Integer, Ingredient> getAllIngredients() {
        readFromIngredientFile();
        return ingredientMap;
    }

    @Override
    public Ingredient editIngredient(int id, Ingredient ingredient) {

        if (ingredientMap.containsKey(id)) {
            readFromIngredientFile();
            ingredientMap.put(id, ingredient);
            saveToIngredientFile();
            return ingredient;
        }

        return null;
    }

    @Override
    public boolean deleteIngredient(int id) {
        readFromIngredientFile();
        if (ingredientMap.containsKey(id)) {
            ingredientMap.remove(id);
            saveToIngredientFile();
            return true;
        }

        return false;
    }
}
