package GraphicsLibrary;

import java.text.DecimalFormat;
import java.util.Date;

interface Shape {
	double getArea();

	double getPerimeter();

	Point getOrigin() throws AssertionError;

	Date getTimestamp();

	ShapeType getShapeType();
}

/**
 * This Triangle class implements Shape interface
 *
 */
public class Triangle implements Shape {
	public Point origin;
	public double height;
	public double base;
	public double sideA;
	public double sideB;
	final Date timestamp;
	DecimalFormat decimalFormatSpecifier = new DecimalFormat(".##");

	Triangle(double height, double base, double sideA, Point origin, Date timestamp) throws AssertionError {
		this.height = height;
		this.base = base;
		this.sideA = sideA;
		this.origin = origin;
		this.timestamp = timestamp;
	}

	@Override
	public double getArea() {
		double perimeter = getPerimeter() / 2;
		return Double.parseDouble(decimalFormatSpecifier
				.format(Math.sqrt(perimeter * (perimeter - sideA) * (perimeter - sideB) * (perimeter - base))));
	}

	@Override
	public double getPerimeter() {
		return Double.parseDouble(decimalFormatSpecifier.format(sideA + sideB + base));
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public Date getTimestamp() {
		return timestamp;
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.Triangle;
	}

	
}