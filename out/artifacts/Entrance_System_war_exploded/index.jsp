<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sadiq
  Date: 1/1/17
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>Login</title>
      <script type="text/javascript" src="js/jquery-3.1.1.js"></script>
      <script type="text/javascript" src="js/bootstrap.min.js"></script>
      <script type="text/javascript" src="js/login.js"></script>

      <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
      <link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
      <link rel="stylesheet" type="text/css" href="css/login.css" />


      <script type="text/javascript">

           history.pushState(null, null, 'index.jsp');
           window.addEventListener('popstate', function(event) {
              history.pushState(null, null, 'index.jsp');
           });

           $(document).ready(function(){

               $('#clearId').click(function(){
                   $('#usernameId').val('') ;
                   $('#passwordId').val('') ;
                   $('#roomId').val(0);
               })
           })
      </script>

  </head>

  <body>
  <div class="container">
      <div class="row">
          <div class="col-md-6 col-md-offset-3">
              <div class="panel panel-login">
                  <div class="panel-body">
                      <div class="row">
                          <div class="col-lg-12">

                              <form id="login-form" action="cs" method="post" role="form" style="display: block;">
                                  <b><h2 style="display: inline-block; color: darkslategray; font-family: monospace;">Room Entrance System</h2></b>
                                  <select id="roomId" name="room" style="display: inline-block; margin-left: 102px; color: #20b2aa; font-family: monospace; width: 122px;">
                                      <option value="0">Choose room:</option>
                                      <option value="1">Room    24</option>
                                      <option value="2">Room    48</option>
                                      <option value="3">Room    52</option>
                                      <option value="4">Room    66</option>
                                  </select>
                                  <c:if test="${not empty invalid}">

                                      <c:choose>

                                           <c:when test="${invalid=='Dear student, you are not allowed to enter this room right now !'}">
                                            <label style="color: #b22222; text-align: center; margin-left: 88px;"><h5>${invalid}</h5></label>
                                           </c:when>

                                           <c:when test="${invalid=='Username or passoword is invalid !'}">
                                            <label style="color: #b22222; text-align: center; margin-left: 150px;"><h5>${invalid}</h5></label>
                                           </c:when>

                                          <c:when test="${invalid=='Please, choose the room !'}">
                                              <label style="color: #b22222; text-align: center; margin-left: 170px;"><h5>${invalid}</h5></label>
                                          </c:when>

                                          <c:when test="${invalid=='Please, fill the required fields !'}">
                                              <label style="color: #b22222; text-align: center; margin-left: 170px;"><h5>${invalid}</h5></label>
                                          </c:when>

                                      </c:choose>

                                  </c:if>

                                  <div class="form-group">
                                     <input type="text" name="username" id="usernameId"  tabindex="1" class="form-control" placeholder="username" style="font: icon ; font-family: monospace;">
                                  </div>

                                  <div class="form-group">
                                     <input type="password" name="password" id="passwordId" tabindex="2" class="form-control" placeholder="password" style="font: icon ; font-family: monospace;">
                                  </div>

                                  <div class="col-xs-6 form-group pull-left">
                                    <input type="button" id="clearId" value="Clean" class="btn btn-clear">
                                  </div>

                                  <div class="col-xs-6 form-group pull-right">
                                      <input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Enter">
                                  </div>
                              </form>
                          </div>
                      </div>
                  </div>
              </div>
          </div>
      </div>
  </div>
  <footer>
      <div class="container">
         <div class="col-md-10 col-md-offset-1 text-center">
         <br><h4 style="font-size:16px;font-weight:100;color: #dc143c; font-family: cursive ;">Coded by <a href="https://www.facebook.com/sadiq.eyvazov" style="color:#ffffff ; " target="_blank;" > Sadiq Eyvazov </a></h4>
         </div>
      </div>
  </footer>

  </body>
</html>