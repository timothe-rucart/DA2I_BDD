import java.sql.*;

public class TestDB{
    public static void main(String args[]){
     
        Connection con = null;
        Statement stmt;
        
        try{


            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://psqlserv/da2i";
            String nom = "rucart";
            String mdp = "moi";

            con = DriverManager.getConnection(url,nom,mdp);
            stmt = con.createStatement();

            String nomTable="eleve";


        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            try{
              //  con.close();    
            }catch(Exception e){
                System.out.println("erreur connection");
            }            
        }
    }
}