package pro.sky.java.course3.recipes.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipesController {

    @GetMapping("/")
    public String recipe() {
        return "Книга рецептов";
    }

    @GetMapping("/info")
    public String recipe(@RequestParam String studentName, @RequestParam String projectName, @RequestParam String date,
                         @RequestParam String description) {
        return  "Студент: " + studentName
                + "Название проекта: " + projectName +
                "Дата создания проекта: " + date +
                "Описание: " + description;
    }
}
