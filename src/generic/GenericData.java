package generic;

import java.util.Arrays;

public class GenericData<E>{

    private E[] value =(E[]) new Object[3];
    public static <T> Data<T> newDataSet(T[] array) {
        Data<T> dt = new Data<T>() {
            {
                size = array.length;
            }

            @Override
            public void add(T element) {
            }

            @Override
            public T get(int index) {
                if (index >= 0 && index < array.length) {
                    return array[index];
                }
                return null;
            }

            @Override
            public T remove(int index) {
                return null;
            }

            @Override
            public void clear() {

            }

            @Override
            public Object[] toArray() {
                return (T[]) Arrays.copyOf(array, size);
            }
        };
        return dt;
    }

    public <T> Data<T> processing(T... elements) {
        T[] array = (T[]) new Object[elements.length];
        System.arraycopy(elements, 0, array, 0, elements.length);
        value = (E[]) array;
        return newDataSet(array);
    }

    public void setValue(E... element){
        value = element;
    }

    public E[] getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Arrays.toString((Arrays.copyOf(value, value.length)));
    }
}
