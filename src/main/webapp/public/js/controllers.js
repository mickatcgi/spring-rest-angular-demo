'use strict';

/*******************************************************************************
 * Controllers - configure interaction with back-end
 ******************************************************************************/

var trade360Controllers = angular.module('trade360Controllers', []);

var base_url = 'http://mint1-laptop:8090/';
var users_url = base_url + "users";

/****************************************************************************
 * Controller - uses alternating sequences of REST calls and page loads to
 * retrieve the right model objects and and show the right pages:
 *
 *  - editUser      --> getUser         --> updateUser  --> listUsers
 *  - newUser       --> createNewUser   --> listUsers
 *  - showUser      --> getUser
 *  - deleteUser    --> listUsers
 *  - cancel        --> listUsers
 *
 ***************************************************************************/
trade360Controllers.controller('UserListCtrl',
    ['$scope', '$routeParams', 'UserFactory', '$location',
        function ($scope, $routeParams, UserFactory, $location) {

            // callback for ng-click 'editUser' - launch user-edit page
            $scope.editUser = function (userId) {
                console.log("MICK - editUser() editing user with id = " + userId);
                $location.path('/user-edit/' + userId);
            };

            // callback for ng-click 'updateUser':
            $scope.updateUser = function (userId) {
                UserFactory.update({ id: userId}, $scope.user).$promise.then(function(result) {
                    console.log("MICK updateUser promise returned = " + JSON.stringify(result));
                    $location.path('/user-list');
                });
            };

            // callback for ng-click 'showUser' - launch user-show page
            $scope.showUser = function (userId) {
                console.log("MICK - showUser() showing user with id = " + userId);
                $location.path('/user-show/' + userId);
            };

            // callback for ng-click 'newUser' - launch user-create page
            $scope.newUser = function () {
                $location.path('/user-create');
            };

            // callback for ng-click 'createNewUser':
            $scope.createNewUser = function () {
                UserFactory.create($scope.user).$promise.then(function(result) {
                    console.log("MICK createUser promise returned = " + JSON.stringify(result));
                    $location.path('/user-list');
                });
            }

            // callback for ng-click 'deleteUser' - delete and redisplay list
            $scope.deleteUser = function (userId) {
                UserFactory.delete({ id: userId }).$promise.then(function(result) {
                    console.log("MICK delete promise returned = " + JSON.stringify(result));
                    $location.path('/user-list');
                });
            };

            // callback for auto-load 'listUsers' - display list
            // Method invoked on page load from data-ng-init call
            $scope.listUsers = function () {
                console.log("MICK - listUsers() getting list of users");
                $scope.users = UserFactory.query();
            };

            // General get function used by pages that GET a single user
            $scope.getUser = function () {
                console.log("MICK - getUser() getting one user. id = " + $routeParams.id);
                $scope.user = UserFactory.show({ id: $routeParams.id});
            };

            // callback for ng-click 'cancel':
            $scope.cancel = function () {
                $location.path('/user-list');
            };

        }]);

