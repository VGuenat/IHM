package com.ihm.ihm;

/**
 * Created by Vincent on 05/12/2016.
 * Représente un élément des listes des pages notifications, historique, panier et résultat de
 * recherche, entre autres.
 */

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
