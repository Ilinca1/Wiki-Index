angular.module('hello')
    .controller('fileController', ['$scope', '$http', function ($scope, $http) {
        $scope.photo = true;
        $scope.uploadFile = function () {
            var file = $scope.myFile;
            var uploadUrl = "http://localhost:8080/file";
            var fd = new FormData();
            fd.append('file', file);

            $http.post(uploadUrl, fd, {
                transformRequest: angular.identity,
                headers: {'Content-Type': undefined}
            })

                .success(function (data, status, header, config) {
                    $scope.data = data;
                    $scope.labels = [];
                    $scope.value = [];
                    $scope.photo = false;
                    for(var item in data){
                        $scope.labels.push(item);
                        $scope.value.push(data[item]);
                        
                    }
                })

                .error(function (data, status, header, config) {
                    $scope.ResponseDetails = "Data: " + data +
                        "<hr />status: " + status +
                        "<hr />headers: " + header +
                        "<hr />config: " + config;
                });
        }
    }])


    .directive('fileModel', ['$parse', function ($parse) {
        return {
            restrict: 'A',
            link: function (scope, element, attrs) {
                var model = $parse(attrs.fileModel);
                var modelSetter = model.assign;

                element.bind('change', function () {
                    scope.$apply(function () {
                        modelSetter(scope, element[0].files[0]);
                    });
                });
            }
        };
    }]);
