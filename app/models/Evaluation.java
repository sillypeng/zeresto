package models;

import java.util.List;

import siena.Generator;
import siena.Id;
import siena.Model;
import siena.Query;

public class Evaluation {
	
	@Id(Generator.AUTO_INCREMENT)
	public Long id;
	
	public int score ;
	
	public List<String> comments;
	
	public Place place;
	
	public Person person;
	
	public long creationDate;
	
	public long modificationDate;
	
	public List<Long> checkinDate;
	
	public double price;
	
	public static Query<Evaluation> all() {
		return Model.all(Evaluation.class);
	}

	public static List<Evaluation> findAll() {
		return all().fetch();
	}
}
