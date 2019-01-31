import java.io.*;

public class Fractals {
	public static void main(String[] args) throws FileNotFoundException {
		Complex z = new Complex(0, 0).pow(2);
		System.out.printf("%f %f %f %f\n", z.getR(), z.getI(), z.getM(), z.getA());
		Image smoothObj = new Image(300, 300, new Mandelbrot(32, 2, 2),
		                            new Rectangle(-2,1,-1.5,1.5)
		);
		// Write out the file
		smoothObj.write("smooth.ppm");
	}
}
