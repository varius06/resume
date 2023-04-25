package generic;

import java.util.Arrays;

public abstract class Data<E>{

    protected int size;

    public Data() {
        size = 0;
    }

    public final int size() {
        return size;
    }

    public void clear() {
        size = 0;
    }

    public abstract void add(E element);

    public abstract E get(int index);

    public abstract E remove(int index);

    public abstract Object[] toArray();

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
