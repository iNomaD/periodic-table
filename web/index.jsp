<%@ page import="fi.jyu.periodictable.PeriodicElement" %>
<%@ page import="java.util.List" %>
<%@ page import="fi.jyu.periodictable.ServiceResponseProcessor" %><%--
  Created by IntelliJ IDEA.
  User: Denis
  Date: 08.09.2017
  Time: 0:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Periodic Table</title>
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <script type='text/javascript' src='scripts/script.js'></script>
  </head>

  <body>
    <h1>Periodic Table</h1>
    <%
        List<PeriodicElement> list = ServiceResponseProcessor.getElements();
        for(PeriodicElement e : list){
            %>
            <button class="myButton"><span class="text"><%= e.getElementName() %></span></button>
            <%
        }
    %>
  </body>
</html>
