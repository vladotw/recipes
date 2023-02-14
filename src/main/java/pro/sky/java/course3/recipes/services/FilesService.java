package pro.sky.java.course3.recipes.services;

public interface FilesService {


    boolean saveToIngredientFile(String json);

    boolean saveToRecipeFile(String json);

    String readFromIngredientFile();

    String readFromRecipeFile();
}