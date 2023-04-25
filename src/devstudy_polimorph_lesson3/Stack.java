package devstudy_polimorph_lesson3;

public class Stack extends DataStructure {

    public Stack() {
        super(new DynaArray());
    }

    @Override
    protected final int getCurrentIndex() {
        return size() - 1;
    }

    @Override
    protected int[] toArray() {
        int[] array = new int[dataSet.size()];
        for (int i = 0; i < dataSet.size(); i++) {
            array[i] = dataSet.get(dataSet.size() - 1 - i);
        }
        return array;
    }
}
