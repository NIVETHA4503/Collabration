/**
 * 
 */







app.controller('UserCtrl',function($scope,UserService,$location){
	$scope.userRegistration=function(user){
		UserService.userRegistration(user).then(
				function(respone){
			$location.path('/login')
		},
		function(response){
			$scope.error=response.data
		})
	}
	$scope.login=function(user){
		UserService.login(user).then(function(response){
			$location.path('/home')
		},function(response){
			$scope.error=response.data
		})
	}
})
