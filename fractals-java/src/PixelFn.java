@FunctionalInterface
public interface PixelFn {
	Colour apply(Image img, int x, int y);
}

