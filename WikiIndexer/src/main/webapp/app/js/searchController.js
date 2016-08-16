angular.module('hello')
    .controller('searchController', ['$scope', 'searchService', function ($scope, searchService) {
        $scope.searchTitle = function (title) {
            searchService.getByTitle(title).then(function (data) {
                $scope.data = data;
                $scope.series = ['Words', 'Occurrences'];
            });
        }
    }]);