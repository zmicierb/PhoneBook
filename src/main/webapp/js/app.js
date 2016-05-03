define([
    'angular',
    'angular-route',
    'angular-bootstrap',
    'angular-confirm-modal',
    './controllers/index',
    './directives/index',
    './filters/index',
    './services/index'
], function (angular) {
    'use strict';

    return angular.module("app", [
        'app.controllers',
        'app.directives',
        'app.filters',
        'app.services',
        'ngRoute',
        'ui.bootstrap',
        'angular-confirm'
    ]);
});