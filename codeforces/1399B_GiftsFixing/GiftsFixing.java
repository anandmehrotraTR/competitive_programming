import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;

public class GiftsFixing implements Runnable {

	BufferedReader in;
	PrintWriter out;
	StringTokenizer tok = new StringTokenizer("");

	public static void main(String[] args) {
		new Thread(null, new GiftsFixing(), "", 256 * (1L << 20)).start();
	}

	public void run() {
		try {
			long t1 = System.currentTimeMillis();
			if (System.getProperty("ONLINE_JUDGE") != null) {
				in = new BufferedReader(new InputStreamReader(System.in));
				out = new PrintWriter(System.out);
			} else {
				in = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("./inputA.txt")));
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
	long[] createArray(int count) throws IOException {
		long[] a = new long[count];
		for (int i = 0; i < count; i ++) {
			a[i] = Long.parseLong(this.readString());
		}
		return a;
	}

	void solve() throws IOException {
		int tests = readInt();
		for (int i = 0; i < tests; i ++) {
			int count = readInt();
			long[] a = createArray(count);
			long[] b = createArray(count);
			long minA = Arrays.stream(a).min().getAsLong(), minB = Arrays.stream(b).min().getAsLong();
			long totalOps = 0;
			for (int idx = 0; idx < count; idx++) {
				totalOps += Math.max(a[idx] - minA, b[idx] - minB);
			}
		//	System.out.println(totalOps);			
			out.write(String.valueOf(totalOps));
			out.write(System.lineSeparator());
		}
	}

}