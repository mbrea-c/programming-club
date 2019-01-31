import java.io.*;

public class Image {
	// Image width and height in pixels
	private final int HEIGHT;
	private final int WIDTH;

	// Pixel arrays
	private Colour[] pix;

	public Image(int width, int height) {
		if (width <= 0)  throw new IllegalArgumentException("width must be a positive integer");
		if (height <= 0) throw new IllegalArgumentException("height must be a positive integer");

		HEIGHT = height;
		WIDTH  = width;

		pix = new Colour[HEIGHT*WIDTH];

		for (int i = 0; i < HEIGHT*WIDTH; i++) pix[i] = Colour.BLACK;
	}

	public Image(int width, int height, PixelFn f) {
		if (width <= 0)  throw new IllegalArgumentException("width must be a positive integer");
		if (height <= 0) throw new IllegalArgumentException("height must be a positive integer");

		HEIGHT = height;
		WIDTH  = width;

		pix = new Colour[HEIGHT*WIDTH];
		fill(f);
	}

	public Image(int width, int height, ImageFn f, Rectangle rect) {
		if (width <= 0)  throw new IllegalArgumentException("width must be a positive integer");
		if (height <= 0) throw new IllegalArgumentException("height must be a positive integer");

		HEIGHT = height;
		WIDTH  = width;

		pix = new Colour[HEIGHT*WIDTH];
		fill(f, rect);
	}


	/**
	 * Getter for HEIGHT
	 */
	public int getHeight() {
		return HEIGHT;
	}

	/**
	 * Getter for WIDTH
	 */
	public int getWidth() {
		return WIDTH;
	}

	public Colour getPixel(int x, int y) {
		if (x < 0 || x >= WIDTH ) throw new IllegalArgumentException("x is out of range");
		if (y < 0 || y >= HEIGHT) throw new IllegalArgumentException("y is out of range");

		return pix[x + y*WIDTH];
	}

	public void setPixel(int x, int y, Colour colour) {
		if (x < 0 || x >= WIDTH ) throw new IllegalArgumentException("x is out of range");
		if (y < 0 || y >= HEIGHT) throw new IllegalArgumentException("y is out of range");
		if (colour == null) throw new IllegalArgumentException("Cannot set pixel to null");

		int i = x + y*WIDTH;
		pix[i] = colour;
	}
	
	public void fill(PixelFn f) {
		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				setPixel(x, y, f.apply(this, x, y));
			}
		}
	}

	public void fill(ImageFn f, Rectangle rectangle) {
		for (int y = 0; y < HEIGHT; y++) {
			double fh = rectangle.getBottom() - rectangle.getTop();
			double fy = rectangle.getTop() + y * fh / HEIGHT;
			for (int x = 0; x < WIDTH; x++) {
				double fw = rectangle.getRight() - rectangle.getLeft();
				double fx = rectangle.getLeft() + x * fw / WIDTH;
				setPixel(x, y, f.apply(fx, fy));
			}
		}
	}

	public void write(String filename) throws FileNotFoundException {
		PrintStream ps = new PrintStream(filename);
		write(ps);
		ps.close();
	}

	public void write(PrintStream ps) {
		ps.println("P3");
		ps.printf("%d %d\n255\n", WIDTH, HEIGHT);

		for (int i = 0; i < HEIGHT*WIDTH; i++) {
			ps.printf("%d %d %d ",  colourToInt(pix[i].getR()),
			                        colourToInt(pix[i].getG()),
			                        colourToInt(pix[i].getB())
			);
		}
		ps.printf("\n");
	}

	private int colourToInt(double c) {
		if ((c < 0.0f) || (c > 1.0f)) throw new IllegalArgumentException("c is out of range");
		return (int) (c*255);
	}

}
