'use strict';
// definieren eines Moduls
var loginModule = angular.module("loginModule", []);
 
// hinzufügen eines Controllers zum Modul
loginModule.controller("LoginController", function ($scope, $http) {
   $scope.user = {};
   
   $scope.loginUser = function() {
   
   $http({
	      method: 'POST',
	      url: 'http://localhost:8080/webapp.example/action/login',
	      headers: {'Content-Type': 'application/json'},
	      data:  $scope.user
	    }).success(function (data) 
	      {
	    	$scope.message=data;
	      });
   };
});
