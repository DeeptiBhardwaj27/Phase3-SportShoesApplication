<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>.error{
	color: red;
	font-style: italic;
}
</style>
</head>
<center>
<h2>Order Shoes</h2>
<body>
	<form:form modelAttribute="bObj" method="POST" action="orderShoes.html">
		<table>
			<tr>
				<td>Sport Shoes Brand Name</td>
				<td><form:select path="sportShoesBrand">
					<form:option value="" label="--select--"/>
					<form:options items="${shoesList}"></form:options>
				</form:select>
			</tr>
			
			<tr>
				<td>Accessories Name</td>
				<td><form:select path="accessories">
					<form:option value="" label="--select--"/>
					<form:options items="${accessoriesList}"></form:options>
				</form:select>
			</tr>
		
			<tr>
				<td>Number of Shoes</td>
				<td><form:input path="noOfShoes"/></td>
				<td><form:errors path="noOfShoes" cssClass="error"></form:errors>
			</tr>
		
			<tr>
				<td><input type="submit" value="Order"></td>
			</tr>
		</table>
	</form:form>
</body>
</center>
</html>