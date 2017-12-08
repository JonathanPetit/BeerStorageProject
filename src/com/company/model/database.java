/**
 * date : 01-12-17
 * author : amaury lekens
 */
/*
import java.sql.*

public class Database {

    private Connection c = null;

    private Database() {

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    private static Database instance = null;

    public static Database getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public addBeer(ModelBeer modelBeer, Brouwer brouwer, BrandBeer brandBeer){
        stmt = c.createStatement();
        String sql = conn.prepareStatement("INSERT INTO MODELBEER(model, type, degree, conditionning, price, quantity) "
                + "VALUES (?, ?, ?, ?, ?, ?)");
        stmt.setString(1, modelBeer.getModel);
        stmt.setString(2, modelBeer.getType);
        stmt.setString(3, modelBeer.getDegree);
        stmt.setString(4, modelBeer.getCondtionning);
        stmt.setString(5, modelBeer.get)

        stmt.executeUpdate(sql);
    }

    public removeBeer(){

    }

    public searchBeer(){

    }

    public modifyBeer(){

    }

    public inventoryListing (){

    }

    public getInfoBeer () {

    }

    public calculateValue () {

    }
}*/
