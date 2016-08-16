angular.module('hello')
    .controller('searchController', ['$scope', 'searchService', function ($scope, searchService) {
        $scope.searchTitle = function (title) {
            searchService.getByTitle(title).then(function (data) {
                $scope.data = data;
                $scope.labels = [];
                $scope.value = [];
                for(i = 0; i < data.wordsList.length ; i++){
                    $scope.labels.push(data.wordsList[i].word);
                    $scope.value.push(data.wordsList[i].occurrences);
                }
                $scope.series = ['Words', 'Occurrences'];

            });
        }
    }]);