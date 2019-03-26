package project.web;

import project.dao.dao;
import project.dao.daoImpl;
import project.model.user;
import project.util.Security;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Sadiq
 * Date: 1/1/17
 * Time: 2:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class ControllerServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        try {

        dao methods = new daoImpl();
        String address = "";

        Calendar calendar = Calendar.getInstance();
        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK)-1;               // day of the week

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String current_time = dateFormat.format(date).substring(11,16) ;    // current hour and minute

        int room = Integer.parseInt(request.getParameter("room"));         // id of room
        String username = request.getParameter("username");               // username
        String password = request.getParameter("password");              // password


        if (username.isEmpty() || password.isEmpty())
        {
            request.setAttribute("invalid","Please, fill the required fields !");
        }
        else
        {
                     if (room == 0)
                     {
                           request.setAttribute("invalid","Please, choose the room !");
                     }
                     else
                     {
                         password =  Security.generateMd5(password) ;
                         user user = methods.loginUser(username,password,room,current_time,day_of_week );
                           if (user != null)
                           {
                              methods.setResult(user.getId(), room, 1);
                              request.setAttribute("user",user);
                              address = "welcome.jsp";
                           }
                           else
                           {
                              int id = methods.getStudentId(username,password) ;
                              methods.setResult(id, room, 0);
                              if(id!=0)
                              request.setAttribute("invalid","Dear student, you are not allowed to enter this room right now !");
                              else
                              request.setAttribute("invalid","Username or passoword is invalid !");
                              address = "index.jsp";
                           }
                     }
        }

         RequestDispatcher dispatcher = request.getRequestDispatcher(address);
         dispatcher.forward(request,response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
