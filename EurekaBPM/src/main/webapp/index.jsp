<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.9/angular.min.js"></script>

<script type="text/javascript">
	var app = angular.module('MyApp', [])
	app.controller('MyController', function($scope , $http) {
		$scope.ButtonClick = function() {
			 $http.get("http://localhost:9080/Eureka/userManagement.jsp")
			 	.success(function(respuesta){
		            //console.log("res:", respuesta);
				 //document.getElementById("contenedor").innerHTML = respuesta;
				 $scope.content = respuesta;
		        });
			
			
		}
	});
</script>

</head>
<body ng-app="MyApp" ng-controller="MyController">
	<input type="button" ng-click="ButtonClick()" value="Lista" />
	<input type="button" ng-click="ButtonClick()" value="Formulario" />


	<div id="contenedor" ng-bind="Message"></div>

</body>
</html>