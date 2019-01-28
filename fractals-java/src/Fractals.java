import java.io.*;

public class Fractals {
	public static void main(String[] args) throws FileNotFoundException {
		Image smoothObj = new Image(200, 100);
		// Set the pixels
		for (int i = 0; i < smoothObj.getHeight(); i++) {
			for (int j = 0; j < smoothObj.getWidth(); j++) {
				smoothObj.setPixel(j,i, new Colour(j/(float)smoothObj.getWidth(), 0, i/(float)smoothObj.getHeight()));
			}
		}

		// Write out the file
		smoothObj.write("smooth.ppm");
	}
}
