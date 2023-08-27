/*
ID: anandme1
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.*;

class beads {
  private static final String BASE_PATH = "/Users/anandmehrotra/Documents/Interview/competitive_programming/usaco/beads/";
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader(BASE_PATH + "beads.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter( BASE_PATH + "beads.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer st = new StringTokenizer(f.readLine());
    int val = Integer.parseInt(st.nextToken());
    beads beads = new beads();
    out.println(val);  
    out.close();                                  // close the output file
  }
}