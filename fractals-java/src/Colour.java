public class Colour {
	public static final Colour BLACK = new Colour(0,0,0);
	public static final Colour WHITE = new Colour(1,1,1);
	public static final Colour RED   = new Colour(1,0,0);

	private final double r;
	private final double g;
	private final double b;

	public Colour(double r, double g, double b) {
		if ((r < 0.0f) || (r > 1.0f)) throw new IllegalArgumentException("r is out of range");
		if ((g < 0.0f) || (g > 1.0f)) throw new IllegalArgumentException("g is out of range");
		if ((b < 0.0f) || (b > 1.0f)) throw new IllegalArgumentException("b is out of range");

		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	// Constructor for grayscale colors
	public Colour(double c) {
		this(c,c,c);
	}

	public double getR() {
		return r;
	}

	public double getG() {
		return g;
	}
	
	public double getB() {
		return b;
	}
}
