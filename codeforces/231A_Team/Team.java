import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;

public class Team implements Runnable {

	BufferedReader in;
	PrintWriter out;
	StringTokenizer tok = new StringTokenizer("");

	public static void main(String[] args) {
		new Thread(null, new Team(), "", 256 * (1L << 20)).start();
	}

	public void run() {
		try {
			long t1 = System.currentTimeMillis();
			if (System.getProperty("ONLINE_JUDGE") != null) {
				in = new BufferedReader(new InputStreamReader(System.in));
				out = new PrintWriter(System.out);
			} else {
				in = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("./input231A.txt")));
				out = new PrintWriter(System.out);
			}
			Locale.setDefault(Locale.US);
			solve();
			in.close();
			out.close();
			long t2 = System.currentTimeMillis();
			System.err.println(System.lineSeparator() + "Time = " + (t2 - t1));
		} catch (Throwable t) {
			t.printStackTrace(System.err);
			System.exit(-1);
		}
	}

	String readString() throws IOException {
		while (!tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine());
		}
		return tok.nextToken();
	}

	int readInt() throws IOException {
		return Integer.parseInt(readString());
	}

	long readLong() throws IOException {
		return Long.parseLong(readString());
	}

	double readDouble() throws IOException {
		return Double.parseDouble(readString());
	}

	// solution
	int sum() throws IOException {
		int sum = 0;
		for (int i = 0; i < 3; i ++) {
			String str = this.readString();
			sum += Integer.parseInt(str);
		}
		return sum;
	}

	void solve() throws IOException {
		int tests = readInt();
		int total = 0;
		for (int i = 0; i < tests; i ++) {
			int sum = sum();
			total += sum >= 2 ? 1 : 0;
		//	System.out.println(totalOps);			
		}
		out.write(String.valueOf(total));
	}

}