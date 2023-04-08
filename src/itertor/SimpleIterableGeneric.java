package itertor;

import java.util.Iterator;

public class SimpleIterableGeneric<T> implements Iterable<T>{
    @Override
    public Iterator iterator() {
        return new ArrayIterator<>(new String[] {"Generic1","Generic2","Generic3"});
    }
}
