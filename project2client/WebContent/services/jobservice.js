/**
 * 
 */
app.factory('JobService',function($http){	
	var jobService={}
	jobService.addJob=function(job){
		var url="http://localhost:8080/project2middleware/addjob"
		return $http.post(url,job)
	}
	return jobService;
	})
	
