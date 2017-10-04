app.service('AuthenticatedService', function ($rootScope, $http,$location) {

    var self = this;

    function serializeData(credentials) {
        return $.param({
            "username": credentials.username,
            "password": credentials.password
        });
    }
    self.test = function () {
        self.authenticatedUser();
    };

    self.authenticatedUser = function (credentials, callback) {
        var headers = {
            'Content-Type': 'application/x-www-form-urlencoded'
        };

        var data = serializeData(credentials);

        $http.post('/perform_login', data, {
            headers: headers
        }).then(function (response) {
            var data = response.data;
            $location.path('/');
            $rootScope.authenticated = true;
            $rootScope.idUser = data.id;
            $rootScope._username = data.username;
            $rootScope.roleAdmin = angular.equals(data.role, 'ADMIN');
            $rootScope.id = data.id;

            callback && callback(true);
        }, function (err) {
            self.authenticated = false;
            callback && callback(false);
        });
    };
});

