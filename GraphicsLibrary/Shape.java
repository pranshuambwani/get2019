package GraphicsLibrary;

import java.util.Date;

/**
 * This interface is made for Shapes Properties
 *
 */
public interface Shape {

	double getArea();

	double getPerimeter();

	Point getOrigin() throws ScreenException;

	boolean isPointEnclosed(Point isPointEnclosed) throws Exception;

	Date getTimestamp();

	ShapeType getShapeType();
}

enum ShapeType {
	Square, Rectangle, Circle, Triangle;
}