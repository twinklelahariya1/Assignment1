package com.gl.main;

import com.gl.dao.PersonDAOImpl;
import com.gl.model.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.logging.Logger;

public class SpringHibernateMain {

	final static Logger Logger = java.util.logging.Logger.getLogger(String.valueOf(SpringHibernateMain.class));

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		PersonDAOImpl personDAOImpl = context.getBean(PersonDAOImpl.class);
		
		Person person = new Person();
		person.setName("Alfiya"); person.setCountry("Bangladesh");

		personDAOImpl.save(person);
		
		Logger.info("Person::"+person);
		
		List<Person> list = personDAOImpl.list();
		
		for(Person p : list){
			Logger.info("Person List::"+p);
		}
		
		context.close();
		
	}

}
