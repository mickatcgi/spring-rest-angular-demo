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
		} ]);

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

/*******************************************************************************
 * Button Controller
 ******************************************************************************/

angular.module('myModule', [ 'ui.bootstrap' ]);

var ButtonsCtrl = function($scope) {

	$scope.singleModel = 1;

	$scope.radioModel = 'Middle';

	$scope.checkModel = {
		left : false,
		middle : true,
		right : false
	};
};

/*******************************************************************************
 * Alert Controller
 ******************************************************************************/
function AlertDemoCtrl($scope) {
	$scope.alerts = [ {
		type : 'danger',
		msg : 'Alert Danger'
	}, {
		type : 'success',
		msg : 'Alert Success'
	} ];

	$scope.addAlert = function() {
		$scope.alerts.push({
			msg : 'Another alert!'
		});
	};

	$scope.closeAlert = function(index) {
		$scope.alerts.splice(index, 1);
	};

}