package GraphicsLibrary;

import java.text.DecimalFormat;
import java.util.Date;

/**
 * This Circle class implements Shape interface
 *
 */
public class Circle implements Shape {

	public final double radius;
	public final Point origin;
	public final Date timestamp;
	public final double pi=3.14;
	public DecimalFormat decimalFormatSpecifier = new DecimalFormat(".##");

	Circle(double radius, Point origin, Date timestamp) throws ScreenException {
		this.radius = radius;
		this.origin = origin;
		this.timestamp = timestamp;
		Point originPoint = getOrigin();
		if (originPoint == null) {
			throw new ScreenException("Circle is out of Screen");
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
	public Point getOrigin() throws ScreenException {
		
			return new Point(origin.getxPoint(),origin.getyPoint());
	}

	/**
	 * If the given point is enclosed in circle then (x-h)2 + (y-k)2 <= r2 should
	 * satisfy where (h,k) is the point that is Enclosed or not
	 */
	@Override
	public boolean isPointEnclosed(Point isPointEnclosed) {
		if (Math.pow(origin.getxPoint() - isPointEnclosed.getxPoint(), 2)
				+ Math.pow(origin.getyPoint() - isPointEnclosed.getyPoint(), 2) <= Math.pow(radius, 2)) {
			return true;
		}
		return false;
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