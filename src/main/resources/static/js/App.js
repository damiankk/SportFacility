'use strict';

var app = angular.module('myApp', [
    'ngRoute', 'ngResource','ngCookies'


]) .factory('httpInterceptor', [ '$q', '$rootScope', '$location',
    function ($q, $rootScope, $location) {
        return {
            request: function (config) {
                return config || $q.when(config)
            },
            response: function (response) {
                return response || $q.when(response);
            },
            responseError: function (rejection) {
                console.log('przenosze');
                $location.url('/test');
                if (rejection.status === 401) {
                    //here I preserve login page
                    if( $location.absUrl() == 'http://localhost:8080/#/access_denied'){
                        $location.url('/login');

                    } else if ($location.absUrl() != 'http://localhost:8080/#/access_denied' &&
                        $location.absUrl() != 'http://localhost:8080/#/access_denied') {
                        $rootScope.authenticated = false;
                        $rootScope.userRoles = false;
                        $location.url('/access_denied');
                        $rootScope.$broadcast('error');
                    }

                    return $q.reject(rejection);
                } else if (rejection.status === 403) {
                    $location.url('/access_denied');
                } else {
                    if(rejection.status >= 400) {
                        var errorCode = rejection.data.errorCode;
                        var msg = APPLICATION_ERROR_CODES[errorCode];
                        if(APPLICATION_ERROR_CODES.ACCOUNT_USERNAME_ALREADY_EXISTS == errorCode){
                            $rootScope.userAlreadyExists = true;
                            $rootScope.reponseError = true;
                        }
                        $rootScope.errorMessage = msg;
                    }
                }

                return $q.reject(rejection);
            }
        }
    }]).config(function ($routeProvider, $httpProvider) {
    $routeProvider
        .when('/news', {
                templateUrl: 'views/news.html',
                controller: ''
            })
        .when('/scheduled', {
            templateUrl: 'views/scheduled.html',
            controller: 'EventCtrl'
        })
        .when('/addEvent', {
            templateUrl: 'views/add_event.html',
            controller: 'EventCtrl'
        })
        .when('/login', {
            templateUrl: 'views/login.html',
            controller: 'AuthenticatedCtrl',
            controllerAs: ''
        })
        .when('/register', {
            templateUrl: 'views/register.html',
            controller: 'RegisterCtrl'
        })
        .when('/contact', {
            templateUrl: 'views/contact.html',
            controller: 'NoteCtrl'
        })
        .when('/account_m', {
            templateUrl: 'views/account_management.html',
            controller: 'AccountCtrl'
        })
        .when('/reservation', {
            templateUrl: 'views/reservation.html',
            controller: 'EventCtrl'
        })
        .when('/my_profile', {
            templateUrl: 'views/profile_user.html',
            controller: 'UserCtrl'
        })
        .when('/gallery', {
            templateUrl: 'views/gallery.html',
            controller: ''
        })
        .when('/test', {
            templateUrl: 'views/test.html',
            controller: ''
        })
        .when('/user_notes', {
            templateUrl: 'views/show_notes.html',
            controller: 'NoteCtrl'
        })

            .otherwise({redirectTo: '/'});
    $httpProvider.defaults.headers.post["Content-Type"] = "application/json";
    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
    $httpProvider.interceptors.push('httpInterceptor');

});
