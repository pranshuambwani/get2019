package GraphicsLibrary;

import java.text.DecimalFormat;
import java.util.Date;


/**
 * This Square class implements Shape interface
 *
 */
public class Square implements Shape {

	final double width;
	final Point origin;
	final Date timestamp;
	DecimalFormat decimalFormatSpecifier = new DecimalFormat(".##");

	Square(double width, Point origin, Date timestamp) throws AssertionError {
		this.width = width;
		this.origin = origin;
		this.timestamp = timestamp;
		if ((origin.getxPoint() + width) > 1920 || (origin.getyPoint() + width) > 1080) {
			throw new AssertionError("Width is out of Screen in Square");
		}
	}

	@Override
	public double getArea() {
		return Double.parseDouble(decimalFormatSpecifier.format(width * width));
	}

	@Override
	public double getPerimeter() {
		return Double.parseDouble(decimalFormatSpecifier.format(4 * width));
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
		return ShapeType.Square;
	}
}