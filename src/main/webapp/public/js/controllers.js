'use strict';

/*******************************************************************************
 * Controllers - configure interaction with back-end
 ******************************************************************************/

var micksDemoControllers = angular.module('micksDemoControllers', []);


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
micksDemoControllers.controller('UserController',
    ['$scope', '$routeParams', 'UserFactory', '$location', '$route', '$timeout',
        function ($scope, $routeParams, UserFactory, $location, $route, $timeout) {

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
                UserFactory.update({ id: userId}, $scope.user).$promise.then(
                    function (result) {
                        // Success - return to user list page
                        console.log("MICK updateUser promise success = "
                            + JSON.stringify(result));
                        $location.path('/user-list');
                    },
                    function (reason) {
                        // Failure - stay on the same screen and display error message
                        console.log("MICK updateUser promise failed = "
                            + JSON.stringify(getErrorDetails(reason)));
                        $scope.errorMessage = getErrorDetails(reason);
                        $timeout(function() {
                            // Wrap in timeout function to avoid $digest error
                            //alert(getErrorDetails(reason));
                       }, 0, false);
                    });
            };

            // Launches the user-create page in preparation for entering new
            // user details.
            $scope.newUser = function () {
                $location.path('/user-create');
            };

            // Performs the create operation a new user after entering all new user details
            $scope.createNewUser = function () {
                UserFactory.create($scope.user).$promise.then(
                    function (result) {
                        // Success
                        console.log("MICK createUser promise returned = " + JSON.stringify(result));
                    },
                    function (reason) {
                        // Failure
                        console.log("MICK createUser promise failed = "
                            + JSON.stringify(reason));
                        alert(getErrorDetails(reason));
                    });
                $location.path('/user-list');
            }

            // Delete a user and return to the user-list or redisplay the user-list
            // if already on that page.
            $scope.deleteUser = function (userId) {
                UserFactory.delete({ id: userId }).$promise.then(
                    function (result) {
                        // Success
                        console.log("MICK delete promise returned = " + JSON.stringify(result));
                    },
                    function (reason) {
                        // Failure
                        console.log("MICK deleteUser promise failed = "
                            + JSON.stringify(reason));
                        alert(getErrorDetails(reason));
                    });

                // We really only need to do a reload if we're on the user-list
                // page since it doesn't reload automatically so after a delete
                // the list never gets refreshed. Deletes from other pages
                // work ok because they trigger a user-list reload by default
                if ($location.path() == '/user-list') {
                    $route.reload();
                }

                $location.path('/user-list');
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

            // Take the reason code and return a useful error message
            var getErrorDetails = function (reason) {
                var msg = "Action failed with error: " + reason.data.errorMessage;
                msg += " : response status = " + reason.status;
                return msg;
            }

        }]);

