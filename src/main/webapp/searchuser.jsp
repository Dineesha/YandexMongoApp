<%--
  Created by IntelliJ IDEA.
  User: hsenid
  Date: 4/22/16
  Time: 11:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Search</title>

  <!-- CSS -->
  <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
  <!-- <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">-->
  <link rel="stylesheet" href="assets/css/form-elements.css">
  <link rel="stylesheet" href="assets/css/style.css"><link rel="stylesheet" type="text/css" href="successDesign.css">


  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>


  <link rel="shortcut icon" href="assets/ico/favicon.png">
</head>
<body>
<div class="top-content">
  <div class="container">
   <nav class = "navbar navbar-inverse navbar-static-top" role = "navigation">
    <ul class="nav nav-tabs">
      <li><a href="#">Translate</a></li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">User Panel <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="signup.jsp">Add User</a></li>
          <li><a href="searchuser.jsp">Search</a></li>
        </ul>
      </li>

    </ul>
    </nav>
  </div>


  <div class="inner-bg">
    <div class="container">
      <div class="row">
        <div class="col-sm-8 col-sm-offset-2 text">
          <h1>Search</h1>

        </div>
      </div>
      <div class="row">
        <div class="col-sm-6 col-sm-offset-3 form-box">
          <div class="form-top">
            <div class="form-top-left">
              <h3>Search for Users</h3>

            </div>
            <div class="form-top-right">
              <i class="fa fa-lock"></i>
            </div>
          </div>
          <div class="form-bottom">
            <form role="form" action="Login" method="post" class="search-form">
              <div class="form-group">
                <label class="sr-only">searchname</label>
                <input type="text" name="form-searchname" placeholder="Search name here ..." class="form-firstname form-control" id="form-searchname" >

              </div>
</form>
            <form role="form" action="Login" method="post" class="search-form">


              <button type="submit" class="btn">search</button>

              <div class="table-responsive">
                <table class="table">
                  

                    <th>Firstname</th>
                    <th>Lastname</th>
                    <th>DOB</th>
                    <th>Country</th>
                    <th>E-mail</th>
                    <th>Username</th>


                </table>
              </div>
              <div class="col-md-6">

                <ul class="pagination">
                  <li class="active"><a href="#">1</a></li>
                  <li ><a href="#">2</a></li>
                  <li><a href="#">3</a></li>
                  <li><a href="#">4</a></li>
                  <li><a href="#">5</a></li>
                </ul>
              </div>
            </form>
          </div>
        </div>
      </div>

    </div>
  </div>

</div>


<!-- Javascript -->
<script src="assets/js/jquery-1.11.1.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/jquery.backstretch.min.js"></script>
<script src="assets/js/scripts.js"></script>


<a href=" http://translate.yandex.com/">Powered by Yandex.Translate</a>
</body>
</html>
