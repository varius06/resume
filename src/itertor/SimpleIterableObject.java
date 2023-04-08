package itertor;

import java.util.Iterator;

public class SimpleIterableObject implements Iterable{
    @Override
    public Iterator iterator() {
        return new ArrayIterator<>(new String[] {"Object1","Object2","Object3"});
    }
}
