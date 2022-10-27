package br.com.alura.comex.config.validation.dto;

public class FormErrorDto {
    private String field;
    private String message;

    public FormErrorDto(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
