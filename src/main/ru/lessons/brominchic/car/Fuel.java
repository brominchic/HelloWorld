package ru.lessons.brominchic.car;

public enum Fuel {

    Diesel("Diesel"),
    Gas("Gas");

    private String title;


    Fuel(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}