package com.springbootrestapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootrestapi.model.Courses;
import com.springbootrestapi.model.repository.CoursesRepository;

@Service
public class CoursesDAO {
	
	@Autowired
	CoursesRepository courseRepository;
	
	//To save a course 
	public Courses save(Courses crs)
	{
		return courseRepository.save(crs);
	}
    //To get the list of all the Courses 
	public List<Courses> searchAllCourses()
	{
		return courseRepository.findAll();
	}
	//get a course by the Course Id : 
	public Courses findOne(Long courseId)
	{
		return courseRepository.findOne(courseId);
	}
	
	//Delete a Course
	public void delete(Courses crs)
	{
		courseRepository.delete(crs);
	}
}
