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
/** Hello billybob from webstorm **/
/***************************************************************************/

trade360Controllers.controller('userCtrl',
    ['$scope', 'User',

        function ($scope, User) {
            var userList = User.query({}, {});
            $scope.users = userList;
            console.log("MICK - User Controller returned = " + JSON.stringify(userList[0]));

            var user3 = User.get({}, {'id': 3});
            var user5 = User.get({}, {'id' : 5});
            console.log("MICK - User Controller returned one user3 = " + user3.id + " : " + user3.name);

            $scope.user = user3;
            user3.name = "Billybob McDoodleWhizzer";
            console.log("MICK - User Controller updating user3 = " + user3.id + " : " + user3.name);

            /* Update user3's name */
            User.update({id: 3}, user3 );    // Calls PUT /users/3/update
            User.delete({id: 5});           // Calls DELETE /users/5/delete
            //user3.$save();
            //user5.$delete();

            var user9 = new User;
            user9.id = -1;
            user9.name = "Yertle the Turtle";
            console.log("MICK - User Controller creating user9 = " + user9.id + " : " + user9.name);
            User.create(user9);
            //user9.$save();
        }
    ]
);

