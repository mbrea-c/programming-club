public class Mandelbrot implements ImageFn {
	private final int MAX_ITERATIONS;
	private final int POWER;
	private final double MAX_RADIUS;

	public Mandelbrot() {
		MAX_RADIUS = 2;
		MAX_ITERATIONS = 32;
		POWER = 2;
	}

	public Mandelbrot(int iters, double r, int pow) {
		MAX_RADIUS = r;
		MAX_ITERATIONS = iters;
		POWER = pow;
	}

	public Colour apply(double x, double y) {
		int finalN = iterate(new Complex(0,0), new Complex(x,y), 0);
		double c = (double)finalN / MAX_ITERATIONS;
		return new Colour(c);
	}

	private int iterate(Complex z, Complex c, int n) {
		Complex zn = z.pow(POWER).add(c);
		if (n >= MAX_ITERATIONS) return MAX_ITERATIONS;
		else if (zn.getM() > MAX_RADIUS) return n+1;
		else return iterate(zn, c, n+1);
	}
}
