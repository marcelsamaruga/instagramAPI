var myApp = angular.module('myApp', ['ngRoute']);

// directives
// ng-app: 
// ng-controller:
// ng-model:  
// ng-class: 
// ng-if: 
// ng-repeat: 

// $scope: service to bind the controller and the view layers
// $log: better service to log on the console
// $timeout: simple way to use timeout js function
// $filter: extra functions to handle with data


// router to the pages
myApp.config(function ($routeProvider) {
    
    console.log($routeProvider);
	
	// to run local files it is important to use firefox/IE 
	// because security, chrome blocks the page loading, unless if the page runs on webserver
	// not recommended, but you also can run chrome using: chrome.exe --allow-file-access-from-files
	
	
	$routeProvider
		.when('/', {
			templateUrl: 'first-page.html',
			controller: 'firstPageController'
		})
		.when('/services', {
			templateUrl: 'services.html',
			controller: 'servicesController'
		})
		.when('/forms', {
			templateUrl: 'forms.html',
			controller: 'formsController'
		})
		.when('/customDirectives', {
			templateUrl: 'custom-directives.html',
			controller: 'customDirectivesController'
		});
		
});
