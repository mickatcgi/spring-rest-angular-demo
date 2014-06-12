'use strict';

/*******************************************************************************
 * Controllers - configure interaction with back-end
 ******************************************************************************/

var trade360Controllers = angular.module('trade360Controllers', []);

//var base_url = 'http://mint1-laptop:8090/';
//var users_url = base_url + "users";

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
trade360Controllers.controller('UserController',
    ['$scope', '$routeParams', 'UserFactory', '$location', '$route',
        function ($scope, $routeParams, UserFactory, $location, $route) {

            // Lists all the users. Method invoked on page load from data-ng-init call
            $scope.listUsers = function () {
                console.log("MICK - listUsers() getting list of users");
                $scope.users = UserFactory.query();
            };

            // Launches the show-user page to display full user details
            $scope.showUser = function (userId) {
                console.log("MICK - showUser() showing user with id = " + userId);
                $location.path('/user-show/' + userId);
            };

            // Launches the edit page in preparation for updating an existing
            // users details.
            $scope.editUser = function (userId) {
                console.log("MICK - editUser() editing user with id = " + userId);
                $location.path('/user-edit/' + userId);
            };

            // Performs the update operation on an existing user
            $scope.updateUser = function (userId) {
                UserFactory.update({ id: userId}, $scope.user).$promise.then(function (result) {
                    console.log("MICK updateUser promise returned = " + JSON.stringify(result));
                    $location.path('/user-list');
                });
            };

            // Launches the user-create page in preparation for entering new
            // user details.
            $scope.newUser = function () {
                $location.path('/user-create');
            };

            // Performs the create operation a new user after entering all new user details
            $scope.createNewUser = function () {
                UserFactory.create($scope.user).$promise.then(function (result) {
                    console.log("MICK createUser promise returned = " + JSON.stringify(result));
                    $location.path('/user-list');
                });
            }

            // Delete a user and return to the user-list or redisplay the user-list
            // if already on that page.
            $scope.deleteUser = function (userId) {
                UserFactory.delete({ id: userId }).$promise.then(function (result) {
                    console.log("MICK delete promise returned = " + JSON.stringify(result));

                    // We really only need to do a reload if we're on the user-list
                    // page since it doesn't reload automatically so after a delete
                    // the list never gets refreshed. Deletes from other pages
                    // work ok because they trigger a user-list reload by default
                    if ($location.path() == '/user-list') {
                        $route.reload();
                    }

                    $location.path('/user-list');
                });
            };

            // General get function used by pages that GET a single user, e.g.
            // edit-user and show-user pages
            $scope.getUser = function () {
                console.log("MICK - getUser() getting one user. id = " + $routeParams.id);
                $scope.user = UserFactory.show({ id: $routeParams.id});
            };

            // Cancels an edit or a show action
            $scope.cancel = function () {
                $location.path('/user-list');
            };

        }]);

