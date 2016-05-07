<%-- 
    Document   : students
    Created on : Mar 21, 2016, 3:27:55 PM
    Author     : vdeiv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Students Page</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <h1><spring:message code="lbl.students"/></h1>
        <div class="container" align="center">

            <!-- You can constrain the columns if you want -->
            <div class="row" align="center">

                <!--We could move it to the right with a blank div -->
                <div class="col-md-2"></div>

                <!-- Or we could use offset -->
                <div class="col-md-8">

                    <!-- The table class adds nice spacing and the other classes add additional style -->
                    <table class="table table-bordered table-striped table-hover" align="center">
                        <tbody>
                            <tr>

                                <!-- You can adjust the width of table columns as well -->
                                <!--<th class="col-md-2"></td> -->

                                <!-- Use text alignment like text-center or text-right -->
                                <th class="text-center">Id</td>
                                <th class="text-center"><spring:message code="lbl.name"/></td>
                                <th class="text-center"><spring:message code="lbl.surname"/></td>
                                <th class="text-center"><spring:message code="lbl.age"/></td>
                                <th class="text-center"><spring:message code="lbl.university"/></td>
                                <th class="text-center"><spring:message code="lbl.country"/></td>
                                <th class="text-center"><spring:message code="lbl.gender"/></td>
                                <th class="text-center"><spring:message code="lbl.rooms"/></td>
                                <th class="text-center"></td>
                            </tr>
                            <c:forEach var="student" items="${students}" varStatus="current">
                                <tr>
                                    <td>${student.id}</td>
                                    <td>${student.name}</td>
                                    <td>${student.surname}</td>
                                    <td>${student.age}</td>
                                    <td>${student.university}</td>
                                    <td>${student.country}</td>
                                    <td>${student.gender}</td>
                                    <td>${student.room.fullName}</td>
                                    <td align="center"><a href="<c:url value="students/${student.id}.htm"/>" class="btn btn-info" role="button"><spring:message code="lbl.edit"/></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
<form method="GET" action="<c:url value="/students/new.htm" />">
    <button type="submit" class = "btn btn-df btn-lg" role = "button"><spring:message code="lbl.addStudent" /></button>
</form>
</html>
