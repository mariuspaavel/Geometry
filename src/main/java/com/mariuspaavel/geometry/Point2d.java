package com.mariuspaavel.geometry;

import java.util.*;
import java.io.*;
/**
* A mutable class for representing a point in 2d space.
* This class doesn't have constructors, it is constructed using the set methods and it is reusable for performance reasons.
*/
public class Point2d implements Cloneable{
	double x;
	double y;

	/**
	* Construct the point using x and y coordiantes.
	*/
	public void setRaw(double x, double y){
		this.x = x;
		this.y = y;
	}
	/**
	*Copies the contents of another point to this point.
	*/
	public void setCopy(Point2d p){
		this.x = p.x;
		this.y = p.y;
	}
	/**
	* Sets the point to the point that is pointed by a vector from an origin point.
	* @param origin The origin point from whick the vector points
	* @param pointer The vector that points to the point that the object will be set to.
	*/
	public void setPointed(Point2d origin, Vec2d pointer){
		setRaw(origin.x + pointer.x, origin.y + pointer.y);
	}
	/**
	*Moves the point by the amount specified in the vector
	*/
	public void move(Vec2d howMuch){
		this.x += howMuch.x;
		this.y += howMuch.y;
	}
	public void move(Vec2d... vecs){
		for(int i = 0; i < vecs.length; i++){
			move(vecs[i]);
		}
	}

	@Override
	public Object clone(){
		Point2d p = new Point2d();
		p.x = x;
		p.y = y;
		return p;
	}
	/**
	*Prints a representation to a PrintStream
	*/
	public void print(PrintStream s){
		s.print("(");
		s.print(x);
		s.print(", ");
		s.print(y);
		s.print(")");
	}
}


