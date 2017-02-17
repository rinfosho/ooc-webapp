package io.muic.ooc.webapp.service;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rin on 2/14/2017 AD.
 */
public class DatabaseService {

    Connection conn;
    private final String SQL_URL = "jdbc:mysql://127.0.0.1:3306/User_Database";
//    private final String SQL_USERNAME = "";

    public DatabaseService() {
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(SQL_URL, "rinfosho", "ggwellplayed55");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteDB(String uid){
        try {
            PreparedStatement preS = this.conn.prepareStatement("delete from User_Database.User_data where Username = '" + uid + "'  ");
            preS.executeUpdate();

        }catch (SQLException s){
            s.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateDB(String uid, String usr, String fname){
        try {
            PreparedStatement preS = this.conn.prepareStatement("update User_Database.User_data SET Username = ?, UserID = ? where ID = '" + uid + "'  ");
            preS.setString(1,usr);
            preS.setString(2,fname);
            preS.executeUpdate();

        }catch (SQLException s){
            s.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void insertDB(String usr, String pwd, String fname){
        try {
            PreparedStatement preS = this.conn.prepareStatement("insert into User_Database.User_data (Username,Password, FirstName) values (?,?,?);");
            preS.setString(1, usr);
            preS.setString(2,pwd);
            preS.setString(3,fname);
            preS.executeUpdate();

        }catch (SQLException s){
            s.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public Map<String, String> readData(){
        Map<String, String> temp = new HashMap<>();

        try {
            PreparedStatement preS = this.conn.prepareStatement("select * from User_Database.User_data;");
            ResultSet result = preS.executeQuery();

            while (result.next()){
                String usr = result.getString("Username");
                String pwd = result.getString("Password");
                String fname = result.getString("FirstName");

//                System.out.println("id: " + id + ", username: " + usr + ", pwd: " + pwd + ", fname: " + fname);
                temp.put(usr,pwd);
//                System.out.println(temp);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

//        System.out.println(temp);
        return temp;
    }


}