import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
//Use a comparator to sort accounts by last name.

import java.util.*;
//Compare last whole words in two strings.
class TComp implements Comparator<String>
{
    public int compare(String a, String b){
        int i,j,k;
        String aStr, bStr;
        aStr=a;
        bStr=b;
        //Find index of beginning of last name.
        i=aStr.lastIndexOf(' ');
        j=bStr.lastIndexOf(' ');
        k=aStr.substring(i).compareTo(bStr.substring(j));
        if(k==0) //last names match, check entire name.
            return aStr.compareTo(bStr);
        else
            return k;
    }
    //No need to override equals.
}
public class TreeMapDemo{
    public static void main(String[] args) {
        //Create a tree map.
        TreeMap<String, Double> tm= new TreeMap<String, Double>(new TComp());
        //Put elements to the map.
        tm.put("A",new Double(3434.34));
        tm.put("B",new Double(123.22));
        tm.put("C",new Double(1378.00));
        tm.put("D",new Double(99.22));
        tm.put("E",new Double(-19.08));
        //Get a set of the strategies.
        Set<Map.Entry<String, Double>> set =tm.entrySet();
        //Display the elements.
        for(Map.Entry<String, Double> me : set){
            System.out.println(me.getKey()+": ");
            System.out.println(me.getValue());
        }
        System.out.println();
        //Deposit 1000 into A's account.
        double balance=tm.get("A");
        tm.put("A",balance+1000);
        System.out.println("A's new balance: "+tm.get("A"));
    }
}
