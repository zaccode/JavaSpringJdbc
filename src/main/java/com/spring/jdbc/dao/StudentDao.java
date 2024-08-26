package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.dao.entities.Student;

public interface StudentDao {
	public int insert(Student student);
	public int change(Student student);
	public int delete(int id);
	public Student getStudent(int studentId);
	public List<Student>getAllStudent();
}
