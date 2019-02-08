/**
 * 
 */
app.factory('UserService',function($http){
	var userService={}
	userService.userRegistration=function(user)
	{
		return	$http.post("http://localhost:8080/project2middleware/registration",user)
	}
	userService.login=function(user){
	     return $http.post("http://localhost:8080/project2middleware/login",user)
		}
	
	return userService;
})


