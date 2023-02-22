package pro.sky.java.course3.recipes.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.java.course3.recipes.exception.NotFoundException;
import pro.sky.java.course3.recipes.model.Recipe;
import pro.sky.java.course3.recipes.services.FilesService;
import pro.sky.java.course3.recipes.services.RecipeService;

import java.util.*;

@Service
public class RecipeServiceImpl implements RecipeService {

    private static int id = 0;
    private Map<Integer, Recipe> recipeMap = new HashMap<>();

    private final FilesService recipeFileService;       // переменная для работы с FilesService

    public RecipeServiceImpl(FilesService recipeFileService) {
        this.recipeFileService = recipeFileService;
    }

    @PostConstruct
    private void init() {
        readFromRecipeFile();
    }

    private void saveToRecipeFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(recipeMap);
            recipeFileService.saveToRecipeFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }



    private Map<Integer, Recipe> readFromRecipeFile() {
        String json = recipeFileService.readFromRecipeFile();

        try {
            recipeMap = new ObjectMapper().readValue(json, new TypeReference<HashMap<Integer, Recipe>>() {
            });
            return recipeMap;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Recipe addRecipe(Recipe recipe) {
        if (!StringUtils.isBlank(recipe.getName())) {
            recipeMap.put(id++, recipe);
            saveToRecipeFile();
            return recipe;
        }
        return null;
    }

    @Override
    public Recipe getRecipe(Integer id) {
        Recipe recipe = recipeMap.get(id);

        if (recipe == null) {
            throw new NotFoundException(recipe.toString());
        }

        return recipe;
    }

    @Override
    public Map<Integer, Recipe> getAllRecipes() {
        return recipeMap;
    }

    @Override
    public Recipe editRecipe(int id, Recipe recipe) {
        if (recipeMap.containsKey(id)) {
            recipeMap.put(id, recipe);
            saveToRecipeFile();
            return recipe;
        }

        return null;
    }

    @Override
    public boolean deleteRecipe(int id) {
        if (recipeMap.containsKey(id)) {
            recipeMap.remove(id);
            saveToRecipeFile();
            return true;
        }

        return false;
    }
}



