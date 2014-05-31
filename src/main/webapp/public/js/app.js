'use strict';

/* App Module - configure links to views and links to controllers */

var trade360app = angular.module('trade360app', [ 'ngRoute',
		'trade360Controllers', 'trade360Services' ]);

trade360app.config([ '$routeProvider',

/****************************************************************************
 * Routes to tie views to controllers
 * Controller names match name in controllers.js
 ****************************************************************************/
function($routeProvider) {
	$routeProvider.when('/instrumentController', {
		templateUrl : 'partials/instrument.html',
		controller : 'instrumentCtrl'
	}).when('/workItemController', {
		templateUrl : 'partials/workItem.html',
		controller : 'workItemCtrl'
	}).when('/customerController', {
		templateUrl : 'partials/customer.html',
		controller : 'customerCtrl'
	}).when('/userController', {
		templateUrl : 'partials/user.html',
		controller : 'userCtrl'
	}).otherwise({
		/*
		 * Any href/link that doesn't match the above list, e.g. /bogus will end
		 * up in here.
		 */
		redirectTo : '/index'
	});
} ]);
