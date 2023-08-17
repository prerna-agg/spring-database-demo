package com.in28minutes.database.databasedemo.jpa;

import org.springframework.stereotype.Repository;
import com.in28minutes.database.databasedemo.entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class PersonJPARepository {
	
	//connect to database 
	@PersistenceContext
	EntityManager em;
	
	public Person findById(int id) {
		return em.find(Person.class, id);
	}
	
	public Person update(Person person) {
		return em.merge(person);
	}
	
	public Person insert(Person person) {
		return em.merge(person);
	}
	
}
