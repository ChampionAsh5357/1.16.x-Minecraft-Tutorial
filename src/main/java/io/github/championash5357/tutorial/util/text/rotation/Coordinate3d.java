package io.github.championash5357.tutorial.util.text.rotation;

import net.minecraft.util.Direction.Axis;
import net.minecraft.util.math.vector.Vector3d;

public class Coordinate3d {

	private double x, y, z;
	
	public Coordinate3d(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector3d getCoordinate() {
		return new Vector3d(this.x, this.y, this.z);
	}

	public Coordinate3d set(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		return this;
	}
	
	public Coordinate3d translate(double x, double y, double z) {
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}
	
	public Coordinate3d scale(double scale) {
		return scale(scale, scale, scale);
	}
	
	public Coordinate3d scale(double x, double y, double z) {
		this.x *= x;
		this.y *= y;
		this.z *= z;
		return this;
	}
	
	public Coordinate3d rotate(Axis axis, double angle, double center, boolean isDegrees) {
		return this.setRotation(axis, this.getAxis(axis).rotate(angle, center, isDegrees).getCoordinate());
	}
	
	private Coordinate getAxis(Axis axis) {
		switch(axis) {
		case X:
			return new Coordinate(this.y, this.z);
		case Y:
			return new Coordinate(this.x, this.z);
		case Z:
			return new Coordinate(this.x, this.y);
		default:
			throw new IndexOutOfBoundsException("No three-dimensional axis named " + axis.getName2());
		}
	}
	
	private Coordinate3d setRotation(Axis axis, double[] coordinate) {
		switch(axis) {
		case X:
			this.y = coordinate[0];
			this.z = coordinate[1];
			break;
		case Y:
			this.x = coordinate[0];
			this.z = coordinate[1];
			break;
		case Z:
			this.x = coordinate[0];
			this.y = coordinate[1];
			break;
		default:
			throw new IndexOutOfBoundsException("No three-dimensional axis named " + axis.getName2());
		}
		return this;
	}
}
