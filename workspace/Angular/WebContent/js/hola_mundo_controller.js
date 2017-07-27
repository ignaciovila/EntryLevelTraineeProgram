var app = angular.module('holaMundoApp', []);
app.controller("HolaMundoController", function($scope, $http) {
	
	$scope.personas = [];
	
	$http.get('../personas_json.php').success(function(data){
        $scope.personas = data;
    });
	
	$scope.agregarPersonaForm = function() {
		$scope.personas.push({ nombre: $scope.nombre, apellido: $scope.apellido});
		
		$scope.nombre = '';
		$scope.apellido = '';
	};
	
});