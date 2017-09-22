<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<div class="col-md-4 col-xs-12">
	<div class="row">
	<div class="col-md-12 col-xs-12">
		<h4>Decrypted key:</h4>
		<input value="${decText}">
	</div>
	</div>
	<div class="row">
		<div class="col-md-12 col-xs-12">
			<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
		</div>
	</div>
</div>
<div class="col-md-8">
	 	<table class="table table-condensed">
    <thead>
      <tr>
        <th>Site</th>
        <th>Login</th>
	    <th>Password</th>
	    <th>Option</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.content}" var="site">
	 	<tr>
	 		<td><a href="http://${site.nameOfS}">${site.nameOfS}</a></td>
	 		<td>${site.loginOnS}</td>
	 		<td>${site.pass}</td>
	 		<td><a class="btn btn-danger btn-xs" href="/user/${users.id}/deleteSite/${site.id}">delete</a>
	 		<a class="btn btn-warning btn-xs" href="/user/${users.id}/editSite/${site.id}">edit</a>
	 		<a class="btn btn-danger btn-xs" href="/user/${users.id}/dec/${site.id}">decrypt</a></td>
	 	</tr>
	 </c:forEach>
    </tbody>
  </table>
  <div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>"
			container="<ul class='pagination'></ul>" />
	</div>
</div>
	</div>