<%@ page import="com.mongodb.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
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
  <link rel="stylesheet" href="assets/bootstrap-table-master/src/bootstrap-table.css">
  <script type="text/javascript" src="assets/bootstrap-table-master/src/bootstrap-table.js"></script>
 <script src="assets/bootstrap-table-master/dist/locale/*"></script>
    <script src="assets/bootstrap-table-master/dist/bootstrap-table-locale-all.js"></script>
    <script src="assets/bootstrap-table-master/dist/bootstrap-table-locale-all.min.js"></script>
    <script src="assets/bootstrap-table-master/dist/bootstrap-table.min.js"></script>
    <link rel="stylesheet" href="assets/bootstrap-table-master/dist/bootstrap-table.min.css">




  <link rel="shortcut icon" href="assets/ico/favicon.png">
</head>
<body>
<div class="container">
  <nav class = "navbar navbar-inverse navbar-fixed-top" role = "navigation">
    <ul class="nav navbar-nav">
      <li ><a href="success.jsp">Translate</a></li>
      <li class="dropdown">
        <a class="dropdown-toggle-active" data-toggle="dropdown" href="#">User Panel <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="signup.jsp">Add User</a></li>
          <li><a href="searchuser.jsp">Search</a></li>
        </ul>
      </li>

    </ul>
  </nav>
</div>
<div class="top-content">


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
              <p style="color:#ff0913">
                <%
                  if(null!=request.getAttribute("errorMessage"))
                  {
                    out.println(request.getAttribute("errorMessage"));
                  }
                %></p>
            </div>
            <div class="form-top-right">
              <i class="fa fa-lock"></i>

            </div>
          </div>
          <div class="form-bottom">
            <form role="form" action="SearchServlet" method="post" class="search-form">
              <div class="form-group">
                <label class="sr-only">searchname</label>
                <input type="text" name="form-searchname" placeholder="Search name here ..." class="form-firstname form-control" id="form-searchname" >

              </div>
              <button type="submit" class="btn">search</button>

            </form>



          </div>
        </div>
      </div>

    </div>
  </div>

</div>
</div>
<p>
  <%
  if (null!=request.getAttribute("searchMessage")) {

    String searchName = request.getParameter("form-searchname");

    MongoClient mongoC = new MongoClient(new ServerAddress("Localhost", 27017));

    DB database = mongoC.getDB("login_form");
    DBCollection collec1 = database.getCollection("test_user1");
    BasicDBObject searchQuery = new BasicDBObject();
    searchQuery.put("fname", searchName);
    for( DBObject dock : collec1.find(searchQuery) ) {
      String fname = (String) dock.get( "fname" );
      String lname = (String) dock.get( "lname" );
      String dob = (String) dock.get( "dob" );
      String country = (String) dock.get( "country" );
      String email = (String) dock.get( "email" );
      String username = (String) dock.get( "username" );
      out.println(fname);
      out.println(lname);
      out.println(dob);
      out.println(country);
      out.println(email);
      out.println(username);
      out.println();
      ArrayList<String> list1 =  new ArrayList<String>();
      list1.add(fname);
      list1.add(lname);
      list1.add(dob);
      list1.add(country);
      list1.add(email);
      list1.add(username);



    }
  }
%></p>

<div class="container">
  <div class="table-responsive-editable">
    <table class="table" >

<tr style="color: Highlight">
      <th>Firstname</th>
      <th>Lastname</th>
      <th>DOB</th>
      <th>Country</th>
      <th>E-mail</th>
      <th>Username</th>
  <th>Activity</th>
</tr>
      <tr style="color: #ffffff">
        <td><%
          String searchName = request.getParameter("form-searchname");
          MongoClient mongoC = new MongoClient(new ServerAddress("Localhost", 27017));
          DB database = mongoC.getDB("login_form");
          DBCollection collec1 = database.getCollection("test_user1");
          BasicDBObject searchQuery = new BasicDBObject();
          searchQuery.put("fname", searchName);
          for( DBObject dock : collec1.find(searchQuery) ) {
            String fname = (String) dock.get("fname");
            out.println(fname);
            out.println("<BR>");

          }%>
        </td>
        <td><%
          for( DBObject dock : collec1.find(searchQuery) ) {
            String lname = (String) dock.get("lname");
            out.println(lname);
            out.println("<BR>");

          }%> </td>
        <td><%
          for( DBObject dock : collec1.find(searchQuery) ) {
            String dob = (String) dock.get("dob");
            out.println(dob);
            out.println("<BR>");

          }%>  </td>
        <td> <%
          for( DBObject dock : collec1.find(searchQuery) ) {
            String country = (String) dock.get("country");
            out.println(country);
            out.println("<BR>");

          }%> </td>
        <td><%
          for( DBObject dock : collec1.find(searchQuery) ) {
            String email = (String) dock.get("email");
            out.println(email);
            out.println("<BR>");

          }%> </td>
        <td> <%
          for( DBObject dock : collec1.find(searchQuery) ) {
            String username = (String) dock.get("username");
            out.println(username);
            out.println("<BR>");

          }%> </td>
<td>  <input type="image" src="assets/ico/Awicons-Vista-Artistic-Delete.ico" alt="Submit" width="48" height="48"></td>

      </tr>


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
  </div></div>

<!-- Javascript -->
<script src="assets/js/jquery-1.11.1.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/jquery.backstretch.min.js"></script>
<script src="assets/js/scripts.js"></script>


<a href=" http://translate.yandex.com/">Powered by Yandex.Translate</a>
</body>
</html>
