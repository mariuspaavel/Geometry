package com.mariuspaavel.geometry;

import java.util.*;
import java.io.*;
/**
* A segment is an object owning references to two point objects.
* A segment represents a line.
*/
public class Segment2d{
	Point2d a;
	Point2d b;
	
	private double slope;
	private double equationB;
	private boolean vertical;
	private double x;
	
	/**
	*Constructs the segment by supplying two point objects.
	*/
	public Segment2d(Point2d a, Point2d b){
		this.a = a;
		this.b = b;
	}
	void calcEquation(){
		x = Double.NaN;
		double dy = b.y - a.y;
		double dx = b.x - a.x;
		if(dx == 0){
			if(dy > 0)slope = Double.POSITIVE_INFINITY;
			else if(dy < 0)slope = Double.NEGATIVE_INFINITY;
			else slope = Double.NaN;
			x = a.x;
			vertical = true;
			return;
		}
		slope = dy / dx;
		equationB = a.y - slope * a.x;
	}
	private double minX(){
		if(a.x < b.x)return a.x;
		else return b.x;
	}
	private double maxX(){
		if(a.x > b.x)return a.x;
		else return b.x;
	}
	private double minY(){
		if(a.y < b.y)return a.y;
		else return b.y;
	}
	private double maxY(){
		if(a.y < b.y)return a.y;
		else return b.y;
	}
	
	
	/**
	* Gets the interception point of the current segment and another.
	* If no such point exists, null is returned
	* @returns The interception point or null if lines don't intercept
	*/
	public Point2d intercept(Segment2d other){
		double interceptX;
		double interceptY;
		other.calcEquation();
		if(slope == other.slope)return null;
		else if(vertical){
			interceptX = x;
			interceptY = other.slope * interceptX + other.equationB;
		}
		else if(other.vertical){
			interceptX = other.x;
			interceptY = slope * interceptX + equationB;
		}else{
			interceptX = (other.equationB - equationB) / (slope - other.slope);
			interceptY = slope*interceptX + equationB;
		}
		
		if(interceptX < minX() || interceptX > maxX())return null;
		if(interceptX < other.minX() || interceptX > other.maxX())return null;
		if(interceptY < minY() || interceptY > maxY())return null;
		if(interceptY < other.minY() || interceptY > other.maxY())return null;
		
		Point2d intercept = new Point2d();
		intercept.setRaw(interceptX, interceptY);
		return intercept;
	}

}
