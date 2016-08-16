angular.module('hello')
    .controller('homeController', function($scope, $http) {
        $http.get('http://localhost:8080/file').success(function(data) {
            $scope.info = data;
        })
    });