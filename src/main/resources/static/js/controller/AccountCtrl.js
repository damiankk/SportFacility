
app.controller('AccountCtrl', ['$scope', '$http','$rootScope', function ($scope, $http,$rootScope) {

    $scope.accounts = {};

    $http({
        method: 'GET',
        url: '/users/all',
        headers: {'Content-Type': 'application/json'}
    }).then(function successCallback(response) {
        $scope.accounts = response.data;

    }, function errorCallback(response) {
    });

    $scope.delete = function (account) {

        $http({
            method: 'DELETE',
            url: '/users/delete',
            data: account,
            headers: {'Content-Type': 'application/json'}
        }).then(function successCallback(response) {
            $scope.accounts = response.data;
        }, function errorCallback(response) {
        });
    };

    $scope.changeRole = function (account,roleUser) {

        account.role = roleUser;

        $http({
            method: 'POST',
            url: '/users/changeRole',
            data: account,
            headers: {'Content-Type': 'application/json'}
        }).then(function successCallback(response) {
            $scope.accounts = response.data;
        }, function errorCallback(response) {
        });
    }

    }]);
