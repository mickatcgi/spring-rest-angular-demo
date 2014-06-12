'use strict';

/*******************************************************************************
 * Controllers - configure interaction with back-end
 ******************************************************************************/

var micksDemoServices = angular.module('micksDemoServices', [ 'ngResource' ]);

/*******************************************************************************
 * Controllers - configure interaction with back-end
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