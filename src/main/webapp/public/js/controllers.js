'use strict';

/*******************************************************************************
 * Controllers - configure interaction with back-end
 ******************************************************************************/

var trade360Controllers = angular.module('trade360Controllers', []);

var base_url = 'http://mint1-laptop:8090/';
var instr_url = base_url + "instrument.json";
var wi_url = base_url + "workItem.json";
var cust_url = base_url + "customer.json";
var cust_addr_url = base_url + "customerAddress.json";
var users_url = base_url + "users.json";

/****************************************************************************/

trade360Controllers.controller(
    'instrumentCtrl',
    [ '$scope', '$http', 'InstrumentService',

        function ($scope, $http, InstrumentService) {
            $http.get(instr_url).success(function (data) {
                $scope.instrument = data;
            });

            $scope.musicalInstruments = InstrumentService.getInstruments();

        } ]
);

/****************************************************************************/

trade360Controllers.controller(
    'customerCtrl',
    [ '$scope', '$http', 'CustomerFactory', 'RestCustomerFactory',
        'RestCustomerAddressFactory',

        function ($scope, $http, CustomerFactory, RestCustomerFactory, RestCustomerAddressFactory) {

            /* Gets customers from factory with local data */
            $scope.customers = CustomerFactory.getCustomers();

            /* Add a customer locally to the local customer list */
            $scope.addCustomer = function () {
                $scope.customers.push({
                    name: $scope.newCustomer.name,
                    city: $scope.newCustomer.city});
            }

            /* Gets customers from factory with remote REST call */
            RestCustomerFactory.getCustomer(function (data) {
                $scope.dbCustomer = data;
                console.log('MICK - RestCustomerFactory async returned value ='
                    + JSON.stringify(data));
            });

            /* Gets customer address from factory with remote REST call */
            RestCustomerAddressFactory.getCustomerAddress(function (data) {
                $scope.dbCustomerAddress = data;
                console.log('MICK - RestCustomerAddressFactory async returned value ='
                    + JSON.stringify(data));
            });

        }
    ]
);

/****************************************************************************/

trade360Controllers.controller('workItemCtrl', [ '$scope', '$http',
    function ($scope, $http) {
        $http.get(wi_url).success(function (data) {
            $scope.workItem = data;
        });
    } ]);

/****************************************************************************/

trade360Controllers.factory('CustomerFactory', function () {

    var factory = {};
    var customers = [
        {name: 'Billy Bob', city: 'Phoenix'},
        {name: 'Jim Bob', city: 'Preston'},
        {name: 'Bobby Sue', city: 'Manchester'},
        {name: 'Zubediah Bilbo', city: 'London'}
    ];

    factory.getCustomers = function () {
        return customers;
    };

    return factory;
});

/****************************************************************************/

trade360Controllers.factory(
    'RestCustomerFactory',
    ['$http',

        function ($http) {
            return {
                getCustomer: function (callback) {
                    $http.get(cust_url).success(callback);
                }
            }
        }
    ]
);

/****************************************************************************/

trade360Controllers.factory(
    'RestCustomerAddressFactory',
    ['$http',

        function ($http) {
            return {
                getCustomerAddress: function (callback) {
                    $http.get(cust_addr_url).success(callback);
                }
            }
        }
    ]
);

/****************************************************************************/

trade360Controllers.service('InstrumentService', function () {

    var instruments = [
        {name: 'Guitar', description: 'Lots of strings'},
        {name: 'Flute', description: 'Hollow log'},
        {name: 'Drums', description: 'Really noisy'},
        {name: 'Piano', description: 'Lots of keys'}
    ];

    this.getInstruments = function () {
        return instruments;
    };
});

/****************************************************************************/

/***************************************************************************/

trade360Controllers.controller('UserListCtrl',
    ['$scope', 'UsersFactory', 'UserFactory', '$location',
    function ($scope, UsersFactory, UserFactory, $location) {

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

        $scope.users = UsersFactory.query();
    }]);

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

trade360Controllers.controller('UserCreationCtrl',
    ['$scope', 'UsersFactory', '$location',
    function ($scope, UsersFactory, $location) {

        // callback for ng-click 'createNewUser':
        $scope.createNewUser = function () {
            UsersFactory.create($scope.user);
            $location.path('/user-list');
        }
    }]);