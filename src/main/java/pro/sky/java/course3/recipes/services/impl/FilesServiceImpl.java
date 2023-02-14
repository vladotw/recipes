package pro.sky.java.course3.recipes.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pro.sky.java.course3.recipes.services.FilesService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FilesServiceImpl implements FilesService {

    @Value("${name.of.recipe.file}")
    private String recipeFileName;

    @Value("${path.to.recipe.file}")
    private String recipeFilePath;

    @Value("${name.of.ingredient.file}")
    private String ingredientFileName;

    @Value("${path.to.ingredient.file}")
    private String ingredientFilePath;

    @Override
    public boolean saveToIngredientFile(String json) {

        try {
            cleanIngredientFile();
            Files.writeString(Path.of(ingredientFilePath, ingredientFileName), json);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public boolean saveToRecipeFile(String json) {

        try {
            cleanRecipeFile();
            Files.writeString(Path.of(recipeFilePath, recipeFileName), json);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public String readFromIngredientFile() {
        try {
            return Files.readString(Path.of(ingredientFilePath, ingredientFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String readFromRecipeFile() {
        try {
            return Files.readString(Path.of(recipeFilePath, recipeFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void cleanIngredientFile() {

        try {
            Path path = Path.of(ingredientFilePath, ingredientFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void cleanRecipeFile() {

        try {
            Path path = Path.of(recipeFilePath, recipeFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
