package com.company.model;

import java.util.ArrayList;

public class Brewer {
  private String name;
  private String address;
  private String number;
  private ArrayList<Brand> brandsList;

  public Brewer(String name, String address, String number) {
    this.name = name;
    this.address = address;
    this.number = number;
    this.brandsList = new ArrayList<Brand>();
  }

  public String getName() {
    return this.name;
  }

  public String getAddress() {
    return this.address;
  }

  public String getNumber() {
    return this.number;
  }

  public ArrayList<Brand> getBrandList() {
    return this.brandsList;
  }

  public void addBrand(Brand brand){
    this.brandsList.add(brand);
  }
}