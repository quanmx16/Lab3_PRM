package com.example.lab3_maixuanquan.object;

public class Player {
    private String name;
    private int image;
    private int nation;
    private String description;

    public Player(String name, int image, int nation, String description) {
        this.name = name;
        this.image = image;
        this.nation = nation;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getNation() {
        return nation;
    }

    public void setNation(int nation) {
        this.nation = nation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
