package devstudy_generic_lesson4;

public class Stack<T> extends DataStructure<T> {

    public Stack() {
        super(new DynaArray<T>());
    }

    public Stack(DynaArray<T> dataSet) {
        super(dataSet);
    }

    @Override
    protected final int getCurrentIndex() {
        return size() - 1;
    }

    @Override
    protected Object[] toArray() {
        Object[] array = new Object[dataSet.size()];
        for (int i = 0; i < dataSet.size(); i++) {
            array[i] = dataSet.get(dataSet.size() - 1 - i);
        }
        return array;
    }
}
