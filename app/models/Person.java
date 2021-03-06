package models;

import java.util.List;

import siena.Generator;
import siena.Id;
import siena.Model;
import siena.Query;

public class Person extends Model{
	
	@Id(Generator.AUTO_INCREMENT)
	public Long id;
	
	public String email;
	
	public String nom;
	
	public long lastConnectionDate;
	
	public long creationDate;
	
	public boolean revoked;
	
	public int nbConnection;
	
	public static Query<Person> all() {
		return Model.all(Person.class);
	}

	public static List<Person> findAll() {
		return all().fetch();
	}
	
	public static Person findById(long id) {
		return all().filter("id", id).get();
	}
	
	public static Person findByEmail(String email) {
		return all().filter("email", email).get();
	}
	
}
