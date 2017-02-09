/*
@author: Marcel Samaruga da Costa
@date:2016-12-18
@description: controller used on the http service request
 */

// creating own service
myApp.service('myService', function() {
	this.name = 'Steppenwolf';
	var self = this;
	
	this.nameLength = function() {
		return self.name.length;
	};
});
// inject the new service below
 
myApp.controller('servicesController', ['$scope', '$http', '$location', '$log', 'myService', function($scope, $http, $location, $log, myService) {
    
	// ------------------------------------
	// location service: 
	$scope.locationAbsUrl = $location.absUrl();
	$scope.url = $location.url();
	$scope.host = $location.host();
	$scope.path = $location.path();
	$scope.protocol = $location.protocol();
	$scope.port = $location.port();
    
	// ------------------------------------
	// http
	$http.get("http://www.w3schools.com/angular/customers.php")
		  .then(function (response) {
					$scope.names = response.data.records;
					// response variables
					$log.info( 'data: ' + response.data );
					$log.info( 'status: ' + response.status );
					$log.info( 'statusText: ' + response.statusText );
					$log.info( 'headers: ' + response.headers );
				});
				
	/*$http({
        method : "GET",
        url : "welcome.htm"
    }).then(function mySucces(response) {
        $scope.myWelcome = response.data;
    }, function (response) {
        $scope.myWelcome = response.statusText;
    });
	
	$http.get('/api')
        .success(function (result) {
			$scope.rules = result;
        })
        .error(function (data, status) {
            console.log(data);
        });

    $scope.newRule = '';
    $scope.addRule = function () {
        $http.post('/api', { newRule: $scope.newRule })
            .success(function (result) {
                console.log(result);
                $scope.rules = result;
                $scope.newRule = '';
            })
            .error(function (data, status) {
                console.log(data);
            });
    };*/
	
	
	// ------------------------------------
	
	//output name from the myService (service customized)
	$scope.myServiceName = myService.name;
	
	// when it changes the value on this controller and it is necessary to use it on other controller, 
	// it's necessary to use the watcher: the name of the watch must be the same name of the scope variable	
	$scope.$watch('myServiceName', function() {
		myService.name = $scope.myServiceName;
	});
	
	// ------------------------------------
	
	
}]);