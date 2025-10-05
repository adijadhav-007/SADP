import java.util.*;

class EnumerationIteratorAdapter implements Iterator<Object> {
    private Enumeration<?> enumeration;

    public EnumerationIteratorAdapter(Enumeration<?> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public Object next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {

        throw new UnsupportedOperationException("Remove not supported.");
    }
}

public class AdapterPatternDemo {
    public static void main(String[] args) {

        Vector<String> vector = new Vector<>();
        vector.add("Java");
        vector.add("Python");
        vector.add("C++");


        Enumeration<String> enumeration = vector.elements();

        Iterator<Object> iterator = new EnumerationIteratorAdapter(enumeration);

        System.out.println("Elements using Iterator (adapted from Enumeration):");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

