import java.sql.*;
import java.util.Random;

public class InsererCommandes{
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

            String table="commandes";
            String query;
            Random random = new Random();            
            
            for(int i=1 ; i<=1000 ; i++){
                for(int j=1 ; j<=1000 ; j++){
                    
                    query ="INSERT INTO "+table+"(pno, fno,qute) values("+ random.nextInt(1000)+1+","+i+","+random.nextInt(100)+1+");";                       
                    stmt.executeUpdate(query);
                }                
            }            
            


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