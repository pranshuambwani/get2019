package GraphicsLibrary;

/**
 * This class represent the location of PointX and PointY on a screen size of
 * 1920x1080
 *
 */
public class Point {
	private final double xPoint;
	private final double yPoint;

	public Point(double xPoint, double yPoint){
		this.xPoint = xPoint;
		this.yPoint = yPoint;
	}

	boolean checkLocation() {
		if (xPoint >= 0 && xPoint <= 1920 && yPoint >= 0 && yPoint <= 1080) {
			return true;
		}
		return false;
	}

	public double getxPoint() {
		return xPoint;
	}

	public double getyPoint() {
		return yPoint;
	}
}

enum ShapeType {
	Square, Rectangle, Circle, Triangle;
}