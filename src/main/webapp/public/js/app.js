'use strict';

/* App Module - configure links to views and links to controllers */

var trade360app = angular.module('micksDemoApp', [ 'ngRoute',
		'micksDemoControllers', 'micksDemoServices' ]);

trade360app.config([ '$routeProvider',

/****************************************************************************
 * Routes to tie views to controllers
 * Controller names match name in controllers.js
 ****************************************************************************/
function($routeProvider) {
    $routeProvider.when('/user-list', {
        templateUrl: 'partials/user-list.html',
        controller: 'UserController'
    }).when('/user-create', {
        templateUrl: 'partials/user-create.html',
        controller: 'UserController'
    }).when('/user-edit/:id', {
        templateUrl: 'partials/user-edit.html',
        controller: 'UserController'
    }).when('/user-show/:id', {
        templateUrl: 'partials/user-show.html',
        controller: 'UserController'
    }).otherwise({
		/*
		 * Any href/link that doesn't match the above list, e.g. /bogus will end
		 * up in here and be redirected to the home page.
		 */
		redirectTo : '/index'
	});
} ]);


