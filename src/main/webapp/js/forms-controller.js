/*
@author: Marcel Samaruga da Costa
@date:2016-12-18
@description: controller used on the http service request
 */

myApp.controller('formsController', ['$scope', '$http', 'myService', function($scope, $http, myService) {
    
	// ------------------------------------
	// ng-options
	$scope.colors = [
		{hex : "ffffff", color : "white"},
		{hex : "000000", color : "black"},
		{hex : "cccccc", color : "gray"}
	];
	
    
	// ------------------------------------
	// http
	$scope.mySwitch = false;
	$scope.disableFunc = function() {
		return $scope.mySwitch = !$scope.mySwitch;
	}
	
	// ------------------------------------
	
	$scope.myServiceName = myService.name;
	
	$scope.$watch('myServiceName', function() {
		myService.name = $scope.myServiceName;
	});
	
	
	
}]);