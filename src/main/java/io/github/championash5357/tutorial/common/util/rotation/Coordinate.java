package io.github.championash5357.tutorial.common.util.rotation;

/**
 * Base implementation of coordinate system used to handle models.
 * 
 * @author ChampionAsh5357
 * */
public class Coordinate {

	private double x, y;
	
	public Coordinate(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double[] getCoordinate() {
		return new double[] {this.x, this.y};
	}
	
	public Coordinate set(double x, double y) {
		this.x = x;
		this.y = y;
		return this;
	}
	
	public Coordinate translate(double x, double y) {
		this.x += x;
		this.y += y;
		return this;
	}
	
	public Coordinate scale(double scale) {
		return scale(scale, scale);
	}
	
	public Coordinate scale(double x, double y) {
		this.x *= x;
		this.y *= y;
		return this;
	}
	
	public Coordinate rotate(double angle, double center, boolean isDegrees) {
		if(isDegrees) {
			angle = Math.toRadians(angle);
		}
		
		double x0 = this.x, y0 = this.y;
		double cos = Math.cos(angle), sin = Math.sin(angle);
		this.x = ((x0 - center) * cos) - ((y0 - center) * sin) + center;
		this.y = ((y0 - center) * cos) + ((x0 - center) * sin) + center;
		
		return this;
	}
}
