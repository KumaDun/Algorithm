import java.util.Comparator;

public class AnagramCompare implements Comparable {
    public static void main(String[] args) {
        System.out.println("a".compareTo("b"));
        System.out.println("a");
        System.out.println('0');
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
