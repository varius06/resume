package oop_base_part_four;

public abstract class Presenter<V extends View> {
    protected V view;
    public void upgradeUi(V view) {
        this.view = view;
    }

    public void stopUi() {
        this.view = null;
    }
}
