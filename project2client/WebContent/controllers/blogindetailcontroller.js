/**
 * 
 */
app.controller('BlogInDetailCtrl',function($scope,BlogPostService,$routeParams,$location,$sce){
	var blogPostId=$routeParams.blogpostid //param name is defined in app.config in when statment
	alert('blogpost id is ' + blogPostId)
	
	//Get the result if the query select * from blogpost where blogpostid=?
	//STATMENT - Call a function in Service
	BlogPostService.getBlog(blogPostId).then(
			function(response){
				$scope.blogPost=response.data //single blogpost object
				$scope.content=$sce.trustAsHtml($scope.blogPost.blogContent)
			},
			function(response){
				if(response.status==401)
					$location.path('/login')
			})
	
    //Function for approving a blogpost
		$scope.approveBlogPost=function(blogPost){
		   BlogPostService.approveBlogPost(blogPost).then(
				   function(response){//when the blogpost approval status is updated successfully
					   //redirect the user to blogswaitingforapproval.html
					   $location.path('/blogswaitingforapproval')
				   },
				   function(response){
					   if(response.status==401)
						   $location.path('/login')
				   })
	    }	
			
	//function for rejecting a blogpost
       $scope.rejectBlogPost=function(blogPost){
    	   BlogPostService.rejectBlogPost(blogPost).then(
    			   function(response){
    				   $location.path('/blogswaitingforapproval')
    			   },
    			   function(response){
    				   if(response.status==401)
						   $location.path('/login')
    			   })
       }	  
})


