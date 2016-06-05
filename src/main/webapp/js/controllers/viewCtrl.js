define(['./module'], function (controllers) {
    'use strict';
    controllers.controller('UsersController', function ($scope, $http, $location, $uibModal, UserService) {
        $http.get("api/user/V2").success(function (response) {
            $scope.users = response;
        });
        $scope.editUser = function (user) {
            UserService.set(user);
            $location.path("/editUser");
        };
        $scope.deleteUser = function (user, index) {

            $uibModal.open({
                animation: false,
                templateUrl: 'views/modals/delete_confirm_form.html',
                controller: function ($scope, $uibModalInstance) {
                    $scope.header = 'Удаление пользователя';

                    $scope.confirmText = "Вы уверены, что хотите удалить пользователя " + user.name;

                    $scope.ok = function () {
                        $http.put("api/user/delete", user).success(function (response) {
                            $uibModalInstance.dismiss('cancel');
                            spliceTbl(index);
                        });
                    };
                    $scope.cancel = function () {
                        $uibModalInstance.dismiss('cancel');

                    };
                }
            });
        };

        function spliceTbl(indexId) {
            $scope.users.splice(indexId, 1);
        }
    });
});