package GraphicsLibrary;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * This class performs various test cases on Screen Class
 *
 */
public class ScreenTest {
	Screen screen;

	@Rule
	public ExpectedException ex = ExpectedException.none();

	@Before
	public void init() {
		screen = new Screen();
	}

	@Test
	public void testAddShape() {
		// Adding a new Shape to shapeList
		assertTrue(screen.addShape(ShapeType.Circle, new Point(20, 35), new ArrayList<>(Arrays.asList(25d))));
	}

	@Test
	public void testDeleteShape(){
		// Deleting Shape from shapeList
		assertTrue(screen.deleteShape(ShapeType.Square, new Point(300, 100)));
	}

	@Test
	public void testAllDeleteShape() {
		// Delete shapes of Specific type for ex: Circle
		assertEquals(1, screen.deleteShapesOfSpecificType(ShapeType.Circle));
	}


	@Test
	public void testAscendingInTimestamp()  {
		// Sorting Shapes on the basis of Timestamp
		List<Shape> sortedShape = new ArrayList<Shape>();
		sortedShape.add(Screen.shapesList.get(0));
		sortedShape.add(Screen.shapesList.get(1));
		sortedShape.add(Screen.shapesList.get(2));
		sortedShape.add(Screen.shapesList.get(3));
		assertEquals(sortedShape, screen.ascendingInTimestamp());
	}

	@Test
	public void testAscendingInOriginDistance() {
		// Sorting Shapes on the basis of Origin Distance to (0,0)
		List<Shape> sortedShape = new ArrayList<Shape>();
		sortedShape.add(Screen.shapesList.get(1));
		sortedShape.add(Screen.shapesList.get(3));
		sortedShape.add(Screen.shapesList.get(0));
		sortedShape.add(Screen.shapesList.get(2));
		assertEquals(sortedShape, screen.ascendingInOriginDistance());
	}

	
	@Test
	public void testDeleteSpecifiedShapeTypeWithNull() {
		// Providing ShapeType as Null
		ex.expectMessage("ShapeType can't be Null in deleteShapesOfSpecificType");
		screen.deleteShapesOfSpecificType(null);
	}

	@Test
	public void testDeleteShapeWithNull(){
		// Providing Inputs in Delete Shape as Null
		ex.expectMessage("Arguments in deleteShape can't be Null");
		screen.deleteShape(null, null);
	}

	@Test
	public void testAddSquareOutOfBounds() throws AssertionError {
		// Providing a Square Points Out of Screen
		ex.expect(AssertionError.class);
		ex.expectMessage("Width is out of Screen in Square");
		screen.addShape(ShapeType.Square, new Point(1000, 1000), new ArrayList<Double>(Arrays.asList(250d)));
	}

	@Test
	public void testAddCircleOutOfBounds() throws AssertionError {
		// Providing a Circle Points Out of Screen
		ex.expect(AssertionError.class);
		ex.expectMessage("Circle is out of Screen");
		screen.addShape(ShapeType.Circle, new Point(1000, 1000), new ArrayList<Double>(Arrays.asList(2500d)));
	}


	@Test
	public void testAddRectangleOutOfBounds() throws AssertionError {
		// Providing a Triangle Points Out of Screen
		ex.expect(AssertionError.class);
		ex.expectMessage("Width or Height is out of Screen in Rectangle");
		screen.addShape(ShapeType.Rectangle, new Point(1000, 1000), new ArrayList<Double>(Arrays.asList(1000d, 25d)));
	}
}