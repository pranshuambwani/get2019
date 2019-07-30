package GraphicsLibrary;

import java.text.DecimalFormat;
import java.util.Date;

/**
 * This Triangle class implements Shape interface
 *
 */
public class Triangle implements Shape {
	public Point origin;
	public Point pointA;
	public double height;
	public double base;
	public double sideA;
	public double sideB;
	final Date timestamp;
	DecimalFormat decimalFormatSpecifier = new DecimalFormat(".##");

	Triangle(double height, double base, double sideA, Point origin, Date timestamp) throws ScreenException {
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

	private double triangleArea(Point a,Point b,Point c) throws ScreenException{
		//Math.abs returns the positive value
		return  Math.abs(((a.getxPoint())*(b.getyPoint()-c.getyPoint()) + b.getxPoint()*(c.getyPoint()-a.getyPoint())+  c.getxPoint()*(a.getyPoint()-b.getyPoint()))/2.0); 
	}
	private boolean enclose(Point p) throws Exception {
		double perimeter = getPerimeter() / 2;
		double A = this.getArea();
		Point b = new Point(origin.getxPoint()+base,origin.getyPoint());
		Point c = new Point(origin.getxPoint(),origin.getyPoint()+perimeter);
		
		double a1 = triangleArea(p,b,c);
		double a2 = triangleArea(origin,p,c);
		double a3 = triangleArea(origin,b,p);
		
		return (A== a1+a2+a3);
	}
	/**
	 * check a point is inside a triangle or outside
	 * @return true if point is inside else false
	 * @throws Exception 
	 */
	public boolean isPointEnclosed(Point p) throws Exception {
		return enclose(p);
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