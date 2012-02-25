package models;

import java.util.List;

import siena.Generator;
import siena.Id;
import siena.Model;
import siena.Query;

public class Playlist {
	
	@Id(Generator.AUTO_INCREMENT)
	public Long id;
	
	public Person owner;
	
	public List<Person> followers;
	
	public List<Evaluation> evaluations;
	
	public boolean deleted;
	
	public boolean revoked;
	
	public static Query<Playlist> all() {
		return Model.all(Playlist.class);
	}

	public static List<Playlist> findAll() {
		return all().fetch();
	}
	
	public static List<Playlist> findByFollower(Person person) {
		return all().filter("followers", person).fetch();
	}
	

}
