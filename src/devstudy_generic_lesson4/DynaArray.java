package devstudy_generic_lesson4;

import java.util.Arrays;

public class DynaArray<E> extends DataSet<E>{
    private E[] array;

    public DynaArray() {
        array = (E[]) new Object[10];
    }

    public DynaArray(E[] array) {
        super();
        this.array = array;
        this.size = array.length;
    }

    public void add(E element) {
        if (size == array.length) {
            E[] temp = array;
            array = (E[]) new Object[temp.length * 2];
            for (int i = 0; i < temp.length; i++) {
                array[i] = temp[i];
            }
        }
        array[size++] = element;
    }

    @Override
    public E remove(int index) {
        if (index < size) {
            E value = array[index];
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            array[--size] = null;
            return value;
        }
        return null;
    }

    @Override
    public E get(int index) {
        if(index < size) {
            return array[index];
        } else {
            return null;
        }
    }

    @Override
    public void clear() {
        super.clear();
        array = (E[]) new Object[10];
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }
}
