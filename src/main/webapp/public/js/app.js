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
      when('/controller1', {
          templateUrl: 'partials/controller1.html',
          controller: 'controller1Ctrl'
        }).
        when('/controller2', {
            templateUrl: 'partials/controller2.html',
            controller: 'controller2Ctrl'
          }).
      otherwise({
        redirectTo: '/index'
      });
  }]);
