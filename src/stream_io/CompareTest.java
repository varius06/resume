package stream_io;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class CompareTest implements Comparable<CompareTest>{
    @Override
    public boolean equals(Object o) {
        CompareTest other = (CompareTest) o;
        if (value != other.value) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
      /*  final int prime = 31;
        int result = 1;
        result = prime * result + value;
        return result;*/
        return 0;
    }

    private int value;

    public CompareTest(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public int compareTo(CompareTest o) {
        return value - o.value;
    }



    public static void main(String[] args) {
        CompareTest test1 = new CompareTest(20);
        CompareTest test2 = new CompareTest(20);
        System.out.println(test2.compareTo(test1));
        System.out.println(test2.equals(test1));
        Set<CompareTest> set1 = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            set1.add(new CompareTest(i));
        }
        System.out.println(set1);
        set1 = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            set1.add(new CompareTest(i));
        }
        System.out.println(set1.contains(new CompareTest(9)));
        System.out.println(set1);
    }
}
