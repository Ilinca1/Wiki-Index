angular.module('hello')
    .controller('searchController', ['$scope', 'searchService', function ($scope, searchService) {
        $scope.myVar = false;
        $scope.photo = true;
        $scope.searchTitle = function (title) {
            searchService.getByTitle(title).then(function (data) {
                $scope.data = data;
                $scope.labels = [];
                $scope.value = [];
                $scope.myVar = true;
                $scope.photo = false;
                for(i = 0; i < data.wordsList.length ; i++){
                    $scope.labels.push(data.wordsList[i].word);
                    $scope.value.push(data.wordsList[i].occurrences);
                }
            });
        }
    }]);