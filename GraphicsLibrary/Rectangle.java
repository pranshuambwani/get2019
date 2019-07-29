package GraphicsLibrary;

import java.text.DecimalFormat;
import java.util.Date;

/**
 * This Rectangle class implements Shape interface
 *
 */
public class Rectangle implements Shape {

	final double width;
	final double height;
	final Point origin;
	final Date timestamp;
	DecimalFormat decimalFormatSpecifier = new DecimalFormat(".##");

	Rectangle(double width, double height, Point origin, Date timestamp) throws AssertionError {
		this.width = width;
		this.height = height;
		this.origin = origin;
		this.timestamp = timestamp;
		if ((origin.getxPoint() + width) > 1920 || (origin.getyPoint() + height) > 1080) {
			throw new AssertionError("Width or Height is out of Screen in Rectangle");
		}
	}

	@Override
	public double getArea() {
		return Double.parseDouble(decimalFormatSpecifier.format(width * height));
	}

	@Override
	public double getPerimeter() {
		return Double.parseDouble(decimalFormatSpecifier.format(2 * (width + height)));
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
		return ShapeType.Rectangle;
	}

}