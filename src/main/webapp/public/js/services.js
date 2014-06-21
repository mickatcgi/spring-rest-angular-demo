'use strict';

/*******************************************************************************
 * Factories - configure interaction with back-end
 ******************************************************************************/

var micksDemoServices = angular.module('micksDemoServices', [ 'ngResource' ]);

/*******************************************************************************
 * Factory - maps to user controller on back-end
 ******************************************************************************/

micksDemoServices.factory('UserFactory', function ($resource) {
    return $resource('/users/:id/:action',
        {
            id: "@id"
        },
        {
            show: { method: 'GET', params: {id: '@id'}, isArray: false },
            update: { method: 'PUT', params: {id: '@id', action: 'update'} },
            delete: { method: 'DELETE', params: {id: '@id', action: 'delete'} },
            query: { method: 'GET', isArray: true },
            create: { method: 'POST', params: {action: 'create'}}
        })
});

/*******************************************************************************
 * Factory - maps to role controller on back-end
 ******************************************************************************/

micksDemoServices.factory('RoleFactory', function ($resource) {
    return $resource('/roles',
        {},
        {
            query: { method: 'GET', isArray: true }
        })
});