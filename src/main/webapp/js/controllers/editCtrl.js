define(['./module'], function (controllers) {
    'use strict';
    controllers.controller('EditUserController', function ($scope, $http, $location, UserService) {
        $scope.user = UserService.get();
        $scope.saveUser = function (user) {
            $http.put("api/user/", user, {headers: {'Content-Type': 'application/json'}}).success(function (response) {
                $location.path("/viewUsers");
            });
        }
    });
});