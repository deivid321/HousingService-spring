<%-- 
    Document   : studentUpdate
    Created on : Mar 21, 2016, 9:09:58 PM
    Author     : vdeiv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New student form</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />

        <div id="container">
            <div class="col-md-4"></div>
            <div class="col-md-4 col-sm-6 col-xs-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h1 class="panel-title">Update student</h1> 
                    </div>
                    <div class="panel-body">
                        <form:form class="form-horizontal row-border" commandName="student" role="form" method="POST" action="${pageContext.request.contextPath}/students/${student.id}.htm" >
                            <form:hidden name="id"  path="id"/>
                            <div class="form-group">
                                <label class="col-md-3 control-label" required="required"><spring:message code="lbl.name"/>:</label>
                                <div class="col-md-8">
                                    <form:input type="text" class="form-control" path="name"/>
                                    <form:errors path="name" cssClass="error" />
                                </div>
                                <label class="col-md-3 control-label"><spring:message code="lbl.surname"/>:</label>
                                <div class="col-md-8">
                                    <form:input type="text" path="surname" class="form-control" />
                                    <form:errors path="surname" cssClass="error" />
                                </div>
                                <label class="col-md-3 control-label"><spring:message code="lbl.age"/>:</label>
                                <div class="col-md-8">
                                    <form:input type="number" path="age" class="form-control" />
                                    <form:errors path="age" cssClass="error" />
                                </div>
                                <label class="col-md-3 control-label"><spring:message code="lbl.university"/>:</label>
                                <div class="col-md-8">
                                    <form:input type="text" path="university" class="form-control" />
                                    <form:errors path="university" cssClass="error" />
                                </div>
                                <label class="col-md-3 control-label"><spring:message code="lbl.country"/>:</label>
                                <div class="col-md-8">
                                    <form:input type="text" path="country" class="form-control" />
                                    <form:errors path="country" cssClass="error" />
                                </div>
                                <label class="col-md-3 control-label"><spring:message code="lbl.gender"/>:</label>
                                <div class="col-md-7">
                                    <c:set var="varMale"><spring:message code="lbl.male"/></c:set>
                                    <c:set var="varFemale"><spring:message code="lbl.female"/></c:set>
                                    <form:radiobutton path="gender" value="M" id="gender" label="${varMale}"/>
                                    <form:radiobutton path="gender" value="F" id="gender" label="${varFemale}"/>
                                    <form:errors path="gender" cssClass="error" />
                                </div>
                                <label class="col-md-3 control-label"><spring:message code="lbl.selectRoom"/></label>
                                <div class="col-md-8">
                                    <form:select class="form-control" path="room">
                                        <form:options items="${rooms}" itemValue="id" itemLabel="fullName"/>
                                    </form:select>
                                </div>
                                <p>
                                <div class="col-md-12"></div>
                                <label class="col-md-4 control-label" for="save">&nbsp;</label>
                                <div class="col-md-4">
                                    <input id="save" type="submit" class="form-control" value="<spring:message code="lbl.save"/>">
                                </div>
                                </p>
                            </div>
                        </form:form>
                        <div class="col-md-9"></div>
                        <div class="col-md-1">
                            <form:form method="POST" commandName="student" role="form" action="${pageContext.request.contextPath}/students/remove/${student.id}.htm" >
                                <form:input type="hidden" path="id" />
                                <input class="btn btn-warning" type="submit" name="delete_student" value="<spring:message code="lbl.deleteStudent"/>" onclick="return confirm('Are you sure you want to delete this student?')" />
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
