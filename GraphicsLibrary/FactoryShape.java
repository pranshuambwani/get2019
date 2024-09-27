package GraphicsLibrary;

import java.util.Date;
import java.util.List;

/**
 * This class is Factory class for Shapes
 *
 */
public class FactoryShape {
	static Shape createShape(ShapeType shapeType, Point point, List<Double> parameters) throws AssertionError {
		if (shapeType == null || point == null || parameters == null) {
			throw new NullPointerException("Arguments in addShape can't be Null");
		}
		switch (shapeType) {
		case Circle:
			if (parameters.size() != 1) {
				throw new AssertionError("Circle Radius should be Given");
			}
			return new Circle(parameters.get(0), point, new Date());
		case Rectangle:
			if (parameters.size() != 2) {
				throw new AssertionError("Rectangle Width and Height should be Given");
			}
			return new Rectangle(parameters.get(0), parameters.get(1), point, new Date());
		case Square:
			if (parameters.size() != 1) {
				throw new AssertionError("Square Width should be Given");
			}
			return new Square(parameters.get(0), point, new Date());
		case Triangle:
			if (parameters.size() != 3) {
				throw new AssertionError("Triangle Base Height and one Side Should be Given should be Given");
			}
			return new Triangle(parameters.get(0), parameters.get(1), parameters.get(2), point, new Date());
		default:
			return (Shape) new AssertionError("Shape out of Bounds");
		}
	}
}