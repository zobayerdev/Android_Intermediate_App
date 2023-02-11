package com.hpsoft.usermadrasha;

public class BranchModel {

    private int imag;

    private String title, description;

    public BranchModel(int imag, String title, String description) {
        this.imag = imag;
        this.title = title;
        this.description = description;
    }

    public int getImag() {
        return imag;
    }

    public void setImag(int imag) {
        this.imag = imag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
