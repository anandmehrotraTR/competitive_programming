/*
ID: anandme1
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.*;

class beads {

  private int findLen(String str) {
    int maxLen = 0;
    
    for(int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        int j = i + 1;

        int oldLen = findSimilar(str, i, c, j, 1);
        if (oldLen == str.length()) {
          return oldLen;
        }
        j = (i + oldLen) % str.length();
        c = str.charAt(j);
        int len = findSimilar(str, i, c, j + 1, 1);
        maxLen = Math.max(oldLen + len, maxLen);
    }
    return maxLen;
  }
  private int findSimilar(String str, int i, char c, int j, int len) {
    while (j % str.length() != i) {
       if (str.charAt(j % str.length()) == 'w' || c == 'w' || c == str.charAt(j % str.length())) {
          len++;
          c = str.charAt(j % str.length()) == 'w' ? c : str.charAt(j % str.length());
       } else {
        break;
       }
       j++;
    }
    return len;
  }
  private static String BASE_PATH = "/Users/anandmehrotra/Documents/Interview/competitive_programming/usaco/beads/";
  public static void main (String [] args) throws IOException {
    BASE_PATH = "";
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader(BASE_PATH + "beads.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter( BASE_PATH + "beads.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer st = new StringTokenizer(f.readLine());
    int val = Integer.parseInt(st.nextToken());
    String str = f.readLine();
    beads beads = new beads();
    int ans  = beads.findLen(str);
    // System.out.println(ans);
    out.println(ans);  
    out.close();                                  // close the output file
  }
}