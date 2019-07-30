package GraphicsLibrary;

/**
 * This class represent the location of PointX and PointY on a screen size of
 * 1920x1080
 *
 */
public class Point {
	public final double xPoint;
	public final double yPoint;
	public int x=1920;
	public int y=1080;

	public Point(double xPoint, double yPoint) throws ScreenException {
		this.xPoint = xPoint;
		this.yPoint = yPoint;
	}

	boolean checkLocation() {
		if (xPoint >= 0 && xPoint <= x && yPoint >= 0 && yPoint <= y) {
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