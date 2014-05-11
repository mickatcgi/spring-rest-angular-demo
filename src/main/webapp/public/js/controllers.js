'use strict';

/* Controllers - configure interaction with back-end */

var trade360Controllers = angular.module('trade360Controllers', []);

trade360Controllers.controller('instrumentCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {
			$http.get('http://localhost:8080/instrument.json').success(
					function(data) {
						$scope.instrument = data;
					});
		} ]);

trade360Controllers.controller('workItemCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {
			$http.get('http://localhost:8080/workItem.json').success(
					function(data) {
						$scope.workItem = data;
					});
		} ]);

trade360Controllers.controller('customerCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {
			$http.get('http://localhost:8080/customer.json').success(
					function(data) {
						$scope.customer = data;
					});
		} ]);
