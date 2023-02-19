package pro.sky.java.course3.recipes.services;

import java.io.File;

public interface FilesService {


    boolean saveToIngredientFile(String json);

    boolean saveToRecipeFile(String json);

    String readFromIngredientFile();

    String readFromRecipeFile();

    File getRecipeFile();

    File getIngredientFile();
}