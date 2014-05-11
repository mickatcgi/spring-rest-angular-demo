'use strict';

/* Controllers */

var greetingControllers = angular.module('greetingControllers', []);

greetingControllers.controller('instrumentCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {
			$http.get('http://localhost:8080/instrument.json').success(
					function(data) {
						$scope.instrument = data;
					});
		} ]);

greetingControllers.controller('workItemCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {
			$http.get('http://localhost:8080/workItem.json').success(
					function(data) {
						$scope.workItem = data;
					});
		} ]);

greetingControllers.controller('customerCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {
			$http.get('http://localhost:8080/customer.json').success(
					function(data) {
						$scope.customer = data;
					});
		} ]);
