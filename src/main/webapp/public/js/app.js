'use strict';

/* App Module  - configure links to views and links to controllers*/

var trade360app = angular.module('trade360app', [
  'ngRoute',
  'trade360Controllers'
]);

trade360app.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/instrumentController', {	/* matches href name in index.html */
        templateUrl: 'partials/instrument.html',
        controller: 'instrumentCtrl' 	/* matches name in controllers.js */
      }).
      when('/workItemController', { 	/* matches href name in index.html */
          templateUrl: 'partials/workItem.html',
          controller: 'workItemCtrl'	/* matches name in controllers.js */
        }).
        when('/customerController', { 	/* matches href name in index.html */
            templateUrl: 'partials/customer.html',
            controller: 'customerCtrl'	/* matches name in controllers.js */
          }).
      otherwise({
    	/* Any href/link that doesn't match the above list, e.g. /bogus will
    	 * end up in here. 
    	 * */
        redirectTo: '/index'
      });
  }]);
