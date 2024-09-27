package GraphicsLibrary;

import java.text.DecimalFormat;
import java.util.Date;

/**
 * This Circle class implements Shape interface
 *
 */
public class Circle implements Shape {

	public final double radius;
	public final double pi=3.14;
	public final Point origin;
	public final Date timestamp;
	public DecimalFormat decimalFormatSpecifier = new DecimalFormat(".##");

	Circle(double radius, Point origin, Date timestamp) throws AssertionError {
		this.radius = radius;
		this.origin = origin;
		this.timestamp = timestamp;
		Point originPoint = getOrigin();
		if (originPoint == null) {
			throw new AssertionError("Circle is out of Screen");
		}
	}

	@Override
	public double getArea() {
		return Double.parseDouble(decimalFormatSpecifier.format(pi * radius * radius));
	}

	@Override
	public double getPerimeter() {
		return Double.parseDouble(decimalFormatSpecifier.format(2 * pi * radius));
	}

	@Override
	public Point getOrigin() {
		double valueOfX1;
		double valueOfX2;
		double valueOfY;
		double A;
		double B;
		double C;
		double M = origin.getyPoint() / origin.getxPoint();

		/*
		 * y = mx so we will substitute the value of y to circle equation (x-h)2 +
		 * (y-k)2 = r2 where (h,k) is the radius coordinate x2(m2 + 1) - 2x(mx + h) + k2
		 * + h2 - r2 = 0 is the equation we get after substitution of y This equation is
		 * similar to Ax2 + Bx + C = 0 so we can easily calculate roots of x by formula
		 * of Quadratic Equation
		 */
		A = (Math.pow(M, 2) + 1);
		B = (-2 * (M * origin.getyPoint() + origin.getxPoint()));
		C = (Math.pow(origin.getyPoint(), 2) + Math.pow(origin.getxPoint(), 2) - Math.pow(radius, 2));
		double underRoot = Math.sqrt((Math.pow(B, 2) - 4 * A * C));
		valueOfX1 = (-B + underRoot) / (2 * A);
		valueOfX2 = (-B - underRoot) / (2 * A);

		/*
		 * We will get two coordinates of x so we will select only that coordinate whose
		 * value is less than the x coordinate of radius
		 */
		if (valueOfX1 <= origin.getxPoint() && valueOfX2 <= 1920) {
			valueOfY = M * valueOfX1;
			return new Point(valueOfX1, valueOfY);
		} else if (valueOfX2 <= origin.getxPoint() && valueOfX1 <= 1920) {
			valueOfY = M * valueOfX2;
			return new Point(valueOfX2, valueOfY);
		}
		return null;
	}
	@Override
	public Date getTimestamp() {
		return timestamp;
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.Circle;
	}
}