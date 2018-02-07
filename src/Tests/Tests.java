import com.company.Json.JsonRead;
import com.company.Json.JsonWrite;
import com.company.controller.Controller;
import org.junit.Assert;
import org.junit.Test;
import com.company.model.Brewer;
import com.company.model.Brand;
import com.company.model.Beer;

import java.util.ArrayList;
import java.util.List;

public class Tests
{
    @Test
    public void BeerTest(){
        Beer beer =new Beer("Jup","Pils",6,50,2.5,5);
        Assert.assertEquals("Should be Jup","Jup",beer.getName());
        Assert.assertEquals("Should be Pils","Pils",beer.getType());
        Assert.assertEquals(6,beer.getDegree(),0.001);
        Assert.assertEquals(50,beer.getConditioning(),0.001);
        Assert.assertEquals(2.5,beer.getPrice(),0.001);
        Assert.assertEquals(3.5,beer.getPrice(),0.001);

        Assert.assertEquals(5,beer.getEvaluation(),0.001);
        Assert.assertEquals(3.0,beer.getEvaluation(),0.001);
        Assert.assertEquals("Should be good","                 Jup                " +
                "Pils                 6.0                50.0                 3.5                 " +
                "3.0",beer.toString());
    }
    @Test
    public void BrewerTest(){
        Brewer brewer = new Brewer("InBev","There");
        Assert.assertEquals("Should be InBev","InBev",brewer.getName());
        Assert.assertEquals("Should be There","There",brewer.getAddress());
        Assert.assertEquals("Should be NotThere","NotThere",brewer.getAddress());
        Assert.assertEquals("Should be 0",0,brewer.getBrandList().size());
        Assert.assertEquals("Should be a long string","               " +
                "InBev            NotThere                   0" +
                "                    ",brewer.toString());
        Brand brand = new Brand("Pechmel","Here");
        brewer.addBrand(brand);
        Assert.assertEquals("Should be 1",1,brewer.getBrandList().size());
        brewer.RemoveBrand(brand);
        Assert.assertEquals("Should be 0",0,brewer.getBrandList().size());

    }
    @Test
    public void BrandTest(){
        Brand brand = new Brand("Pechmel","Here");
        Assert.assertEquals("Should be PechMel","Pechmel",brand.getName());
        Assert.assertEquals("Should be Here","Here",brand.getAddress());
        Assert.assertEquals("Should be NotHere","NotHere",brand.getAddress());
        Assert.assertEquals("should be ","             Pechmel             NotHere  " +
                "                 0                    ",brand.toString());
        Beer beer= new Beer("Jup","Pils",6,50,2.5,5);
        Assert.assertEquals("Should be 0",0,brand.getBeersList().size());
        brand.addBeer(beer);
        Assert.assertEquals("Should be 1",1,brand.getBeersList().size());
        brand.removeBeer(beer);
        Assert.assertEquals("Should be 0",0,brand.getBeersList().size());


    }
    @Test
    public void JsonTest(){
        Controller controller= Controller.getInstance();
        JsonRead json =new JsonRead();
        List<Object> out=json.readFile("Brewer");
        int size = out.size();
        Assert.assertEquals("should be 1",size, out.size());
        JsonWrite wjson = new JsonWrite();
        ArrayList<Object> brewers = new ArrayList<Object>();
        Brewer brewer= new Brewer("Bush","LLN");
        brewers.add(brewer);
        wjson.writeFile("Brewer", brewers, controller.getParamsBrewer());
        out=json.readFile("Brewer");
        Assert.assertEquals("should be 2",size+1, out.size());
        Brewer brewer2 = new Brewer("Bush","LLN");
        ArrayList<Object> brewers2 = new ArrayList<Object>();
        brewers.add(brewer2);
        wjson.writeFile("Brewer", brewers2, controller.getParamsBrewer());
        Assert.assertEquals("should be 2",size+1, out.size());
        List<Object> brands = json.getByArg("BrandBeer","address","BrandAddress");
        Assert.assertEquals("should be 1",1,brands.size());
        Object brandstest = json.getByName("BrandBeer","OtherBrandBeer");
        Assert.assertEquals("should be 1",1,brands.size());

    }
    @Test
    public void ControllerTests(){
        Controller controller= Controller.getInstance();
        try {
            Controller controller2 = Controller.getInstance();
            Assert.fail();
        } catch (Exception e) {

        }
        ArrayList<String> params = new ArrayList<>();
        params.add("-b");
        params.add("-c");
        controller.addCommands("test",params);
        Assert.assertEquals("should be params",params,controller.getCommandsList().get("test"));
        ArrayList<String> parsed = controller.parseCommand("test -b -c");
        Assert.assertEquals("shoud be 3",3,parsed.size());
        Assert.assertEquals("should be 'test'","-b",parsed.get(1));
    }
}
