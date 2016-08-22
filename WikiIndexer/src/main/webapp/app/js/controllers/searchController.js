angular.module('hello')
    .controller('searchController', ['$scope', 'searchService', function ($scope, searchService) {
        $scope.myVar = false;
        $scope.photo = true;
        $scope.showError = false;
        $scope.searchTitle = function (title) {
            searchService.getByTitle(title).then(function (data) {
                $scope.data = data;
                $scope.labels = [];
                $scope.value = [];
                $scope.myVar = true;
                $scope.photo = false;
                if (data.wordsList.length != 0) {
                    for (i = 0; i < data.wordsList.length; i++) {
                        $scope.labels.push(data.wordsList[i].word);
                        $scope.value.push(data.wordsList[i].occurrences);
                    }
                }
                else{
                    $scope.showError = true;
                    $scope.myVar = false;
                    $scope.error = "Please insert a valid title!";
                }
            });
        }
    }]);