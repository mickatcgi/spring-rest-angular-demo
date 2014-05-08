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
        controller: 'greetingCtrl'
      }).
      otherwise({
        redirectTo: '/index'
      });
  }]);
