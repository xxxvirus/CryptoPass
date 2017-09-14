<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
 <link href="resources/css/page.css" rel="stylesheet">
<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">CryptoPass</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="#about">About</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#service">Services</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#contact">Contact</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
<!-- Header -->
<div class="head intro-header">
	<div class="container">
		<div class="intro-message">
			<h1>CryptoPass</h1>
			<h3>Your service saving passwords</h3>
			<hr class="intro-divider">
			<sec:authorize access="!isAuthenticated()">
			<ul class="list-inline intro-social-buttons">
				<li class="list-inline-item"><a href="/login"
					class="btn btn-secondary btn-lg"> <span class="network-name">Login</span>
				</a></li>
				<li class="list-inline-item"><a href="/registration"
					class="btn btn-secondary btn-lg"> <span class="network-name">Registration</span>
				</a></li>
			</ul>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
			<ul class="list-inline intro-social-buttons">
				<li class="list-inline-item"><a href="/user"
					class="btn btn-secondary btn-lg"> <span class="network-name">My Panel</span>
				</a></li>
				<li class="list-inline-item"><form:form action="/logout" method="POST">
					<button type="submit" class="btn btn-secondary btn-lg"><span class="network-name">Logout</span></button>
				</form:form></li>
			</ul>
			</sec:authorize>
		</div>
	</div>
</div>

<!-- Page Content -->
<section class="content-section-a">

	<div class="container">
		<div class="row">
			<div class="col-lg-5 ml-auto">
				<hr class="section-heading-spacer">
				<div class="clearfix"></div>
				<h2 class="section-heading" id="about">How it works</h2>
				<p class="lead">Every user has his personal RSA-key. All your
					passwors will be encrypted by random-generated AES-key and with
					your Private RSA-key. Only you can decrypt and see you passwords to
					all your website.</p>
			</div>
			<div class="col-lg-5 mr-auto">
				<img class="img-fluid" src="/resources/img/crypto1.jpg" alt="">
			</div>
		</div>

	</div>
	<!-- /.container -->
</section>

<section class="content-section-b">

	<div class="container">

		<div class="row">
			<div class="col-lg-5 mr-auto order-lg-2">
				<hr class="section-heading-spacer">
				<div class="clearfix"></div>
				<h2 class="section-heading" id="service">Service</h2>
				<ul><li><p class="lead">Protected key</p></li>
				<li><p class="lead">Key-generator</p></li></ul>
			</div>
			<div class="col-lg-5 ml-auto order-lg-1">
				<img class="img-fluid" src="/resources/img/crypto2.jpg" alt="">
			</div>
		</div>

	</div>
	<!-- /.container -->

</section>

<aside class="banner">

	<div class="container">

		<div class="row">
			<div class="col-lg-6 my-auto">
				<h2 id="contact">Contact with us:</h2>
			</div>
			<div class="col-lg-6 my-auto">
				<ul class="list-inline banner-social-buttons">
					<li class="list-inline-item"><a href="https://www.facebook.com/pavlo.vorobets"
						class="btn btn-secondary btn-lg"> <i
							class="fa fa-facebook fa-fw"></i> <span class="network-name">Facebook</span>
					</a></li>
					<li class="list-inline-item"><a href="https://github.com/xxxvirus"
						class="btn btn-secondary btn-lg"> <i
							class="fa fa-github fa-fw"></i> <span class="network-name">Github</span>
					</a></li>
					<li class="list-inline-item"><a href="https://linkedin.com"
						class="btn btn-secondary btn-lg"> <i
							class="fa fa-linkedin fa-fw"></i> <span class="network-name">Linkedin</span>
					</a></li>
				</ul>
			</div>
		</div>

	</div>
	<!-- /.container -->

</aside>
<!-- /.banner -->

<!-- Footer -->
<footer>
	<div class="container">
		<ul class="list-inline">
			<li class="list-inline-item"><a href="#">Home</a></li>
			<li class="footer-menu-divider list-inline-item">&sdot;</li>
			<li class="list-inline-item"><a href="#about">About</a></li>
			<li class="footer-menu-divider list-inline-item">&sdot;</li>
			<li class="list-inline-item"><a href="#service">Services</a></li>
			<li class="footer-menu-divider list-inline-item">&sdot;</li>
			<li class="list-inline-item"><a href="#contact">Contact</a></li>
		</ul>
		<p class="copyright text-muted small">Copyright &copy; Pavlo
			Vorobets 2017. All Rights Reserved</p>
	</div>
</footer>
