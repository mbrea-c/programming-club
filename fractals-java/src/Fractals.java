import java.io.*;

class Fractals {
	public static void main(String[] args) throws FileNotFoundException {
		// Image width and height in pixels
		int HEIGHT = 10;
		int WIDTH  = 10;

		// Pixel arrays
		float[] red   = new float[HEIGHT*WIDTH];
		float[] green = new float[HEIGHT*WIDTH];
		float[] blue  = new float[HEIGHT*WIDTH];

		// Print to file
		PrintStream ps = new PrintStream("test.ppm");
		ps.close();
	}
}
