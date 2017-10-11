import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BddTools{

    Connection con=null;
    Properties prop = new Properties()
    Statement stmt;
    InputStream input;
    
    try{
        input = new FileInputStream("properties.txt");
        prop.load(input);
        Class.forName("org.postgresql.Driver");

        String url = prop.getProperty("url");
        String nom = prop.getProperty("nom");
        String mdp = prop.getProperty("mdp");

        con = DriverManager.getConnection(url,nom,mdp);
        stmt = con.createStatement();
        
        
    }
    catch(Exception e){
        System.out.println("erreur lol");
    }
    finally{
        try{
            con.close();
        }catch(){
            System.out.println("erreur fermeture connection");
        }
    }
}