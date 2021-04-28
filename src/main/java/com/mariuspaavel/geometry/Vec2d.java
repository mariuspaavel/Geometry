package com.mariuspaavel.geometry;

import java.util.*;
import java.io.*;

/**
*A mutable class for representing a vector in 2d space.
* This class doesn't have constructors, it's state is initiated using the set methods.
*/
public class Vec2d implements Cloneable{
	double x;
	double y;
	private	double len;
	private double radians;
	
	/**
	* Sets the x and y components of the vector.
	*/
	public void setRaw(double x, double y){
		this.x = x;
		this.y = y;
	}
	/**
	* Copies the state of another vector into this vector.
	*/
	public void setCopy(Vec2d v){
		this.x = v.x;
		this.y = v.y;
	}
	/**
	*Sets the vector using an angle in radians and the length of the vector
	*/
	public void setAngle(double radians, double length){
		this.x = length*Math.cos(radians);
		this.y = length*Math.sin(radians);
	}
	public void setAngle(Angle2d angle, double length){
		setAngle(angle.getRadians(), length);
	}

	/**
	*Calculates the vector as the difference between two points
	*/
	public void setPointer(Point2d a, Point2d b){
		this.x = b.x - a.x;
		this.y = b.y - a.y;
	}
	/**
	*Calculates the length of the vector
	*/
	public double getLength(){
		return len = Math.sqrt(x*x + y*y);
	}
	/**
	*Calculates the angle of the vector
	*/
	public double getAngle(){
		return radians = Math.atan2(y, x);
	}
	/**
	*Calculates the angle between this vector and another vector
	*/
	public double angleFrom(double other){
		double heading = getAngle();
		double delta = heading - other;
		if(delta < -Math.PI)delta += 2*Math.PI;
		else if(delta >= Math.PI)delta -= 2*Math.PI;
		return delta;
	}
	public double angleFrom(Angle2d other){
		return angleFrom(other.getRadians());
	}
	public double angleFrom(Vec2d other){
		return angleFrom(other.getAngle());
	}

	/**
	*Normalizes the vector by setting the length to 1;
	*/
	public void normalize(){
		getLength();
		if(len==0)return;
		x /= len;
		y /= len;
	}
	/**
	*Rotates the vector by a specified amount
	*/
	public void rotate(double radians){
		getLength();
		getAngle();
	 	this.radians += radians;
		setAngle(radians, len);
	}
	public void rotate(Angle2d angle){
		rotate(angle.radians);
	}
	
	public void add(Vec2d vec){
		this.x += vec.x;
		this.y += vec.y;
	}
	public void add(Vec2d... vecs){
		for(int i = 0; i < vecs.length; i++){
			add(vecs[i]);
		}
	}
	public double dotProduct(Vec2d other){
		return x*other.x + y*other.y;
	}
	
}
