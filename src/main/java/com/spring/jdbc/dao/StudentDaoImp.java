package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.dao.entities.Student;

@Component("studentDao")
public  class StudentDaoImp implements StudentDao{
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insert(Student student) {
		String query = "insert into student(id,name,city) values(?,?,?)";
		int r = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}
	
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



	@Override
	public int change(Student student) {
		String query = "update student set name=? ,city=? where id = ?";
		int res = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return res;
	}



	@Override
	public int delete(int id) {
		String query = "delete from student where id = ?";
		int res = this.jdbcTemplate.update(query,id);
		return res;
	}


//query & id => rowmapperclaass => class method return student type object 
	@Override
	public Student getStudent(int studentId) {
		String query = "select * from student where id=?";
		RowMapper<Student>rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
		return student;
	}



	@Override
	public List<Student> getAllStudent() {
		String query = "select * from student";
		List<Student>list = this.jdbcTemplate.query(query,new RowMapperImpl());
		return list;
	}
}
