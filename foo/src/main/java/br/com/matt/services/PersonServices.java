package br.com.matt.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.matt.model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	
	public Person create(Person person) {
		return person;
	} 
	
	
	public Person update(Person person) {
		return person;
	}
	
	public void  delete(String id) {
		
	}
	
	public Person findById (String id) {
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Matt");
		person.setLastName("Jr.");
		person.setAddress("Uberlandia - Minas Gerais - Brasil");
		person.setGender("Male");
				
		return person;
		
		
		
		
	}
	
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
			
		}
		
		return persons;
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name"  + i);
		person.setLastName("last name" +i);
		person.setAddress("some address"+i);
		person.setGender("person gender");
		return person;
	}


	
	
}