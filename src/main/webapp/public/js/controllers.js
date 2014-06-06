'use strict';

/*******************************************************************************
 * Controllers - configure interaction with back-end
 ******************************************************************************/

var trade360Controllers = angular.module('trade360Controllers', []);

var base_url = 'http://mint1-laptop:8090/';
var users_url = base_url + "users";

/****************************************************************************
 * Controller
 ***************************************************************************/
trade360Controllers.controller('UserListCtrl',
    ['$scope', 'UserFactory', '$location',
        function ($scope, UserFactory, $location) {

            // callback for ng-click 'editUser':
            $scope.editUser = function (userId) {
                $location.path('/user-edit/' + userId);
            };

            // callback for ng-click 'deleteUser':
            $scope.deleteUser = function (userId) {
                UserFactory.delete({ id: userId });
                $scope.users = UsersFactory.query();
            };

            // callback for ng-click 'showUser':
            $scope.showUser = function (userId) {
                $location.path('/user-show/' + userId);
            };

            // callback for ng-click 'createUser':
            $scope.createNewUser = function () {
                $location.path('/user-create');
            };

            $scope.users = UserFactory.query();
        }]);

/****************************************************************************
 * Controller
 ***************************************************************************/
trade360Controllers.controller('UserDetailCtrl',
    ['$scope', '$routeParams', 'UserFactory', '$location',
        function ($scope, $routeParams, UserFactory, $location) {

            // callback for ng-click 'updateUser':
            $scope.updateUser = function () {
                UserFactory.update({ id: $routeParams.id}, $scope.user);
                $location.path('/user-list');
            };

            // callback for ng-click 'cancel':
            $scope.cancel = function () {
                $location.path('/user-list');
            };

            $scope.user = UserFactory.show({ id: $routeParams.id });
        }]);

/****************************************************************************
 * Controller
 ***************************************************************************/
trade360Controllers.controller('UserCreationCtrl',
    ['$scope', 'UserFactory', '$location',
        function ($scope, UserFactory, $location) {

            // callback for ng-click 'createNewUser':
            $scope.createNewUser = function () {
                UserFactory.create($scope.user);
                $location.path('/user-list');
            }
        }]);