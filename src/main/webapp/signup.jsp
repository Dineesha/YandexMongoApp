<%--
  Created by IntelliJ IDEA.
  User: hsenid
  Date: 4/18/16
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

  <link rel="stylesheet" type="text/css" href="successDesign.css">


  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Register</title>

  <!-- CSS -->
  <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
  <!-- <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">-->
  <link rel="stylesheet" href="assets/css/form-elements.css">
  <link rel="stylesheet" href="assets/css/style.css">


  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

  <link rel="shortcut icon" href="assets/ico/favicon.png">

  <title>Sign Up</title>
</head>
<body>
<div class="top-content">

  <div class="inner-bg">
    <div class="container">
      <div class="row">
        <div class="col-sm-8 col-sm-offset-2 text">
          <h1>Translator Sign Up</h1>

        </div>
      </div>
      <div class="row">
        <div class="col-sm-6 col-sm-offset-3 form-box">
          <div class="form-top">
            <div class="form-top-left">
              <h3>Sign Up</h3>

            </div>
            <div class="form-top-right">
              <i class="fa fa-lock"></i>
            </div>
          </div>
          <div class="form-bottom">
            <form role="form" action="Login" method="post" class="signup-form">
              <div class="form-group">
                <label class="sr-only">firstname</label>
                <input type="text" name="form-fname" placeholder="first name..." class="form-firstname form-control" id="form-fname" size="25">
              </div>
              <div class="form-group">
                <label class="sr-only">lastname</label>
                <input type="text" name="form-lname" placeholder="last name..." class="form-lastname form-control" id="form-lname">
              </div>
<script> $('#defaultPopup,#defaultInline').datepick();</script>
              <div class="form-group">
                <input type="text" name="email" class="form-control" placeholder="example@domain.com">
                </div>

              <div class="form-group" style="position:relative;width:200px;height:25px;border:0;padding:0;margin:10px;">
                <select style="position:absolute;top:0px;left:0px;width:200px; height:25px;line-height:20px;margin:0;padding:0;" onchange="document.getElementById('displayValue').value=this.options[this.selectedIndex].text; document.getElementById('idValue').value=this.options[this.selectedIndex].value;">
                  <option></option>
                  <option value="sl">Sri Lanka</option>
                  <option value="jp">Japan</option>
                  <option value="en">England</option>
                  <option value="jp">Korea</option>
                  <option value="en">USA</option>
                </select>
                <input name="displayValue" placeholder="Select Your Country" id="displayValue" style="position:absolute;top:0px;left:0px;width:183px;width:180px\9;#width:180px;height:23px; height:21px\9;#height:18px;border:1px solid #556;" onfocus="this.select()" type="text">
                <input name="idValue" id="idValue" type="hidden">
              </div>

              <div class="form-group">
                <label class="sr-only">Username</label>
                <input type="text" name="form-name" placeholder="username..." class="form-username form-control" id="form-uname" >
              </div>
              <div class="form-group">
                <label class="sr-only" for="form-password">Password</label>
                <input type="password" name="form-password" placeholder="Password..." class="form-password form-control" id="form-password">
              </div>
              <div class="form-group">
                <label class="sr-only" for="form-password">Re-enterPassword</label>
                <input type="password" name="form-password" placeholder="Re-enter Password..." class="form-password form-control" id="form-conpassword">
              </div>
              <button type="submit" class="btn">Register</button>


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

