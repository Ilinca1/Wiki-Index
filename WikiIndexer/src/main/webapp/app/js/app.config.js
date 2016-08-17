angular.module("hello")
    .config(function ($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('document', {
                url: '/document',
                templateUrl: '../views/search.html',
                controller: 'searchController'
            })
            .state('file', {
                url: '/file',
                templateUrl: '../views/file.html',
                controller: 'fileController'
            });

        $urlRouterProvider.otherwise('/document');
    })