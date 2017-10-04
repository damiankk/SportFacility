
app.controller('UserCtrl', ['$scope', '$http','$rootScope', function ($scope, $http, $rootScope) {

    $scope.reservations = {};

        $http({
            method: 'POST',
            url: '/reservation/all',
            data:{
                "idAccount":$rootScope.idUser
            },
            headers: {'Content-Type': 'application/json'}
        }).then(function successCallback(response) {
            $scope.reservations = response.data;
            console.log($scope.reservations);
        }, function errorCallback(response) {
        });

    }]);
