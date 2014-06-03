'use strict';

/*******************************************************************************
 * Controllers - configure interaction with back-end
 ******************************************************************************/

var trade360Services = angular.module('trade360Services', [ 'ngResource' ]);

trade360Services.factory('User', [ '$resource', function ($resource) {
    return $resource(
        '/users/:id/:action',
        {
            id: "@id",
            action: "@action"
        },
        {
            "get": {method: "GET", isArray: true},
            "update": {method: "PUT", params: {action: "update"}, isArray: false},
            "create": {method: "POST", params: {action: "create"}},
            'delete': {method: 'DELETE', params: {action: "delete"}}
        }
    );
} ]);

/*******************************************************************************
 * Controllers - configure interaction with back-end
 ******************************************************************************/

trade360Services.factory('UsersFactory', function ($resource) {
    return $resource('/users/:action', {}, {
        query: { method: 'GET', isArray: true },
        create: { method: 'POST', params: {action: 'create'}}
    })
});

/*******************************************************************************
 * Controllers - configure interaction with back-end
 ******************************************************************************/

trade360Services.factory('UserFactory', function ($resource) {
    return $resource('/users/:id/:action',
        {
            id: "@id"
        },
        {
            show: { method: 'GET' },
            update: { method: 'PUT', params: {id: '@id', action: 'update'} },
            delete: { method: 'DELETE', params: {id: '@id', action: 'delete'} }
        })
});