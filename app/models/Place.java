package models;

import java.util.List;

import com.beoui.geocell.annotations.Geocells;

import siena.Generator;
import siena.Id;
import siena.Model;
import siena.Query;

public class Place extends Model{
	
	@Id(Generator.AUTO_INCREMENT)
	public Long id;
	
	@Geocells
	public List<String> areas;
	
	public double lat;
	
	public double lng;

	public boolean revoked;
	
	public String address;
	
	public String type;
	
	public String occasion;
	
	public double averagePrice;
	
	public String creationDate;
	
	public String modificationDate;
	
	public String website;
	
	public static Query<Place> all() {
		return Model.all(Place.class);
	}

	public static List<Place> findAll() {
		return all().fetch();
	}
}
