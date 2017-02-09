/*
@author: Marcel Samaruga da Costa
@date:2016-12-18
@description: controller to custom directives
 */

 
// creating a custom directive using angular js
// 1) name of the directive must use camel case: myCustomDirective instead of my-custom-directive ( signal - is not a valid variable name in javascript)
// 2) parameters:
// 	 2.1) restrict: the valid HTML elements to use the custom directive. Possibles values: AECM (stands for Attributes,Elements,Class,Comments). Defaul: EA
// 	 2.2) template: HTML piece of code to response 
// 	 2.3) templateUrl: URL which the HTML file exists (the one who should be output)
// 	 2.4) replace: when angular finds the name of the directive replace for the HTML code instead of maintain on the source-code. Default: false
// 3) parameters:

myApp.directive("myCustomDirective", function() {
   return {
       restrict: 'AECM',
       templateUrl: 'directives/table-result.html',
       replace: true
   }
});
 
// scope parameter is responsible to use the $scope inside the directive.
// the scope expects a javascript object. But the values are used in 3 ways 
// @ represents text values
// = represents objects
// & represents functions
myApp.directive("myCustomDirectiveObj", function() {
   return {
       restrict: 'AECM',
       templateUrl: 'directives/table-result-obj.html',
       replace: true,
	   scope: {
			myObject: "=",
			myFunction: "&",
			myText: "@"
	   }
   }
});

// used for repeated list
myApp.directive("myCustomDirectiveObjList", function() {
   return {
       restrict: 'AE',
       templateUrl: 'directives/table-result-list-obj.html',
       replace: true,
	   scope: {
			color: "="
	   }
   }
});
 
 
 // controller used on the directive
 myApp.controller('customDirectivesController', ['$scope', '$filter', function($scope, $filter) {
    
	// ------------------------------------
	// custom directives
	
	$scope.obj = {
		name: 'Samaruga, Marcel',
        address: '555 Main St.',
        city: 'New York',
        state: 'NY',
        zip: '11111'
	};
	
	$scope.textValue = 'He loves Inception';
	
	$scope.myFunction = function(val) {
		return $filter('uppercase')(val);
	};
	
	//
	
	// list for the repeated list
	$scope.listColor = [
		{
			name: 'Black',
			hex: '#000000'
		},
		{
			name: 'White',
			hex: '#ffffff'
		}
	];
	
}]);