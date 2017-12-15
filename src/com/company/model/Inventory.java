package com.company.model;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Brewer> brewersList;
    public Inventory() {
        this.brewersList = new ArrayList<Brewer>();
    }

    public ArrayList<Brewer> getBrewersList() {
        return brewersList;
    }

    public void addBrewer(Brewer brewer) {
        this.brewersList.add(brewer);
    }
}
