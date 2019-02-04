public class Mandelbrot implements ImageFn {
	private final int maxIterations;
	private final int exponent;
	private final double maxRadius;

	public Mandelbrot() {
		maxRadius = 2;
		maxIterations = 32;
		exponent = 2;
	}

	public Mandelbrot(int iters, double r, int pow) {
		maxRadius = r;
		maxIterations = iters;
		exponent = pow;
	}

	public Colour apply(double x, double y) {
		int finalN = iterate(new Complex(0,0), new Complex(x,y), 0);
		double c = (double)finalN / maxIterations;
		return new Colour(c);
	}

	private int iterate(Complex z, Complex c, int n) {
		Complex zn = z.pow(exponent).add(c);
		if (n >= maxIterations) return maxIterations;
		else if (zn.getM() > maxRadius) return n+1;
		else return iterate(zn, c, n+1);
	}
}
