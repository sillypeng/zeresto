package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
import models.Person;
import models.Place;

public class Api extends Controller{
	
	public static void createPerson (Person person){
		person.creationDate=System.currentTimeMillis();
		person.revoked=false;
		person.nbConnection=0;
		person.lastConnectionDate=System.currentTimeMillis();
		person.save();
		renderJSON(person);
	}
	
	public static void createPlace (Place place){
		place.save();
		renderJSON(place);
	}
	
	public static void getPlaylist (long personId){
		
		
	}
}
