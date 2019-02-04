import java.io.*;

public class Image {
	// Image width and height in pixels
	private final int h;
	private final int w;

	// Pixel arrays
	private Colour[] pix;

	public Image(int width, int height) {
		if (width <= 0)  throw new IllegalArgumentException("width must be a positive integer");
		if (height <= 0) throw new IllegalArgumentException("height must be a positive integer");

		h = height;
		w  = width;

		pix = new Colour[h*w];

		for (int i = 0; i < h*w; i++) pix[i] = Colour.BLACK;
	}

	public Image(int width, int height, PixelFn f) {
		if (width <= 0)  throw new IllegalArgumentException("width must be a positive integer");
		if (height <= 0) throw new IllegalArgumentException("height must be a positive integer");

		h = height;
		w  = width;

		pix = new Colour[h*w];
		fill(f);
	}

	public Image(int width, int height, ImageFn f, Rectangle rect) {
		if (width <= 0)  throw new IllegalArgumentException("width must be a positive integer");
		if (height <= 0) throw new IllegalArgumentException("height must be a positive integer");

		h = height;
		w  = width;

		pix = new Colour[h*w];
		fill(f, rect);
	}


	/**
	 * Getter for h
	 */
	public int getHeight() {
		return h;
	}

	/**
	 * Getter for w
	 */
	public int getWidth() {
		return w;
	}

	public Colour getPixel(int x, int y) {
		if (x < 0 || x >= w ) throw new IllegalArgumentException("x is out of range");
		if (y < 0 || y >= h) throw new IllegalArgumentException("y is out of range");

		return pix[x + y*w];
	}

	public void setPixel(int x, int y, Colour colour) {
		if (x < 0 || x >= w ) throw new IllegalArgumentException("x is out of range");
		if (y < 0 || y >= h) throw new IllegalArgumentException("y is out of range");
		if (colour == null) throw new IllegalArgumentException("Cannot set pixel to null");

		int i = x + y*w;
		pix[i] = colour;
	}
	
	public void fill(PixelFn f) {
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				setPixel(x, y, f.apply(this, x, y));
			}
		}
	}

	public void fill(ImageFn f, Rectangle rectangle) {
		for (int y = 0; y < h; y++) {
			double fh = rectangle.getBottom() - rectangle.getTop();
			double fy = rectangle.getTop() + y * fh / h;
			for (int x = 0; x < w; x++) {
				double fw = rectangle.getRight() - rectangle.getLeft();
				double fx = rectangle.getLeft() + x * fw / w;
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
		ps.printf("%d %d\n255\n", w, h);

		for (int i = 0; i < h*w; i++) {
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
