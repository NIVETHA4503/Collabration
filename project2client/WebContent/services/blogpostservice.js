/**
 * 
 */
app.factory('BlogPostService',function($http){
	var blogPostService={}
	var BASE_URL ="http://localhost:8080/project2middleware"
	
	//service(blogPost)   <- controller (blogPost)  <- view (user)
	blogPostService.addBlogPost=function(blogPost){//from frontend controller,get blogpost from controller
		//Service to ?middleware
		return $http.post(BASE_URL + "/addblog",blogPost)  //returning the response to the frontend controller 
	}
	
	blogPostService.getBlogsApproved=function(){
	 	return $http.get(BASE_URL + "/blogsapproved")
	}
	
	blogPostService.getBlogsWaitingForApproval=function(){
		return $http.get(BASE_URL + "/blogswaitingforapproval")
	}
	blogPostService.getBlog=function(blogPostId){
		alert('call the middleware to get the data')
		return $http.get(BASE_URL + "/getblog/"+blogPostId)
	}
	
	blogPostService.approveBlogPost=function(blogPost){
		return $http.put(BASE_URL + "/approveblogpost",blogPost)
	}
	
	blogPostService.rejectBlogPost=function(blogPost){
		return $http.put(BASE_URL + "/rejectblogpost",blogPost)
	}

	
	return blogPostService;
})
//5 - creating an object ,
//6-  assignment statement 
//9 - adding a function to the object 9,14,18
//15 - returning the object