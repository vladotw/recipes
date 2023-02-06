package pro.sky.java.course3.recipes.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipesController {

    @GetMapping("/")
    public String recipe() {
        return "Книга рецептов";
    }

    @GetMapping("/info")
    public String recipe(String studentName, String projectName, String date, String description) {
        return  "Студент: " + studentName +
                "Название проекта: " + projectName +
                "Дата создания проекта: " + date +
                "Описание: " + description;
    }
}
