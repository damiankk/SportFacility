app.controller('EventCtrl', ['$scope', '$http', '$rootScope',
    function ($scope, $http, $rootScope) {

        $scope.moreInfo = null;
        $scope.events = {};
        $scope.url = '/images/news/1.png';

        $http({
            method: 'GET',
            url: '/event/all',
            headers: {'Content-Type': 'application/json'}
        }).then(function successCallback(response) {
            $scope.events = response.data;

        }, function errorCallback(response) {
        });

        $scope.registerEvent = function () {
            var freeTicket = $scope.first + $scope.second + $scope.third + $scope.fourth;

            $http({
                method: 'POST',
                url: '/event/register',
                data: {
                    "title": $scope.name,
                    "date": new Date($scope.date),
                    "description": $scope.description,
                    "freeTicket": freeTicket,
                    "url": "/images/news/" + $scope.url,
                    "eventType": {"name": $scope.type},
                    "ticket": {
                        "firstClass": $scope.first,
                        "secondClass": $scope.second,
                        "thirdClass": $scope.third,
                        "fourthClass": $scope.fourth,
                        "price": $scope.price
                    }

                },
                headers: {'Content-type': 'application/json'}
            }).then(function successCallback(response) {
                // $location.path("/after_register");
            }, function errorCallback(response) {
            });
        };

        $scope.delete = function (event) {
            console.log(event);
            $http({
                method: 'DELETE',
                url: '/event/delete',
                data: event,
                headers: {'Content-type': 'application/json'}
            }).then(function successCallback(response) {
            }, function errorCallback(response) {
            });
        };

        $scope.copyEvent = function (event) {
            console.log('tutaj');
            $rootScope.event = angular.copy(event);
            $rootScope.name = event.title;
            $rootScope.freeTicket = event.freeTicket;
            $rootScope.date = event.date;
            $rootScope.first = event.ticket.firstClass;
            $rootScope.second = event.ticket.secondClass;
            $rootScope.third = event.ticket.thirdClass;
            $rootScope.fourth = event.ticket.fourthClass;
        };

        $scope.reservation = function () {
            $rootScope.priceSum = $scope.pieces * $scope.sector * $rootScope.event.ticket.price;

            $http({
                method: 'POST',
                url: '/reservation/add',
                data: {
                    "idAccount": $rootScope.idUser,
                    "name": $rootScope.event.title,
                    "idEvent": $rootScope.event.id,
                    "numberClass": $scope.sector,
                    "pieces": $scope.pieces,
                    "price":$rootScope.priceSum,
                    "sector":$scope.sector
                },
                headers: {'Content-type': 'application/json'}
            }).then(function successCallback(response) {
                // $location.path("/after_register");
            }, function errorCallback(response) {
            });
        };


        $scope.moreDescription = function (event) {
            if ($scope.moreInfo == null) {
                $scope.moreInfo = event.id;
            } else {
                $scope.moreInfo = null;
            }
        };
    }]);
