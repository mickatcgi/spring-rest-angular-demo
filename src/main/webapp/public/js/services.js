'use strict';

/*******************************************************************************
 * Controllers - configure interaction with back-end
 ******************************************************************************/

var trade360Services = angular.module('trade360Services', [ 'ngResource' ]);

/*******************************************************************************
 * Controllers - configure interaction with back-end
 ******************************************************************************/

trade360Services.factory('UserFactory', function ($resource) {
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