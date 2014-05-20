'use strict';

/*******************************************************************************
 * Controllers - configure interaction with back-end
 ******************************************************************************/

var trade360Controllers = angular.module('trade360Controllers', []);

var base_url = 'http://mint1-laptop:8090/';
var instr_url = base_url + "instrument.json";
var wi_url = base_url + "workItem.json";
var cust_url = base_url + "customer.json";

trade360Controllers.controller('instrumentCtrl', [ '$scope', '$http',
		
        function($scope, $http) {
			$http.get(instr_url).success(function(data) {
				$scope.instrument = data;
			});

			$scope.customers=[
        	       	       {name:'Billy Bob', city:'Phoenix'}, 
        	    	       {name:'Jim Bob', city:'Preston'}, 
        	    	       {name:'Bobby Sue', city:'Manchester'}, 
        	    	       {name:'Zubediah Bilbo', city:'London'}
        	    	   ];
        }
]);

trade360Controllers.controller('workItemCtrl', [ '$scope', '$http',
		function($scope, $http) {
			$http.get(wi_url).success(function(data) {
				$scope.workItem = data;
			});
		} ]);

trade360Controllers.controller('customerCtrl', [ '$scope', '$http',
		function($scope, $http) {
			$http.get(cust_url).success(function(data) {
				$scope.customer = data;
			});
		} ]);


