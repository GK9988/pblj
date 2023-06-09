// (b) Create a program to show the usage of Sets of Collection interface.

package com.javacodegeeks.core.set;

import java.util.*;

public class SetExample {

    public static void main(String args[]) {

        Hashtable ht = new Hashtable();
        ht.put("1", "One");
        ht.put("2", "Two");
        ht.put("3", "Three");
        Enumeration e = ht.keys();
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }

        // We create a new, empty set
        Set mySet1 = new HashSet();
        // We add a few elements
        mySet1.add("A");
        mySet1.add("C");
        mySet1.add("A");
        mySet1.add("B");
        // Print the elements of the Set
        System.out.println("mySet1: " + mySet1);

        // Create a list and add some elements
        List list = new ArrayList();
        list.add("A");
        list.add("C");
        list.add("A");
        list.add("A");
        list.add("B");
        list.add("C");
        // Now create the set using the appropriate constructor
        Set mySet2 = new HashSet(list);
        // Print the elements of the list an the the set
        System.out.println("list: " + list);
        System.out.println("mySet2: " + mySet2);

        // Compare the two sets
        System.out.println("MySet1 matches mySet2: " + mySet1.equals(mySet2));

        // Now we will remove one element from mySet2 and compare again
        mySet2.remove("A");
        System.out.println("mySet2: " + mySet2);
        System.out.println("MySet1 matches mySet2: " + mySet1.equals(mySet2));

        // Lets check if our sets contain all the elements of thes list
        System.out.println("MySet1 contains all the elements: " + mySet1.containsAll(list));
        System.out.println("MySet2 contains all the elements: " + mySet2.containsAll(list));

        // Use of Iterator in Set
        Iterator iterator = mySet1.iterator();
        while (iterator.hasNext()) {
            System.out.println("Iterator loop: " + iterator.next());
        }

        // Clearing all the elements
        mySet1.clear();
        System.out.println("mySet1 is Empty: " + mySet1.isEmpty());

        // Checking the number of elements
        System.out.println("mySet1 has: " + mySet1.size() + " Elements");
        System.out.println("mySet2 has: " + mySet2.size() + " Elements");

    }
}
