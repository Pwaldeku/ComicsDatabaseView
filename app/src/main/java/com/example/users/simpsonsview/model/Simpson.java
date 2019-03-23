package com.example.users.simpsonsview.model;

public class Simpson {

    /**Var APi*/
    private String quote;
    private String character ;
    private String image;


    public Simpson() {
    }

    public Simpson(String character, String quote, String image) {
        this.quote = quote;
        this.character = character;
        this.image = image;
    }

    /**GETTERS*/

    public String getQuote() {
        return quote;
    }
    public String getCharacter() {
        return character;
    }
    public String getImage() {
        return image;
    }


    /**SETTER*/

    public void setQuote(String quote) {
        this.quote = quote;
    }
    public void setCharacter(String character) {
        this.character = character;
    }
    public void setImage(String image) {
        this.image = image;
    }


}
