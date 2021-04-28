package com.mariuspaavel.geometry;

import java.util.*;
import java.io.*;

public abstract class Polygon2d{
	private List<Point2d> points = new ArrayList<Point2d>();
	private List<Segment2d> segments = new ArrayList<Segment2d>();	

	protected void addPoint2d(Point2d point){
		
	}

	protected Polygon2d(){
		construct();
		for(int i = 0; i < points.size(); i++){
			if(points.size() < 3)throw new RuntimeException(String.format("Cannot construct a polygon with only %d points. 3 is the minimum.", points.size()));
			if(i != points.size() -1){
				segments.add(new Segment2d(points.get(i), points.get(0)));
			}else segments.add(new Segment2d(points.get(i), points.get(i+1)));
		}
	}

	/**
	*An implementing class must add the points of the polygon using the addPoint2d method counter-clockwise
	*/	
	protected abstract void construct();
	
	
	
}
