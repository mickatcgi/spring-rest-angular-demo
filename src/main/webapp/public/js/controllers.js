'use strict';

/*******************************************************************************
 * Controllers - configure interaction with back-end
 ******************************************************************************/

var trade360Controllers = angular.module('trade360Controllers', []);

var base_url = 'http://mint1-laptop:8090/';
var instr_url = base_url + "instrument.json";
var wi_url = base_url + "workItem.json";
var cust_url = base_url + "customer.json";

/****************************************************************************/

trade360Controllers.controller('instrumentCtrl', [ '$scope', '$http',
		function($scope, $http) {
			$http.get(instr_url).success(function(data) {
				$scope.instrument = data;
			});
		} ]);

/****************************************************************************/

trade360Controllers.controller(
		'customerCtrl', 
		[ '$scope', '$http', 'CustomerFactory',
		
	        function($scope, $http, CustomerFactory) {
				$http.get(instr_url).success(function(data) {
					$scope.instrument = data;
				});
	
				$scope.customers = CustomerFactory.getCustomers();
	        
				$scope.addCustomer = function() {
				    $scope.customers.push({
				    	name:$scope.newCustomer.name, 
				    	city:$scope.newCustomer.city});
				}
			
				$http.get(instr_url).success(function(data) {
					$scope.dbCustomer = data;
				});

		    }
		]
);

/****************************************************************************/

trade360Controllers.controller('workItemCtrl', [ '$scope', '$http',
		function($scope, $http) {
			$http.get(wi_url).success(function(data) {
				$scope.workItem = data;
			});
		} ]);

/****************************************************************************/

trade360Controllers.factory('CustomerFactory', function() {
	
	var factory = {};
	var customers = [
	          	   {name:'Billy Bob', city:'Phoenix'}, 
	        	   {name:'Jim Bob', city:'Preston'}, 
	        	   {name:'Bobby Sue', city:'Manchester'}, 
	        	   {name:'Zubediah Bilbo', city:'London'}
	        	];
	
	factory.getCustomers = function() {
		return customers;
	};
	
	return factory;
});

/****************************************************************************/

trade360Controllers.service('InstrumentService', function() {
	
	var instruments = [
	          	   {name:'Guitar', description:'Lots of strings'}, 
	        	   {name:'Flute', description: 'Hollow log'}, 
	        	   {name:'Drums', description:'Really noisy'}, 
	        	   {name:'Piano', description:'Lots of keys'}
	        	];
	
	this.getInstruments = function() {
		return instruments;
	};
});

