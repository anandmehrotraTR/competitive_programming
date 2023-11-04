import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;

public class DominoPiling implements Runnable {

	BufferedReader in;
	PrintWriter out;
	StringTokenizer tok = new StringTokenizer("");

	public static void main(String[] args) {
		new Thread(null, new DominoPiling(), "", 256 * (1L << 20)).start();
	}

	public void run() {
		try {
			long t1 = System.currentTimeMillis();
			if (System.getProperty("ONLINE_JUDGE") != null) {
				in = new BufferedReader(new InputStreamReader(System.in));
				out = new PrintWriter(System.out);
			} else {
				in = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("./input50A.txt")));
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
	int helper(int i, int j, int m, int n) throws IOException {
		if(!isValid(i, j, m, n)) { return 0;}
		int v1 = 0;
		int v2 = 0;
		int ans = 0;
		if (isValid(i + 1, j, m, n) || isValid(i, j + 1, m, n)) {
			ans =  1 + Math.max(helper(i + 2, j, m, n), helper(i, j + 2, m, n));
		} 
		return ans;
	}

	private boolean isValid(int i, int j, int m, int n) {
		return i >= 0 && j >= 0 && i < m && j < n;
	}

	void solve() throws IOException {
		int n = this.readInt();
		int k = this.readInt();
		int count = helper(0, 0, n, k);
		out.write(String.valueOf(count));
	}

}