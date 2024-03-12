<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
</head>
<body>


	<div class="container">
		<h3>Report-Generation</h3>
		<form:form action="searchData" modelAttribute="search" method="post">
			<table>
				<tr>
					<td>Plan Name:</td>
					<td><form:select path="planname">
							<form:option value=""> -select- </form:option>
							<form:options items="${names}"/>
						</form:select></td>
					<td>Plan Status:</td>
					<td><form:select path="planstatus">
							<form:option value=""> -select- </form:option>
							<form:options items="${status}"/>
						</form:select></td>
					<td>Gender:</td>
					<td><form:select path="gender">
							<form:option value=""> -select- </form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="Fe-Male">Fe-Male</form:option>
						</form:select></td>
				</tr>
				<tr>
					<td>Start Date:</td>
					<td><form:input path="startdate" type="date" /></td>
					<td>End Date:</td>
					<td><form:input path="enddate" type="date" /></td>
				</tr>
				<tr>
					<td><a href="/" class="btn btn-success">Reset</a></td>
					<td><button type=submit value="Search" class="btn btn-primary">search</td>
				</tr>
			</table>


			<hr>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<td>Sl.no</td>
						<td>Holder Name</td>
						<td>Plan Name</td>
						<td>Gender</td>
						<td>Plan Status</td>
						<td>Start Date</td>
						<td>End Date</td>
						<td>BenifitAmount</td>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${plans}" var="plan" varStatus="index">
						<tr>
							<td>${index.count}</td>
							<td>${plan.citizen_name}</td>
							<td>${plan.plan_name}</td>
							<td>${plan.gender}</td>
							<td>${plan.plan_status}</td>
							<td>${plan.plan_start_date}</td>
							<td>${plan.plan_end_date}</td>
							<td>${plan.benifit_amount}</td>
						</tr>
					</c:forEach>
					
					<c:if test="${empty plans}">
					<tr>
					 <td class= colspan:"7", style= "text-align:center" > No Record Found </td>
					 </tr>
					</c:if>
				
				</tbody>
			</table>
			<hr>
				
				Export: <a href="excel">excel</a> <a href="pdf">pdf</a>

		</form:form>
		<h5 style="text-align:center">Copyright &copy; 2024 by Swagatika Soft ltd. </h5>
		
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
		integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
		crossorigin="anonymous"></script>

</body>
</html>