'use strict';
// definieren eines Moduls
var loginModule = angular.module("loginModule", []);
 
// hinzufügen eines Controllers zum Modul
loginModule.controller("LoginController", function ($scope, $http) {
   $scope.user = {};
   
   $scope.createUser = function() {
   
   $http({
	      method: 'POST',
	      url: 'http://localhost:8080/webapp.example/action/user',
	      headers: {'Content-Type': 'application/json'},
	      data:  $scope.user
	    }).success(function (data) 
	      {
	    	$scope.message=data;
	      });
   };
});






//function UserController1($scope, $http)
//{
//  $scope.user = {};
// 
//  $scope.createUser = function() 
//  {
//    $http({
//      method: 'POST',
//      url: 'http://localhost:8080/webapp.example/action/user',
//      headers: {'Content-Type': 'application/json'},
//      data:  $scope.user
//    }).success(function (data) 
//      {
//    	$scope.status=data;
//      });
//    
//  };
//}