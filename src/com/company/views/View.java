package com.company.views;
import com.company.model.*;


import java.util.Collections;
import java.util.List;


public class View {
    private List<Brouwer> listing;
    private List<Brouwer> GetListing(){return listing;}


    public View(List<Brouwer> list_from_db){
        //Begin with a A to Z sorting
        Collections.sort(list_from_db);
        this.listing = list_from_db;
    }

    //Display inventory with a A to Z sorting methode
    public void atoz() {
        this.GetListing().forEach(item->display_brouwer(item));
    }

    //Display inventory with a Z to A sorting methode
    public void ztoa() {
        List<Brouwer>list = GetListing();
        Collections.reverse(list);
        list.forEach(item->display_brouwer(item));
    }


    //Check if we find a query in inventory and display the brouwer where he find it.
    public void search(String query)
    {
        for(Brouwer b : this.GetListing()) {
            if (b.GetName() != null && b.GetName().contains(query)) {
               display_brouwer(b);
            }
            else {
                for(BrandBeer beer : b.GetBrandList()) {
                    if (beer.GetName() != null && beer.GetName().contains(query)) {
                        display_brouwer(b);
                    }
                    else{
                        for (ModelBeer model : beer.GetModelList())
                            if (model.GetModel() != null &&model.GetModel().contains(query)) {
                                display_brouwer(b);
                            }
                    }
                }
            }
        }
    }


    //Display method
    private void display_brouwer(Brouwer b){
        System.out.println("");
        System.out.println("Brouwer :  "+b.GetName());
        for(BrandBeer Beer : b.GetBrandList()) {
            System.out.println("  Brand : "+Beer.GetName()+":");
            for(ModelBeer Model : Beer.GetModelList()){
                System.out.println("   -> "+Model.GetModel());
            }
        }
        System.out.println("");
        System.out.println("---------------------------------------------");
    }
}