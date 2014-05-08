'use strict';

/* Controllers */

var greetingControllers = angular.module('greetingControllers', []);

greetingControllers.controller('GreetingCtrl', ['$scope', '$http',
  function($scope, $http) {
    $http.get('http://localhost:8080/greeting.json').success(function(data) {
      $scope.greeting = data;
    });
  }
]);

