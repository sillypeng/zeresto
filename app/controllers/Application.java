package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }
    public static void add() {
        render();
    }
    
    public static void hello(String name) {
    	
    	String[] vars=new String[]{"un","deux","trois"};
    	
    	String text1="Hello "+name+" !";
        renderJSON(vars);
    }
}