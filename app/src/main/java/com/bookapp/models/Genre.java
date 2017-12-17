package com.bookapp.models;

/**
 * Created by Malwina on 2017-12-17.
 */

public enum Genre {
    ARTS_CULTURE ("Arts & Culture"), BIOGRAPHY_MEMOIRS ("Biography & Memoirs"), FICTION ("Fiction"),
    ROMANCE ("Romance"), CRIME_THRILLER ("Crime & Thriller"), CHILDREN ("Children"),
    FANTASY_SCIFI ("Fantasy & Sci-fi"), TRAVEL ("Travel"), SCIENCES ("Sciences"),
    HISTORY ("History"), GUIDES ("Guides"), COMICS ("Comics");

    private String displayName;

    Genre(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() { return displayName; }

    // Optionally and/or additionally, toString.
    @Override public String toString() { return displayName; }
}
