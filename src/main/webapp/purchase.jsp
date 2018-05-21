<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!------ Include the above in your HEAD tag ---------->


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <style>
    a.list-group-item {
        height:auto;
        min-height:220px;
    }
    a.list-group-item.active small {
        color:#fff;
    }

    </style>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/css/login.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>


  <div class="navbar navbar-inverse navbar-static-top">

   <div class="container">

        <div class="collapse navbar-collapse navHeaderCollapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="${contextPath}/purchase">Your purchases</a></li>
            <li><a href="${contextPath}/logout">Log out</a></li>
          </ul>
        </div>
      </div>
    </div>

<body>
<div class="container">
    <div class="row">
		<div class="well">
        <h1 class="text-center">Products you bought</h1>
        <div class="list-group">

          <c:forEach items="${purchases}" var="purchase">
          <a href="#" class="list-group-item">
                <div class="media col-md-3">
                    <figure class="pull-left">
                        <img src="images/${purchase.product.picturePath}.jpg" height="200" width="200"  alt="placehold.it/350x250" >
                    </figure>
                </div>
                <div class="col-md-6">

                    <h2 class="list-group-item-text">
                            ${purchase.product.name}
                    </h2>
                </div>
                <div class="col-md-3 text-center">
                    <h2> ${purchase.product.price} <small> dollars </small></h2>
                    <p>  ${purchase.time} </p>
                </div>
        </a>
	    </c:forEach>
	         <a href="#" class="list-group-item">
                        <div class="media col-md-3">
                        <figure class="pull-left">
                            <img src="images/white.jpg" height="200" width="200"  alt="placehold.it/350x250" >
                        </figure>
                        </div>
                        <div class="col-md-6">

                        <h2 class="list-group-item-text">
                            Total sum of all bought products
                        </h2>
                        </div>
                        <div class="col-md-3 text-center">
                             <h2> ${sum} <small> dollars </small></h2>
                        </div>
              </a>
        </div>
        </div>
	</div>
</div>
</body>
</html>




