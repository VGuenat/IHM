package com.ihm.ihm;

/**
 * Created by Florian.BADENS on 07/12/2016.
 */

class AvisListeItem {
    private int image;
    private String username;
    private String commentaire;

    AvisListeItem(int image, String username, String commentaire) {
        this.image = image;
        this.username = username;
        this.commentaire = commentaire;

    }

    int getImage() {
        return image;
    }

    String getUsername() {
        return username;
    }
    String getCommentaire() { return commentaire; }
}
