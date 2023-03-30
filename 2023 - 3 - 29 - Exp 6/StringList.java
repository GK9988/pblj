import java.util.*;

public class StringList {
    public static void main(String args[]) {
        // Add operation
        List<String> strList = new ArrayList<String>();
        List<Number> intList = new ArrayList<Number>();
        strList.add("One");
        strList.add("Two");
        strList.add("Three");
        strList.add("Four");
        intList.add(1234);
        intList.add(5678);
        intList.add(1122);
        intList.add(2233);
        System.out.println(strList);
        System.out.println(intList);

        String strElement = strList.get(1);
        Number numberElement = intList.get(2);
        System.out.println("Element at index 1 in the strList: " + strElement);
        System.out.println("Element at index 2 in the intList: " + numberElement);

        // Search operation
        if (strList.contains("Hello")) {
            System.out.println("Found the element");
        } else {
            System.out.println("There is no such element");
        }
        int numberIndex = intList.indexOf(1234);
        int strIndex = strList.indexOf("Two");

        System.out.println("Index of Two in the strList: " + strIndex);
        System.out.println("Index of 1234 in the intList: " + numberIndex);

        // Remove operation
        strList.remove(2);
        strList.remove("Two");
        if (strList.remove("Ten")) {
            System.out.println("Removed");
        } else {
            System.out.println("There is no such element");
        }

    }
}
