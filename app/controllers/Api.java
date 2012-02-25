package controllers;

import play.*;
import play.data.validation.Min;
import play.mvc.*;

import java.util.*;

import com.google.gson.Gson;

import models.*;

public class Api extends Controller{
	
	public static void addPerson (Person person){
		person.creationDate=System.currentTimeMillis();
		person.revoked=false;
		person.nbConnection=0;
		person.lastConnectionDate=System.currentTimeMillis();
		person.save();
		renderJSON(person);
	}
	
	public static void test(String json){
		if("application/json".equals(request.contentType)){
			List<Person> persons=new Gson().fromJson(json, List.class);
		}else if("application/xml".equals(request.contentType)){
			
		}
	}
	
	public static void addPlace (Place place){
		place.save();
		renderJSON(place);
	}
	
	public static void addPlaylist(long personId, long[] evaluationIds){
		
		Playlist playlist=new Playlist();
		
		playlist.owner=Person.findById(personId);
		
		List<Evaluation> evaluations=new ArrayList<Evaluation>(evaluationIds.length);
		
		for(long evaluationId:evaluationIds)
			evaluations.add(Evaluation.findById(evaluationId));
		
		playlist.evaluations=evaluations;
		
		playlist.save();
		
		renderJSON(playlist);
	}
	
	public static void addPlaylistEvaluation (long playlistId, long evaluationId){
		Playlist playlist=Playlist.findById(playlistId);
		
		
	}
	
	
	
	public static void requestRelation (
			@Min(1) long fromId, 
			@Min(1) long toId){
		
		Person p1=Person.findById(fromId);
		Person p2=Person.findById(toId);
		
		Relation relation=new Relation();
		relation.person1=p1;
		relation.person2=p2;
		
		relation.validation1=true;
		relation.validation2=false;
		
		relation.validation1Date=System.currentTimeMillis();
		relation.validation2Date=-1;
		
		relation.revoked=false;
		
		relation.save();
		renderJSON(relation);
	}
	
	public static void acceptRelation (long relationId){
		
		Relation relation=Relation.findById(relationId);
		
		relation.validation2=true;
		relation.validation2Date=System.currentTimeMillis();
		relation.revoked=false;
		
		relation.save();
		renderJSON(relation);
	}
	
	public static void getPlaylist (long personId){
		
		Person person=Person.findById(personId);
		
		List<Playlist> playlists1=Playlist.findByFollower(person);
		List<Playlist> playlists2=Playlist.findByOwner(person);
		
		renderJSON(playlists1.addAll(playlists2));
	}
}
