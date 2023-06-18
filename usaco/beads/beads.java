/*
ID: anandme1
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.*;

class beads {


  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("friday.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer st = new StringTokenizer(f.readLine());
    friday friday = new friday();
  
    Map<Day, Integer> ans = friday.compute(Integer.parseInt(st.nextToken()));
    StringBuilder str = new StringBuilder();
    for(Day day : Day.values()) {
      str.append(ans.get(day));
      str.append(" ");
    }
    out.println(str.length() > 0 ? str.substring(0, str.length() - 1) : "");  
    out.close();                                  // close the output file
  }
}