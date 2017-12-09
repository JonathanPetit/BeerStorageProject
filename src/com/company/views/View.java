package com.company.views;
import com.company.model.*;


import java.util.Collections;
import java.util.List;


public class View {
    private List<Brewer> listing;
    private List<Brewer> GetListing(){return listing;}


    public View(List<Brewer> list_from_db){
        //Begin with a A to Z sorting
        //  Collections.sort(list_from_db);
        this.listing = list_from_db;
    }

    //Display inventory with a A to Z sorting methode
    public void atoz() {
        //  this.GetListing().forEach(item->display_Brewer(item));
    }

    //Display inventory with a Z to A sorting methode
    public void ztoa() {
        List<Brewer>list = GetListing();
        Collections.reverse(list);
        //  list.forEach(item->display_Brewer(item));
    }


    //Check if we find a query in inventory and display the Brewer where he find it.
    /*
    public void search(String query)
    {
        for(Brewer b : this.GetListing()) {
            if (b.GetName() != null && b.GetName().contains(query)) {
               display_Brewer(b);
            }
            else {
                for(BrandBeer beer : b.GetBrandList()) {
                    if (beer.GetName() != null && beer.GetName().contains(query)) {
                        display_Brewer(b);
                    }
                    else{
                        for (ModelBeer model : beer.GetModelList())
                            if (model.GetModel() != null &&model.GetModel().contains(query)) {
                                display_Brewer(b);
                            }
                    }
                }
            }
        }
    }


    //Display method
    private void display_Brewer(Brewer b){
        System.out.println("");
        System.out.println("Brewer :  "+b.GetName());
        for(BrandBeer Beer : b.GetBrandList()) {
            System.out.println("  Brand : "+Beer.GetName()+":");
            for(ModelBeer Model : Beer.GetModelList()){
                System.out.println("   -> "+Model.GetModel());
            }
        }
        System.out.println("");
        System.out.println("---------------------------------------------");
    }
    */
}