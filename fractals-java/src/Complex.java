public class Complex {
	final private double real;
	final private double imaginary;
	final private double modulus;
	final private double argument;

	public static Complex fromPolar(double mod, double arg) {
		double real = mod*Math.cos(arg);
		double imag = mod*Math.sin(arg);

		return new Complex(real, imag);
	}

	public Complex(double r, double i) {
		real      = r;
		imaginary = i;
		modulus   = Math.sqrt(real*real + imaginary*imaginary);


		//TODO: Improve calculation of argument. There has to be a more elegant way.
		if (real == 0 && imaginary > 0)
			argument = Math.PI / 2;
		else if (real == 0 && imaginary < 0)
			argument = -Math.PI / 2;
		else if (real < 0 && imaginary == 0)
			argument = -Math.PI;
		else if (real == 0 && imaginary == 0)
			argument = 0;
		else if (real > 0 && imaginary >= 0)
			argument = Math.atan(imaginary/real);
		else if (real > 0 && imaginary <= 0) 
			argument = -Math.atan(Math.abs(imaginary/real));
		else if (real < 0 && imaginary >= 0)
			argument = Math.PI - Math.atan(Math.abs(imaginary/real));
		else 
			argument = -Math.PI + Math.atan(Math.abs(imaginary/real));
	}

	public double getR() {
		return real;
	}

	public double getI() {
		return imaginary;
	}

	public double getM() {
		return modulus;
	}

	public double getA() {
		return argument;
	}

	public Complex add(Complex z) {
		return new Complex(z.getR() + real, z.getI() + imaginary);
	}

	public Complex pow(int exp) {
		return fromPolar(Math.pow(modulus, exp), exp*argument);
	}
}
		

