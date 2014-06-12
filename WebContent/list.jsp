<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/css/bootstrap.css"/>
<title>Insert title here</title>
</head>
<body>


<div class="jumbotron">
	<h1>The <sub>great </sub> album  <sub>machine</sub></h1>
</div>

 	<sql:query dataSource="jdbc/quoteDB"
 	sql="select * from quote"
 	var="results"></sql:query>
 	
 	<div class="container">
 	<c:forEach items="${results.rows}" var="row">
 	<blockquote>
 	<p>${row.album}</p>
 	<footer>${row.artist}</footer>
 	</blockquote>
 	</c:forEach>
 	</div>

 	
 		<div class ="container">
	<footer>
		<p> the quote database contains ${fn:length(results.rows)} quote.
			
		
			
		</p>
	</footer>
	</div>
	<IMG SRC="http://www.gotyourhandsfull.com/wp-content/uploads/2014/05/skull-and-bones-coloring-pages.jpg" ALT="some text" WIDTH=32 HEIGHT=32>
	<IMG SRC="http://www.gotyourhandsfull.com/wp-content/uploads/2014/05/skull-and-bones-coloring-pages.jpg" ALT="some text" WIDTH=32 HEIGHT=32>
	<IMG SRC="http://www.gotyourhandsfull.com/wp-content/uploads/2014/05/skull-and-bones-coloring-pages.jpg" ALT="some text" WIDTH=32 HEIGHT=32>
	<IMG SRC="http://www.gotyourhandsfull.com/wp-content/uploads/2014/05/skull-and-bones-coloring-pages.jpg" ALT="some text" WIDTH=32 HEIGHT=32>
	<IMG SRC="http://www.gotyourhandsfull.com/wp-content/uploads/2014/05/skull-and-bones-coloring-pages.jpg" ALT="some text" WIDTH=32 HEIGHT=32>
	
</body>


<script src="/js/bootstrap.js"></script>
