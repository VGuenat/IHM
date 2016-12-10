package com.ihm.ihm;


class ConcertListeItem {
    private int image;
    private String artiste;
    private String date;
    private String description;

    ConcertListeItem(int image, String artiste, String date, String description) {
        this.image = image;
        this.artiste = artiste;
        this.date = date;
        this.description = description;
    }

    int getImage() {
        return image;
    }

    String getArtiste() {
        return artiste;
    }

    String getDate() {
        return date;
    }

    String getDescription() {
        return description;
    }

}
