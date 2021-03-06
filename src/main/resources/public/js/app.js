'use strict';

var AngularSpringApp = {};

var App = angular.module('AngularSpringApp', ['AngularSpringApp.filters', 'AngularSpringApp.services', 'AngularSpringApp.directives']);

App.config(['$routeProvider', function ($routeProvider) {
  $routeProvider.when('/new-user', {
    templateUrl: 'login/new-user.html',
    controller: newUserController
  });

  $routeProvider.when('/admin-account', {
    templateUrl: 'account/admin-account.html',
    controller: adminAccountController
  });

  $routeProvider.when('/user-account', {
        templateUrl: 'account/user-account.html',
        controller: userAccountController
  });

  $routeProvider.when('/login', {
      templateUrl: 'login/login.html',
      controller: loginController
  });

  $routeProvider.when('/send-letter-success', {
    templateUrl: 'account/send-letter-success.html',
    controller: sendLetterSuccessController
  });

  $routeProvider.otherwise({redirectTo: '/login'});
}]);


