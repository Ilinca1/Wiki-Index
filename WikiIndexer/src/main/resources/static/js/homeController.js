function Home($scope, $http) {
    $http.get('http://localhost:8080/file').
    success(function(data) {
        $scope.greeting = data;
    });
}