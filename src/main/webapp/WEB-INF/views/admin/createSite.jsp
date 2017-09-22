<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="row">
	<div class="col-md-3"></div>
	<div class="col-md-7 col-sm-12 col-xs-12">
		<form:form class="form-horizontal" action="/user/${user.id}/createSite"
			method="POST" modelAttribute="site">
			<div class="form-group">
				<label for="nameOfS" class="col-sm-2 control-label">Site</label>
				<div class="col-sm-7">
					<form:input class="form-control" path="nameOfS" id="nameOfS" />
				</div>
			</div>
			<div class="form-group">
				<label for="loginOnS" class="col-sm-2 control-label">Login</label>
				<div class="col-sm-7">
					<form:textarea class="form-control" path="loginOnS" id="loginOnS" rows="5"/>
				</div>
			</div>
			<div class="form-group">
				<label for="login" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-7">
					<form:textarea class="form-control" path="pass" id="pass" rows="5"/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-7">
					<button type="submit" class="btn btn-success btn-block">Create</button>
				</div>
			</div>
		</form:form>
	</div>
</div>