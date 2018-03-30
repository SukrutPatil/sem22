package Example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class newq {
	public static void main( String [] args) {
		
List <String> testlist =new ArrayList();
testlist.add("a");
testlist.add("x");
testlist.add("b");
testlist.add("s");
testlist.add("d");
Collections.sort(testlist);
System.out.println("Sorted arraylist for string:" + testlist);
Collections.reverse(testlist);
System.out.println("Sorted reverse arraylist for string:" + testlist);
List <Double> testlist1 = new ArrayList();
testlist1.add(0.5);
testlist1.add(1.6);
testlist1.add(0.7);
testlist1.add(0.77);
Collections.sort(testlist1);
System.out.println("Sorted arraylist for double:" + testlist1);
Collections.reverse(testlist1);
System.out.println("Sorted reverse arraylist for double:"+ testlist1);
List <Float> testlist2 = new ArrayList();
testlist2.add(0.66F);
testlist2.add(0.65F);
testlist2.add(0.61F);
testlist2.add(0.62F);
Collections.sort(testlist2);
System.out.println("Sorted arraylist for float:" + testlist1);
Collections.reverse(testlist2);
System.out.println("Sorted reverse arraylist for float:"+ testlist1);
}
}


