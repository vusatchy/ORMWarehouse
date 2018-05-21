<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">
  <head>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>eCommerce Product Detail</title>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
    <link href="${contextPath}/css/sprod.css" rel="stylesheet">
    <script src='//production-assets.codepen.io/assets/editor/live/console_runner-079c09a0e3b9ff743e39ee2d5637b9216b3545af0de366d4b9aad9dc87e26bfd.js'></script><script src='//production-assets.codepen.io/assets/editor/live/events_runner-73716630c22bbc8cff4bd0f07b135f00a0bdc5d14629260c3ec49e5606f98fdd.js'></script><script src='//production-assets.codepen.io/assets/editor/live/css_live_reload_init-2c0dc5167d60a5af3ee189d570b1835129687ea2a61bee3513dee3a50c115a77.js'></script><meta charset='UTF-8'><meta name="robots" content="noindex"><link rel="shortcut icon" type="image/x-icon" href="//production-assets.codepen.io/assets/favicon/favicon-8ea04875e70c4b0bb41da869e81236e54394d63638a1ef12fa558a4a835f1164.ico" /><link rel="mask-icon" type="" href="//production-assets.codepen.io/assets/favicon/logo-pin-f2d2b6d2c61838f7e76325261b7195c27224080bc099486ddd6dccb469b8e8e6.svg" color="#111" /><link rel="canonical" href="https://codepen.io/debute/pen/axzkb?limit=all&page=2&q=comment" />

    <link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css'><link rel='stylesheet prefetch' href='//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>
    <style class="cp-pen-styles">@-webkit-keyframes rotating {
      from {
        -webkit-transform: rotate(0deg);
      }
      to {
        -webkit-transform: rotate(360deg);
      }
    }
    @-moz-keyframes rotating {
      from {
        -moz-transform: rotate(0deg);
      }
      to {
        -moz-transform: rotate(360deg);
      }
    }
    @-o-keyframes rotating {
      from {
        -o-transform: rotate(0deg);
      }
      to {
        -o-transform: rotate(360deg);
      }
    }
    @keyframes rotating {
      from {
        transform: rotate(0deg);
      }
      to {
        transform: rotate(360deg);
      }
    }
    .comments {
      width: 500px;
      min-height: 150px;
      position: absolute;
      left: 275px;
      margin: 15px auto;
      padding: 20px;
      font-family: "Helvetica Neue",arial,sans-serif;
      font-size: 15px;
    }
    .comments .loader {
      height: 45px;
      width: 45px;
      border: 4.5px solid rgba(0, 0, 0, 0.2);
      border-radius: 50%;
      border-left-color: #000;
      position: absolute;
      top: 70px;
      left: 245.5px;
      -webkit-animation: rotating 0.9s infinite linear;
      -moz-animation: rotating 0.9s infinite linear;
      -o-animation: rotating 0.9s infinite linear;
      animation: rotating 0.9s infinite linear;
    }
    .comments .inner {
      display: none;
    }
    .comments .inner .comment {
      border: 1px dashed #ccc;
      padding: 15px;
      min-height: 48px;
      margin-bottom: 10px;
      color: #ccc;
    }
    .comments .inner .comment .avatar {
      width: 48px;
      height: 48px;
      float: left;
    }
    .comments .inner .comment .body {
      margin-left: 55px;
    }
    .comments .inner .comment .body p {
      color: black;
    }
    .comments .inner .comment:hover {
      color: rgba(0, 39, 59, 0.35);
      background-color: rgba(200, 200, 200, 0.1);
      border-style: solid;
    }

    .add-new {
      margin-bottom: 55px;
    }
    .add-new .input {
      display: block;
      width: 475px;
      border: 3px solid #ccc;
      color: #888;
      padding: 8px 10px;
      outline: 0;
      font-family: "Helvetica Neue",arial,sans-serif;
      font-size: 15px;
    }
    .add-new .input.your-name {
      border-top-left-radius: 5px;
      border-top-right-radius: 5px;
    }
    .add-new .input.your-name.dived {
      margin-top: 2px;
      padding: 9px 10px 11px 10px;
    }
    .add-new .input.your-msg {
      margin-top: -5px;
      max-width: 475px;
      max-height: 150px;
      border-bottom-left-radius: 5px;
      border-bottom-right-radius: 5px;
    }
    .add-new .send-msg {
      border: 3px solid #ccc;
      color: #888;
      text-transform: uppercase;
      font-weight: bold;
      border-radius: 5px;
      padding: 8px 10px;
      background-color: transparent;
      outline: 0;
      float: right;
      margin-right: -1px;
      cursor: pointer;
    }
    .add-new .send-msg:hover {
      color: white;
      background-color: #ccc;
    }

    a {
      color: #408ac9;
      text-decoration: none;
    }
    a:hover {
      text-decoration: underline;
    }
    </style>

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
		<div class="card">
			<div class="container-fliud">
				<div class="wrapper row">
					<div class="preview col-md-6">

						<div class="preview-pic tab-content">
						  <div class="tab-pane active" id="pic-1"><img src="images/${product.picturePath}.jpg" /></div>
						</div>
					</div>
					<div class="details col-md-6">
						<h3 class="product-title">"${product.name}"</h3>
							<p class="product-description">
							Here should be long product description.
							Here should be long product description.
							Here should be long product description.
							Here should be long product description.
							Here should be long product description.
							Here should be long product description.
							</p>
						<h4 class="price">current price: <span>${product.price}</span></h4>
						<h4 class="avaliable">avaliable: <span>${product.avaliable}</span></h4>
						<div class="action">
						    <form action="${contextPath}/purchase?id=${product.id}" method = "post">
							<button class="add-to-cart btn btn-default" type="submit">Buy</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class='comments'>
      <div class='loader'></div>
      <div class='inner'>
        <div class='add-new'>
          <textarea class='input your-msg' placeholder='Type your message here...'></textarea>
          <button class='send-msg'>Send message</button>
        </div>
      </div>
    </div>
    <script src='//production-assets.codepen.io/assets/common/stopExecutionOnTimeout-b2a7b3fe212eaa732349046d8416e00a9dec26eb7fd347590fbced3ab38af52e.js'></script><script src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script><script src='//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'></script>
    <script >var defaultAvatar = 'https://i.imgur.com/BDuNOi3.png';
    var guestuserId = '${myAtt}'
    var guestusername =  '${myAtt}';

    function stopLoader() {
      $('.loader').fadeOut('slow', function() {
        $('.comments .inner').fadeIn('slow');
      });
    }

    $(function() {
      var allComments = new Array();
      <c:forEach items = "${product.feedbacks}" var = "feedback">
          feedbackAdd = new Object();
          feedbackAdd.name = '${feedback.user.login}';
          feedbackAdd.avatar = 'default';
          feedbackAdd.before = '${feedback.date}';
          feedbackAdd.message = "${feedback.comment}";
          allComments.push(feedbackAdd);
      </c:forEach>
      console.log('The end')
      var loaded = 0;

      $.each(allComments, function(i, val) {
        var comment = $('<div class="comment"></div>');
        var avatar = this.avatar == 'default' ? defaultAvatar : this.avatar;
        $('<img class="avatar" alt="avatar" src="' + avatar + '" />').appendTo(comment);
        var contents = $('<div class="body"></div>');
        $('<a href="./users/' + this.userid + '/" target="_blank">' + this.name + '</a>').appendTo(contents);
        $('<span>  ' + this.before + '</span><br /><br />').appendTo(contents);
        $('<p>' + this.message + '</p>').appendTo(contents);

        contents.appendTo(comment);
        comment.appendTo('.comments .inner');
        loaded++;
      });

      if(loaded == allComments.length) stopLoader();

      $('.send-msg').click(function() {
        var name = '${sessionScope.name}'
        var msg = $('.your-msg').val();
        var comment = $('<div class="comment" style="display: none;"></div>');
        var contents = $('<div class="body"></div>')


        if((name == '' && guestusername == '') || msg == '') return false;
        guestusername = guestusername == '' ? name : guestusername;
        $('.your-msg').val("");

        $('.your-name').fadeOut().remove();
        $('.your-msg').before('<div class="input your-name dived">' + guestusername + '</div>');

        $('<img class="avatar" alt="avatar" src="' + defaultAvatar + '" />').appendTo(comment);
        $('<a href="./users/' + guestuserId + '/" target="_blank">' + guestusername + '</a>').appendTo(contents);
        $('<span>   Right now</span><br /><br />').appendTo(contents);
        $('<p>' + msg + '</p>').appendTo(contents);

        contents.appendTo(comment);
        $('.add-new').after(comment);
        comment.fadeIn('slow');
          $.post("http://localhost:8080/feedback",
                    {
                        user: "${sessionScope.id}",
                        product: "${product.id}",
                        comment: msg
                    },
                    function(data, status){
                        console.log("Data: " + data + "\nStatus: " + status);
                    });
      });
    });
    //# sourceURL=pen.js
    </script>


  <div class="modal fade product_view" id="product_view">
      <div class="modal-dialog">
          <div class="modal-content">
              <div class="modal-header">
                  <a href="#" data-dismiss="modal" class="class pull-right"><span class="glyphicon glyphicon-remove"></span></a>
                  <h3 class="modal-title">HTML5 is a markup language</h3>
              </div>
              <div class="modal-body">
                  <div class="row">
                      <div class="col-md-6 product_img">
                          <img src="http://img.bbystatic.com/BestBuy_US/images/products/5613/5613060_sd.jpg" class="img-responsive">
                      </div>
                      <div class="col-md-6 product_content">
                          <h4>Product Id: <span>51526</span></h4>
                          <div class="rating">
                              <span class="glyphicon glyphicon-star"></span>
                              <span class="glyphicon glyphicon-star"></span>
                              <span class="glyphicon glyphicon-star"></span>
                              <span class="glyphicon glyphicon-star"></span>
                              <span class="glyphicon glyphicon-star"></span>
                              (10 reviews)
                          </div>
                          <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                          <h3 class="cost"><span class="glyphicon glyphicon-usd"></span> 75.00 <small class="pre-cost"><span class="glyphicon glyphicon-usd"></span> 60.00</small></h3>
                          <div class="row">
                              <div class="col-md-4 col-sm-6 col-xs-12">
                                  <select class="form-control" name="select">
                                      <option value="" selected="">Color</option>
                                      <option value="black">Black</option>
                                      <option value="white">White</option>
                                      <option value="gold">Gold</option>
                                      <option value="rose gold">Rose Gold</option>
                                  </select>
                              </div>
                              <!-- end col -->
                              <div class="col-md-4 col-sm-6 col-xs-12">
                                  <select class="form-control" name="select">
                                      <option value="">Capacity</option>
                                      <option value="">16GB</option>
                                      <option value="">32GB</option>
                                      <option value="">64GB</option>
                                      <option value="">128GB</option>
                                  </select>
                              </div>
                              <!-- end col -->
                              <div class="col-md-4 col-sm-12">
                                  <select class="form-control" name="select">
                                      <option value="" selected="">QTY</option>
                                      <option value="">1</option>
                                      <option value="">2</option>
                                      <option value="">3</option>
                                  </select>
                              </div>
                              <!-- end col -->
                          </div>
                          <div class="space-ten"></div>
                          <div class="btn-ground">
                              <button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-shopping-cart"></span> Add To Cart</button>
                              <button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-heart"></span> Add To Wishlist</button>
                          </div>
                      </div>
                  </div>
              </div>
          </div>
      </div>
  </div>




  </body>
</html>
