package project.dao;

import project.model.user;
import project.util.dbHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Sadiq
 * Date: 1/1/17
 * Time: 2:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class daoImpl implements  dao {


    @Override
    public user loginUser(String username, String password, int room, String current_date,int day_of_week) throws Exception {

        user user = new user();
        Connection c = null ;
        PreparedStatement ps = null ;
        ResultSet rs = null ;

        String sql = " SELECT ST.ID, ST.NAME,ST.SURNAME,SC.END_TIME FROM SCHEDULE SC\n" +
                "INNER JOIN STUDENT ST ON SC.GROUP_ID=ST.GROUP_ID      \n" +
                "WHERE USERNAME = ? and PASSWORD = ? "
                +
                "and ROOM_ID = ? and DAY = ?  \n" +
                "and START_TIME <= ? \n" +
                "and END_TIME >= ?  " ;

        try {

             c = dbHelper.getConnection();
              if (c!=null)
              {
                   ps = c.prepareStatement(sql);
                   ps.setString(1,username);
                   ps.setString(2,password);
                   ps.setInt(3,room);
                   ps.setInt(4,day_of_week );
                   ps.setString(5,current_date);
                   ps.setString(6,current_date);
                   rs = ps.executeQuery();
                     if (rs.next())
                     {
                       user.setId(rs.getInt("ID"));
                       user.setName(rs.getString("NAME"));
                       user.setSurname(rs.getString("SURNAME"));
                       user.setEnd_time(rs.getString("END_TIME"));
                     }
                     else  user = null ;
              }
              else    System.out.print("Connection is null !");

        }   catch (Exception e) {
            e.printStackTrace();
        }  finally {
            dbHelper.closeConnection(c,ps,rs);
        }

        return user;
    }

    @Override
    public void setResult(int student_id, int room, int success) throws Exception {

        Connection c = null ;
        PreparedStatement ps = null ;
        String sql = "INSERT INTO RESULTS (ID,STUDENT_ID,ROOM_ID,SUCCESS)\n" +
                "VALUES(RESULTS_SEQ.NEXTVAL,?,?,?)" ;

        try {

            c = dbHelper.getConnection();
            if (c!=null)
            {
                ps = c.prepareStatement(sql);
                ps.setInt(1,student_id);
                ps.setInt(2,room);
                ps.setInt(3,success);
                ps.execute();
            }
            else    System.out.print("Connection is null !");

        }   catch (Exception e) {
            e.printStackTrace();
        }  finally {
            dbHelper.closeConnection(c,ps,null);
        }

    }

    @Override
    public int getStudentId(String username, String password) throws Exception {

        int id = 0 ;
        Connection c = null ;
        PreparedStatement ps = null ;
        ResultSet rs = null ;
        String sql = " SELECT ID FROM STUDENT  \n" +
                "WHERE USERNAME = ? and PASSWORD = ? ";

        try {

            c = dbHelper.getConnection();
            if (c!=null)
            {
                ps = c.prepareStatement(sql);
                ps.setString(1,username);
                ps.setString(2,password);
                rs = ps.executeQuery();
                if (rs.next())
                {
                  id = rs.getInt("ID") ;
                }
            }
            else    System.out.print("Connection is null !");

        }   catch (Exception e) {
            e.printStackTrace();
        }  finally {
            dbHelper.closeConnection(c,ps,rs);
        }

        return id;
    }
}