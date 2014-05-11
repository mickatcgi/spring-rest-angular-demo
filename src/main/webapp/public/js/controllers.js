'use strict';

/* Controllers */

var greetingControllers = angular.module('greetingControllers', []);

greetingControllers.controller('GreetingCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {
			$http.get('http://localhost:8080/greeting.json').success(
					function(data) {
						$scope.greeting = data;
					});
		} ]);

greetingControllers.controller('Controller1Ctrl', [
		'$scope',
		'$http',
		function($scope, $http) {
			$http.get('http://localhost:8080/controller1.json').success(
					function(data) {
						$scope.workItem = data;
					});
		} ]);

greetingControllers.controller('Controller2Ctrl', [
		'$scope',
		'$http',
		function($scope, $http) {
			$http.get('http://localhost:8080/controller2.json').success(
					function(data) {
						$scope.controller2Data = data;
					});
		} ]);
