package com.in28minutes.database.databasedemo.jdbc;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.database.databasedemo.entity.Person;

/**
 * Talks to database and gets values from there
 */
@Repository
public class PersonJdbcDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//select * from person
	public List<Person> findAll(){
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public Person findById(int id){
		return jdbcTemplate.queryForObject("select * from person where id = ?", new Object[]{id}, new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public int deleteById(int id){
		return jdbcTemplate.update("delete from person where id = ?", new Object[]{id});
	}
	
	public int insert(Person person){
		return jdbcTemplate.update("insert into person(ID, Name, Location, BIRTH_DATE) "
				+ "values(?, ?, ?, ?)", 
				new Object[]{person.getId(), person.getName(),
						person.getLocation(),
						new Timestamp(person.getBirthDate().getTime())});
	}
	
	public int update(Person person){
		return jdbcTemplate.update("update person"
				+ " set Name = ?, Location = ?, BIRTH_DATE = ? "
				+ " where ID = ?", 
				new Object[]{
						person.getName(),
						person.getLocation(), 
						new Timestamp(person.getBirthDate().getTime()),
						person.getId()});
	}
}
