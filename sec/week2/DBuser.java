package sec.week2;

import java.sql.Statement;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
// import org.apache.derby.client.am.SqlException;

public class DBuser {
    public DBuser() throws ClassNotFoundException, SQLException{
        Connection con = null;
        try{
            //load driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver"); 
            // connection
            con = DriverManager.getConnection("jdbc:derby:db/week2;create=true");
            //sql statment
            Statement stat = con.createStatement();
            stat.executeUpdate("create table Users ( email varchar(25), firstName varchar(25), lastName varchar(25),"+
            "password varchar(25), primary key (email) )");
            
        }catch( ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            // e.printStackTrace();  commented for => Creating the table and its alrady exists in Schema 
        }finally{
            if (con != null) {
                con.close();
            }
        }
    }
    public void insertUser(User u) throws SQLException{
        Connection con = null;
        try{
            // connection
            con = DriverManager.getConnection("jdbc:derby:db/week2;create=true");
            //sql statement
            PreparedStatement pStat = con.prepareStatement("insert into Users (email, firstName, lastName, password) values (?, ?, ?, ?)");
            pStat.setString(1,u.getEmail());
            pStat.setString(2,u.getFirstNmae());
            pStat.setString(3,u.getLastName());
            pStat.setString(4,u.getPassword());
            pStat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            if (con != null) {
                con.close();
            }
        }
    }
    
    public User loginUser(String eamil, String password) throws SQLException{
        User u = null;
        Connection con = null;
        try{
            // connection
            con = DriverManager.getConnection("jdbc:derby:db/week2;create=true");
            
            PreparedStatement pStat = con.prepareStatement("SELECT * FROM Users WHERE email = ? and password = ?");
            pStat.setString(1, eamil);
            pStat.setString(2, password);
            ResultSet rs  = pStat.executeQuery();
            if (rs.next()) {
                String email = rs.getString(1);// First Name
                String fName = rs.getString(2);
                String lName = rs.getString(3);
                // String Password = rs.getString(4);
                u = new User();
                u.setEmail(email);
                u.setFirstNmae(fName);
                u.setLastName(lName);
                return u;
            }else{

                // handeling if the user not found in the database.
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if (con != null) {
                con.close();
            }
        }
        return u;
    }
    
    public ArrayList<User> ReturnUsers() throws SQLException{
        Connection con = null;
        User u;
        ArrayList<User> arr = new ArrayList<>();
        try{
            // connection
            con = DriverManager.getConnection("jdbc:derby:db/week2;create=true");
            
            PreparedStatement pStat = con.prepareStatement("SELECT * FROM Users");
            ResultSet rs  = pStat.executeQuery();
            while (rs.next()) {
                String email = rs.getString(1);// First Name
                String fName = rs.getString(2);
                String lName = rs.getString(3);
                String Password = rs.getString(4);
                u = new User();
                u.setEmail(email);
                u.setFirstNmae(fName);
                u.setLastName(lName);
                u.setPassword(Password);
                arr.add(u);
            }   
            return arr;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if (con != null) {
                con.close();
            }
        }
        return null;
    } 
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DBuser api= null;
        try{
            api = new DBuser();
        }catch(SQLException e){
            e.printStackTrace();
        }
        User u = new User();
        
        // u.setEmail("youssef@sdafsd");
        // u.setFirstNmae("ahmed");
        // u.setLastName("kandeel");
        // u.setPassword("123");
        // api.insertUser(u);
        ArrayList<User> u2  = api.ReturnUsers();
        System.out.println(u2.toString());
    }
}
