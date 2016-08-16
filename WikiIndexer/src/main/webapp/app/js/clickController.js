var app = angular.module('hello')

app.directive( 'goClick', function ( $location ) {
    return function ( scope, element, attrs ) {
        var path;

        attrs.$observe( 'goClick', function (val) {
            path = val;
        });

        element.bind( 'click', function () {
            scope.$apply( function () {
                $location.path( path );
            });
        });
    };
});

app.controller('clickController', function($scope, $location) {
    $scope.$watch( function () { return $location.path(); }, function (path) {
        $scope.path = path;
    });
});
