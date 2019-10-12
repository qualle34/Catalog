package com.senla.catalog.dto.advert;

public class CategoryDto {

    private int id;
    private String title;

    public CategoryDto() {
    }

    public CategoryDto(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
