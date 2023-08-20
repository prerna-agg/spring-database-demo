package com.in28minutes.database.databasedemo.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.in28minutes.database.databasedemo.entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class PersonJPARepository {
	
	//connect to database 
	@PersistenceContext
	EntityManager em;
	
	public List<Person> findAll(){
		TypedQuery<Person> namedQuery = em.createNamedQuery("find_all_persons", Person.class);
		return namedQuery.getResultList();
	}
	
	public Person findById(int id) {
		return em.find(Person.class, id);
	}
	
	public Person update(Person person) {
		return em.merge(person);
	}
	
	public Person insert(Person person) {
		return em.merge(person);
	}
	
	public void deleteById(int id) {
		Person person = findById(id);
		em.remove(person);
	}	
	
	
}
