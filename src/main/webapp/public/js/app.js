'use strict';

/* App Module */

var greetingApp = angular.module('greetingApp', [
  'ngRoute',
  'greetingControllers'
]);

greetingApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/greeting', {
        templateUrl: 'partials/greeting.html',
        controller: 'GreetingCtrl'
      }).
      when('/workItemController', {
          templateUrl: 'partials/workItem.html',
          controller: 'workItemCtrl'
        }).
        when('/controller2', {
            templateUrl: 'partials/controller2.html',
            controller: 'Controller2Ctrl'
          }).
      otherwise({
    	/* Any href/link that doesn't match the above list, e.g. /home will
    	 * end up in here. 
    	 * */
        redirectTo: '/index'
      });
  }]);
