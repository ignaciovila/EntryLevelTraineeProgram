var app = angular.module('calculadoraApp', []);
app.controller("calculadoraController", function($scope) {
	
	$scope.numero1;
	$scope.numero2;
	$scope.op;
	$scope.resultado;
	
	$scope.operacion = function() {
		switch ($scope.op) {
		case "suma":
			$scope.resultado = parseFloat($scope.numero1) + parseFloat($scope.numero2);
			break;
		case "resta":
			$scope.resultado = parseFloat($scope.numero1) - parseFloat($scope.numero2);
			break;
		case "multiplicacion":
			$scope.resultado = parseFloat($scope.numero1) * parseFloat($scope.numero2);
			break;
		case "division":
			$scope.resultado = parseFloat($scope.numero1) / parseFloat($scope.numero2);
			break;
		default:
			$scope.resultado = null;
		}
	};
	
});