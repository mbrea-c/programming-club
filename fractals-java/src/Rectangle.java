public class Rectangle {
	private final double LEFT;
	private final double RIGHT;
	private final double TOP;
	private final double BOTTOM;

	public Rectangle(double left, double right, double top, double bottom) {
		LEFT   = left;
		RIGHT  = right;
		TOP    = top;
		BOTTOM = bottom;
	}

	public double getBottom() {
		return BOTTOM;
	}

	public double getTop() {
		return TOP;
	}

	public double getLeft() {
		return LEFT;
	}

	public double getRight() {
		return RIGHT;
	}
}
