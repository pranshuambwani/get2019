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
	public void init() throws Exception {
		screen = new Screen();
	}

	@Test
	public void testAddShape() throws Exception {
		// Adding a new Shape to shapeList
		assertTrue(screen.addShape(ShapeType.Circle, new Point(20, 35), new ArrayList<>(Arrays.asList(25d))));
	}
	
	@Test
	public void testAddShape2() throws Exception {
		// Adding a new Shape to shapeList
		assertTrue(screen.addShape(ShapeType.Square, new Point(20, 35), new ArrayList<>(Arrays.asList(25d))));
	}

	@Test
	public void testDeleteShape() throws ScreenException {
		// Deleting Shape from shapeList
		assertTrue(screen.deleteShape(ShapeType.Square, new Point(300, 100)));
	}

	@Test
	public void testAllDeleteShape() throws Exception {
		// Delete shapes of Specific type for ex: Circle
		assertEquals(1, screen.deleteShapesOfSpecificType(ShapeType.Circle));
	}

	@Test
	public void testAscendingInTimestamp() throws Exception {
		// Sorting Shapes on the basis of Timestamp
		List<Shape> sortedShape = new ArrayList<Shape>();
		sortedShape.add(Screen.shapesList.get(0));
		sortedShape.add(Screen.shapesList.get(1));
		sortedShape.add(Screen.shapesList.get(2));
		sortedShape.add(Screen.shapesList.get(3));
		assertEquals(sortedShape, screen.ascendingInTimestamp());
	}
	
	@Test
	public void testIsPointEnclosed() throws Exception {
		// Providing List of Shapes that all Enclose the Given Point
		List<Shape> sortedShape = new ArrayList<Shape>();
		sortedShape.add(Screen.shapesList.get(0));
		assertEquals(sortedShape, screen.isPointEnclosed(new Point(200, 200)));
	}



}