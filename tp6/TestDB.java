import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestDB{
    public static void main(String args[]){
     
        Connection con = null;
        Statement stmt;
        
        try{

            Properties prop = new Properties();
            InputStream input = null;
            
            input = new FileInputStream("properties.txt");
            prop.load(input);
            Class.forName("org.postgresql.Driver");

            String url = prop.getProperty("url");
            String nom = prop.getProperty("nom");
            String mdp = prop.getProperty("mdp");

            con = DriverManager.getConnection(url,nom,mdp);
            stmt = con.createStatement();

            String table="prof";
            //stmt.executeUpdate("CREATE TABLE "+table+"(pno serial, nom text, prenom text);");            
            //stmt.executeUpdate("INSERT INTO "+table+" values(1,'Esacobar','Pablo')");
            ResultSet rs = stmt.executeQuery("select * from prof;");
            ResultSetMetaData rsmd = rs.getMetaData();
            
            System.out.println(rsmd.getColumnCount());

        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            try{
               con.close();    
            }catch(Exception e){
                System.out.println("erreur connection");
            }            
        }
    }
}