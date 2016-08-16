angular.module("hello")
    .config(function($stateProvider,$urlRouterProvider){
        $stateProvider
            .state('home',{
                 url:'/home',
                 templateUrl: '../views/home.html',
                 controller:'homeController'
        })
        .state('document',{
            url:'/document',
            templateUrl: '../views/search.html',
            controller:'searchController'
        });

        $urlRouterProvider.otherwise('/home');
    })