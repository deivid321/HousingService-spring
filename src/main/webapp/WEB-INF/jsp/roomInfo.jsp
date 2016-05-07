<%-- 
    Document   : rooms
    Created on : Feb 29, 2016, 5:21:28 PM
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
        <title>Rooms</title>
        <style>
            #map {
                width: 520px;
                height: 400px;
            }
        </style>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <h1><spring:message code="lbl.roomInfo"/></h1>
        <div class="container">
            <!-- You can constrain the columns if you want -->
            <div class="row">
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
                                <th class="text-center"><spring:message code="lbl.street"/></td>
                                <th class="text-center"><spring:message code="lbl.houseNumber"/></td>
                                <th class="text-center"><spring:message code="lbl.roomNumber"/></td>
                                <th class="text-center"><spring:message code="lbl.free"/></td>
                                <th class="text-center"><spring:message code="lbl.freeSpace"/></td>
                                <th class="text-center"><spring:message code="lbl.students"/></td>
                                <th class="text-center"></td>
                            </tr>
                            <tr>
                                <td>${room.id}</td>
                                <td>${room.street}</td>
                                <td>${room.houseNumber}</td>
                                <td>${room.roomNumber}</td>
                                <td>${room.free}</td>
                                <td>${room.maxStudents}</td>
                                <td nowrap>
                                    <c:forEach var="student" items="${room.studentList}" varStatus="current">
                                        ${student.name} ${student.surname}
                                        <br>
                                    </c:forEach>
                                </td>
                                <td align="center"><a href="${pageContext.request.contextPath}/rooms/${room.id}.htm" class="btn btn-info" role="button"><spring:message code="lbl.edit"/></a></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="col-lg-3"></div>
                <!-- Or we could use offset -->
                <div class="col-md-8">
                    <div id="map"></div>
                    <script>
                        function initMap() {
                            var myLatLng = {lat: ${room.lat}, lng: ${room.lng}};
                            var mapDiv = document.getElementById('map');
                            var map = new google.maps.Map(mapDiv, {
                                center: myLatLng,
                                zoom: 15
                            });
                            var marker = new google.maps.Marker({
                                position: myLatLng,
                                map: map,
                                title: '${room.street}'
                            });
                        }
                    </script>
                    <script src="https://maps.googleapis.com/maps/api/js?callback=initMap"
                    async defer></script>
                </div>
            </div>
        </div>
    </body> 
</html>
