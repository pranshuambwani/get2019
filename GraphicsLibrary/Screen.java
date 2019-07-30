package GraphicsLibrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class implements various methods based on Shapes
 *
 */
public class Screen {
	static List<Shape> shapesList = new ArrayList<>();

	public Screen() throws ScreenException {
		shapesList.clear();
		addShape(ShapeType.Circle, new Point(200, 200), new ArrayList<>(Arrays.asList(50d)));
		addShape(ShapeType.Rectangle, new Point(1, 23), new ArrayList<>(Arrays.asList(12d, 23d)));
		addShape(ShapeType.Square, new Point(300, 100), new ArrayList<>(Arrays.asList(120d)));
		addShape(ShapeType.Triangle, new Point(40, 200), new ArrayList<>(Arrays.asList(120d, 200d, 200d)));
	}

	/**
	 * Adds Shape to shapeList
	 * 
	 * @param shapeType
	 * @param point
	 * @param parameters
	 * @throws ScreenException
	 */
	boolean addShape(ShapeType shapeType, Point point, List<Double> parameters) throws ScreenException {
		shapesList.add(FactoryShape.createShape(shapeType, point, parameters));
		return true;
	}

	/**
	 * Deletes the given Shape
	 * 
	 * @param shapeType
	 * @param point
	 * @param parameters
	 * @return
	 * @throws ScreenException
	 */
	boolean deleteShape(ShapeType shapeType, Point point) throws ScreenException {
		if (shapeType == null || point == null) {
			throw new NullPointerException("Arguments in deleteShape can't be Null");
		}
		for (int loop = 0; loop < shapesList.size(); loop++) {
			if (shapesList.get(loop).getShapeType() == shapeType
					&& shapesList.get(loop).getOrigin().getxPoint() == point.getxPoint()) {
				shapesList.remove(loop);
				return true;
			}
		}
		return false;
	}

	/**
	 * Delete all the given type of Specific Shapes
	 * 
	 * @param shapeType
	 */
	int deleteShapesOfSpecificType(ShapeType shapeType) {
		int noOfDeletedShapes = 0;
		if (shapeType == null) {
			throw new NullPointerException("ShapeType can't be Null in deleteShapesOfSpecificType");
		}
		for (int loop = 0; loop < shapesList.size(); loop++) {
			if (shapesList.get(loop).getShapeType() == shapeType) {
				shapesList.remove(loop);
				noOfDeletedShapes++;
				loop--;
			}
		}
		return noOfDeletedShapes;
	}
	
	/**
	 * Arranges Shapes in ascending order on the basis of Timestamp
	 * 
	 * @return
	 * @throws ScreenException
	 */
	ArrayList<Shape> ascendingInTimestamp() throws ScreenException {
		ArrayList<Shape> sortedShapes = new ArrayList<>(shapesList);
		for (int loop = 0; loop < sortedShapes.size() - 1; loop++) {
			for (int loop2 = 0; loop2 < sortedShapes.size() - 1 - loop; loop2++) {
				if (sortedShapes.get(loop2).getTimestamp().after(sortedShapes.get(loop2 + 1).getTimestamp())) {
					Shape temp = sortedShapes.get(loop2 + 1);
					sortedShapes.set(loop2 + 1, sortedShapes.get(loop2));
					sortedShapes.set(loop2, temp);
				}
			}
		}
		return sortedShapes;
	}


	/**
	 * Returns all the Shapes that Enclose the given Point
	 * 
	 * @param point
	 * @return
	 * @throws Exception 
	 */
	ArrayList<Shape> isPointEnclosed(Point point) throws Exception {
		if (point == null) {
			throw new NullPointerException("Point can't be Null in isPointEnclosed");
		}
		ArrayList<Shape> pointEnclosedShapes = new ArrayList<>();
		for (int loop = 0; loop < shapesList.size(); loop++) {
			if (shapesList.get(loop).isPointEnclosed(point)) {
				pointEnclosedShapes.add(shapesList.get(loop));
			}
		}
		return pointEnclosedShapes;
	}
}