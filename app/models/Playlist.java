package models;

import java.util.List;

import siena.Generator;
import siena.Id;
import siena.Model;
import siena.Query;

public class Playlist {
	
	@Id(Generator.AUTO_INCREMENT)
	public Long id;
	
	public List<Place> places;
	
	public Person owner;
	
	public List<Person> follower;
	
	public List<Evaluation> evaluations;
	
	
	
	public static Query<Playlist> all() {
		return Model.all(Playlist.class);
	}

	public static List<Playlist> findAll() {
		return all().fetch();
	}
	

}
