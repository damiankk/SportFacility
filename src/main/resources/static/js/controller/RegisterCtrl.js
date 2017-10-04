
app.controller('RegisterCtrl', function ($scope, $http, $location) {


    $scope.registerResponse = {};

    $scope.error = [];
    $scope.showError = [];
    $scope.reponseError = false;
    $scope.userAlreadyExists = false;
    $scope.numberAlreadyExists = false;
    $scope.wrongPass = false;
    $scope.numberStart0 = false;

    $scope.registerUser = function () {

        $http({
            method: 'POST',
            url: '/users/register',
            data: {
                "username": $scope.register.username,
                "password": $scope.register.password,
                "confirmPassword": $scope.register.password_confirmation,
                "name": $scope.register.name,
                "surname": $scope.register.surname,
                "email": $scope.register.email,
                "address": $scope.register.address
            },
            headers: {'Content-type': 'application/json'}
        }).then(function successCallback(response) {
            // $location.path("/after_register");
        }, function errorCallback(response) {
        });
    }
});
