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

}
