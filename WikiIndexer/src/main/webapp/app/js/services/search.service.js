angular.module('hello')
    .factory('searchService', ['$http', function ($http) {
        return {
            getByTitle: getByTitle
        };

        function getByTitle(title) {
            var requestUrl = 'http://localhost:8080/document?title=' + title;
            return $http.get(requestUrl).then(function (data) {
                return data.data;
            });
        }
    }]);
