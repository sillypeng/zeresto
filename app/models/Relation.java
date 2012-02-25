package models;

import java.util.List;

import siena.Generator;
import siena.Id;
import siena.Model;
import siena.Query;

public class Relation extends Model{

	@Id(Generator.AUTO_INCREMENT)
	public Long id;
	
	public Person person1;
	
	public Person person2;
	
	public boolean validation1;
	
	public boolean validation2;
	
	public long validation1Date;
	
	public long validation2Date;
	
	public boolean revoked;
	
	public static Query<Relation> all() {
		return Model.all(Relation.class);
	}

	public static List<Relation> findAll() {
		return all().fetch();
	}
}
