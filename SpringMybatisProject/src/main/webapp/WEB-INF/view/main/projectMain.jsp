<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="main/css/main.css">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js" charset="utf-8"></script>


<script type="text/javascript">


var TIMEOUT = 5000;

var interval = setInterval(handleNext, TIMEOUT);
 
function handleNext() {
 
  var $radios = $('input[class*="slide-radio"]');
  var $activeRadio = $('input[class*="slide-radio"]:checked');
 
  var currentIndex = $activeRadio.index();
  var radiosLength = $radios.length;
 
  $radios
    .attr('checked', false);
 
  if(currentIndex >= radiosLength - 1) {
 
    $radios
      .first()
      .attr('checked', true);
 
  }else{
 
    $activeRadio
      .next('input[class*="slide-radio"]')
      .attr('checked', true);
 
  }
 
}
	

</script>
</head>
<body>
<!-- Navigation -->
<div class="navigation">
  <div class="navigation-left">
    <a href="#">Shoes</a>
    <a href="#">Clothes</a>
    <a href="#">Accessories</a>
  </div>
  <div class="navigation-center">
    <img src="images/logo.png" alt="">
  </div>
  <div class="navigation-right">
    <a href="#"><img src="images/shopping-bag.png" alt=""></a>
    <button class="login-btn" href="#">Login</button>
  </div>
</div>
 
<!-- Slider Wrapper -->
<div class="css-slider-wrapper">
  <input type="radio" name="slider" class="slide-radio1" checked id="slider_1">
  <input type="radio" name="slider" class="slide-radio2" id="slider_2">
  <input type="radio" name="slider" class="slide-radio3" id="slider_3">
  <input type="radio" name="slider" class="slide-radio4" id="slider_4">
 
  <!-- Slider Pagination -->
  <div class="slider-pagination">
    <label for="slider_1" class="page1"></label>
    <label for="slider_2" class="page2"></label>
    <label for="slider_3" class="page3"></label>
    <label for="slider_4" class="page4"></label>
  </div>
 
  <!-- Slider #1 -->
  <div class="slider slide-1">
    <img src="main/images/life.jpg" alt="" style="width: 100%; height: 100%;">
    <div class="slider-content">
      <h4>New Product</h4>
      <h2>Denim Longline T-Shirt Dress With Split</h2>
      <button type="button" class="buy-now-btn" name="button">쇼핑</button>
    </div>
    <div class="number-pagination">
      <span>1</span>
    </div>
  </div>
 
  <!-- Slider #2 -->
  <div class="slider slide-2">
    <img src="main/images/Hotel1.jpg" alt=""  style="width: 100%; height: 100%;">
    <div class="slider-content">
      <h4>New Product</h4>
      <h2>Denim Longline T-Shirt Dress With Split</h2>
      <button type="button" class="buy-now-btn" name="button">오피스텔</button>
    </div>
    <div class="number-pagination">
      <span>2</span>
    </div>
  </div>
 
  <!-- Slider #3 -->
  <div class="slider slide-3">
    <img src="main/images/home.jpg" alt=""  style="width: 100%; height: 100%;">
    <div class="slider-content">
      <h4>New Product</h4>
      <h2>Denim Longline T-Shirt Dress With Split</h2>
      <button type="button" class="buy-now-btn" name="button">홈서비스</button>
    </div>
    <div class="number-pagination">
      <span>3</span>
    </div>
  </div>
 
  <!-- Slider #4 -->
  <div class="slider slide-4">
    <img src="main/images/commu.jpg" alt=""  style="width: 100%; height: 100%;">
    <div class="slider-content">
      <h4>New Product</h4>
      <h2>Denim Longline T-Shirt Dress With Split</h2>
      <button type="button" class="buy-now-btn" name="button">커뮤니티</button>
    </div>
    <div class="number-pagination">
      <span>4</span>
    </div>
  </div>
</div>


</body>
</html>