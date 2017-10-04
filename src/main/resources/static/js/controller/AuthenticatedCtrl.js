app.controller('AuthenticatedCtrl', ['$rootScope', '$http', '$location', '$route', '$scope','$timeout','AuthenticatedService',
    function ($rootScope, $http, $location, $route, $scope,$timeout, AuthenticatedService) {

        var self = this;
        this.credentials = {};
        $rootScope.username = '';
        $rootScope.password = '';
        $scope.register = {};
        $scope.showInfo = false;
        $scope.load = true;

        $timeout(function () {
            $scope.showInfo = true;
            $scope.load = false;
        }, 1500);


        self.tab = function (route) {
            return $route.current && route === $route.current.controller;
        };

        $scope.authenticated = function (register, callback) {
            AuthenticatedService.authenticatedUser($scope.register, callback);
        };

        self.login = function () {

            authenticated(self.credentials, function (authenticated) {
                if (authenticated) {
                    $location.path('/home');
                    self.error = false;
                    $rootScope.authenticated = true;

                } else {
                    $scope.errorForm = "Błędne dane!";
                    $location.path("/login");
                    self.error = true;
                    $rootScope.authenticated = false;
                }
            })
        };


        $scope.logout = function () {

           $http.post('/logout', {})
               .then(function successCallback(response) {
                   $location.path('/login');
                   $rootScope.authenticated = false;
                   $rootScope.admin = false;
               }, function errorCallback(response) {
                   $location.path('/login');
                   $rootScope.authenticated = false;
                   $rootScope.admin = false;
               });

        }

    }]);


