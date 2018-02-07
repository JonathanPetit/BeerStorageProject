package com.company.model;

import java.util.ArrayList;

public class Brand {
    private String name;
    private String address;
    private ArrayList<Beer> beersList;

    public Brand(String name, String address){
        this.name = name;
        this.address = address;
        this.beersList = new ArrayList<Beer>();
    }

    // Getters and setters
    public String getName() {
    return this.name;
  }

    public String getAddress() {
    return this.address;
  }

    public ArrayList<String> getBeersList() {
        ArrayList<String> names = new ArrayList<String>();
        for (int i = 0; i < beersList.size(); i++) {
            names.add(beersList.get(i).getName());
        }
        return names;
    }

    public ArrayList<Beer> getBeersListObject() {
    return beersList;
  }

    // Function to add a beer into the beerList of a brand.
    public void addBeer(Beer beer){
    this.beersList.add(beer);
  }

    // Function to remove a beer into the beerList of a brand.
    public void removeBeer(Beer beer) {this.beersList.remove(beer);}

    @Override
    public String toString(){
        ArrayList<Beer> beers = this.beersList;
        String brandsString = "";

        for (Beer beer:beers) {
            // First possibility: add beer to string (with all data)
            //toString += beer.toString();
            //Other possibility: just add beer name
            brandsString = brandsString.concat(beer.getName());
            if (beer != beers.get(beers.size() - 1)) {
            brandsString += ", ";
            }
        }
        return String.format("%20s%20s%20s", this.name, this.address,brandsString);
    }
}


