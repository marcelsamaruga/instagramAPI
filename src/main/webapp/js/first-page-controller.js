/*
@author: Marcel Samaruga da Costa
@date:2016-12-18
@description: initial controller to be load on the simple page application
 */
 
myApp.controller('firstPageController', ['$scope', '$log', '$timeout', '$filter', '$routeParams', function($scope, $log, $timeout, $filter, $routeParams) {
    
	// populate variables to use on the html viewer
    $scope.firstName = 'Aragorn';
    $scope.armyPosition = 'Knight Rider';
    
    $scope.getName = function() {
        return $scope.firstName + ': ' + $scope.armyPosition;
    }
    
    $log.info($scope.getName());
	
	// ------------------------------------
	
	$timeout(function() {
		$log.info($scope.getName() + ' using timeout angular service.');
	}, 1000);
	
	// ------------------------------------
	
	$scope.twitterAccountLowerCase = function(value) {
		return $filter('lowercase')(value);
	};
	
	// ------------------------------------
	
	$scope.characters = 5;
	
	$scope.rules = [      
        { ruleName: "Less than 5 characters!", codeError: 0 },
        { ruleName: "More than 5 characters!", codeError: 1 },
		{ ruleName: "Something else", codeError: -1 }
    ];
    
    console.log($scope.rules);
	
	// ------------------------------------
	
	// orderBy Filter	
	$scope.orderColumn = function(filter) {
		$scope.reverse = (filter === $scope.orderColumnValue) ? ! $scope.reverse : false;
		$scope.orderColumnValue = filter;
	};
	
    
}]);