package pro.sky.java.course3.recipes.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String object) {
        super(object + "не обнаружен");
    }
}
