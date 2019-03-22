package project.dao;

import com.sun.javafx.css.CssError;
import project.model.user;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Sadiq
 * Date: 1/1/17
 * Time: 2:29 PM
 * To change this template use File | Settings | File Templates.
 */
public interface dao {

    public user loginUser(String username, String password, int room, String current_date,int day_of_week) throws  Exception ;

    public void setResult(int student_id, int room, int success) throws Exception ;

    public int getStudentId(String username,String password) throws Exception ;

}
