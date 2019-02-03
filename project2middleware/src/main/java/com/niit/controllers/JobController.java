package com.niit.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.JobDao;
import com.niit.models.ErrrorClazz;
import com.niit.models.Job;

@RestController
public class JobController {
@Autowired
private JobDao jobDao;
@RequestMapping(value="/addjob",method=RequestMethod.POST)
public ResponseEntity<?> addJob(@RequestBody Job job){
	try{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
	
		job.setPostedon(sdf.format(new Date()));
		jobDao.addJob(job);
	}catch(Exception e) {
		ErrrorClazz errorClazz=new ErrrorClazz(1,"Job Details not inserted");
		return new ResponseEntity<ErrrorClazz>(errorClazz,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	return new ResponseEntity<Job>(job,HttpStatus.OK);
}

@RequestMapping(value="/getalljobs",method=RequestMethod.GET)
public ResponseEntity<?> getAllJobs(){
	List<Job> jobs=jobDao.getAllJobs();
	return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
	}
}
