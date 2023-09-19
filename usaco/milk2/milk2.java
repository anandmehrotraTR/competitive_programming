/*
ID: anandme1
LANG: JAVA
TASK: milk2
*/
import java.io.*;
import java.util.*;

class milk2 {

  private int[] compute(List<int[]> intervals) {
    int[] ans = new int[2];
    intervals.sort((a, b) -> a[0] - b[0]);
    int[] lastInterval = intervals.get(0);
    for (int[] interval : intervals) {
      boolean areDistinct = interval[0] > lastInterval[1];
      if (areDistinct) {
        ans[1] = Math.max(ans[1], interval[0] - lastInterval[1]);
        lastInterval = interval;
      } else {
        lastInterval[1] = Math.max(interval[1], lastInterval[1]);
      }
      ans[0] = Math.max(ans[0], lastInterval[1] - lastInterval[0]);
    }

    return ans;
  }
  private static String BASE_PATH = "/Users/anandmehrotra/Documents/Interview/competitive_programming/usaco/milk2/";
  private static String INP_FILE = "milk2.in";
  private static String OTPT_FILE = "milk2.out";
  public static void main (String [] args) throws IOException {
    BASE_PATH = "";
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader(BASE_PATH + INP_FILE));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter( BASE_PATH + OTPT_FILE)));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer st = new StringTokenizer(f.readLine());
    int val = Integer.parseInt(st.nextToken());
    List<int[]> intervals = new ArrayList<>();

    for (int i = 0; i < val; i++) {
        String[] inp = f.readLine().split("\\s+");
        intervals.add(new int[] {Integer.parseInt(inp[0]), Integer.parseInt(inp[1])});
    }

    int[] ans = new milk2().compute(intervals);
    out.println(String.format("%d %d", ans[0], ans[1]));  
    out.close();                                  // close the output file
  }
}