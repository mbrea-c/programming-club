import java.io.*;

class Fractals {
	public static void main(String[] args) throws FileNotFoundException {
		PrintStream ps = new PrintStream("hello.txt");
		ps.println("yea that worked");
		ps.close();
	}
}
