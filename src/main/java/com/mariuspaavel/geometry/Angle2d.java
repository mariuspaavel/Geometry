package com.mariuspaavel.geometry;

public class Angle2d{
	double radians;
	public void setRadians(double radians){
		raw = true;
		this.radians = radians;
	}
	public void setDegrees(double degrees){
		raw = true;
		this.radians = degrees / 180 * Math.PI;
	}
	boolean raw = true;
	Point2d a;
	Point2d b;
	Point2d c; 
	public void set3Points(Point2d a, Point2d b, Point2d c){
		this.a = a;
		this.b = b;
		this.c = c;
		if(a != null && b != null && c != null)raw = false;
	}

	private Vec2d ba = new Vec2d();
	private Vec2d bc = new Vec2d();
	public double getRadians(){
		if(raw)return radians;
		else{
			ba.setPointer(b, a);
			bc.setPointer(b, c);
			return bc.angleFrom(ba);
		}
	}
	private void convertToRaw(){
		if(raw)return;
		radians = getRadians();
		raw = true;
	}

	public void add(Angle2d other){
		convertToRaw();
		add(other.getRadians());
		radians = standardize(radians);
	}

	public void add(double other){
		convertToRaw();
		radians += other;
	}
	
	private double standardize(double input){
		while(input < -Math.PI)input += 2*Math.PI;
		while(input >= Math.PI)input -= 2*Math.PI;
		return input;	
	}
	
	public double angleFrom(double other){
		double delta = radians - other;
		return standardize(delta);
	}
	public double angleFrom(Angle2d other){
		return angleFrom(other.radians);
	}
	public double angleFrom(Vec2d other){
		return angleFrom(other.getAngle());
	}
	
}
