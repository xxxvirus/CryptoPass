<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container-fluid">
<div class="col-md-12"></div>
<div class="row">
	<div class="col-md-3"></div>
	<div class="col-md-7 col-sm-12 col-xs-12">
		<form:form class="form-horizontal" action="/registration"
			method="POST" modelAttribute="user">
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">Login</label>
				<div class="col-sm-7">
					<form:input class="form-control" path="login" id="login" />
				</div>
				<label class="col-sm-3 control-label" for="email"
					style="color: red; text-align: left;"><form:errors
						path="email" /></label>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-2 control-label">Email</label>
				<div class="col-sm-7">
					<form:input class="form-control" path="email" id="email" />
				</div>
				<label class="col-sm-3 control-label" for="email"
					style="color: red; text-align: left;"><form:errors
						path="email" /></label>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-7">
					<form:input class="form-control" type="password" path="password" id="password" />
				</div>
				<label class="col-sm-3 control-label" for="password"
					style="color: red; text-align: left;"><form:errors
						path="password" /></label>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-7">
					<button type="submit" class="btn btn-success btn-block">Register</button>
				</div>
			</div>
		</form:form>
	</div>
</div>
</div>