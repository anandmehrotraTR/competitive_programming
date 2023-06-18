/*
ID: anandme1
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.*;

class friday {
  enum Month {
    JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC;
    int getDaysPerMonth(int year) {
      switch(this) {
        case FEB:
          return year % 100 == 0 ? year % 400 == 0 ? 29 : 28 : year % 4 == 0 ? 29: 28;
        case APR:
        case JUN:
        case SEP:          
        case NOV:
          return 30;
        default:
          return 31;
      }
    }
    Month getOneMonthBefore() {
      return Month.values()[(12 + this.ordinal() - 1) % 12];
    }
  };
  enum Day {
    SAT, SUN, MON, TUE, WED, THURS, FRI,;
    Day getDaysAfter(int count) {
      return Day.values()[(7 + this.ordinal() + count) % 7];
    }
  }

  private Map<Day, Integer> compute(int n) {
    Map<Day, Integer>  values = new TreeMap<>();
    Day l_13_day = Day.WED;
    for (int i = 1900; i < 1900 + n; i++) {
      //int l_13_day = Day.WED.ordinal();      
      for (Month month : Month.values()) {        
          l_13_day = l_13_day.getDaysAfter(month.getOneMonthBefore().getDaysPerMonth(i));          
          values.put(l_13_day, values.getOrDefault(l_13_day, 0) + 1);
        }
    }

    return values;
  }


  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("friday.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer st = new StringTokenizer(f.readLine());
    beads friday = new beads();
  
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