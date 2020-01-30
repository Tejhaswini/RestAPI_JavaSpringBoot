package com.springbootrestapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrestapi.dao.CoursesDAO;
import com.springbootrestapi.model.Courses;

@RestController
@RequestMapping("/Courses")
public class CourseController {

	//Save a Course into the database
	@Autowired
	CoursesDAO dao;
	
	@PostMapping("/Courses")
	public Courses createCourse(@Valid @RequestBody Courses crs)
	{
		return dao.save(crs);
	}
	
	@GetMapping("/Courses")
	public List<Courses> getAllCourses()
	{
		return dao.searchAllCourses();
	}
	
	@GetMapping("/Courses/{courseId}")
	public ResponseEntity<Courses> getCourseById(@PathVariable(value="courseId") Long courseId)
	{
		Courses crs = dao.findOne(courseId);
		if(crs == null)
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(crs);
	}
	
}
