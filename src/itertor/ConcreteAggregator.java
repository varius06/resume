package itertor;

public class ConcreteAggregator implements Aggregate{
    String[] task = {"Копать", "Рубить", "Варить"};

    @Override
    public Iterator getIterator() {
        return new TaskIterator();
    }

    private class TaskIterator implements Iterator{
        int index = 0;

        @Override
        public boolean hasNext() {
            if(index < task.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            return task[index++];
        }
    }
}
