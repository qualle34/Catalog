package com.senla.catalog.dto.user;

public class UserRatingDto {

    private long id;
    private int addRating;

    public UserRatingDto() {
    }

    public UserRatingDto(long id, int addRating) {
        this.id = id;
        this.addRating = addRating;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAddRating() {
        return addRating;
    }

    public void setAddRating(int addRating) {
        this.addRating = addRating;
    }
}
