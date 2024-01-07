package oop_base_part_four;

public abstract class Fragment<V extends View, T extends Presenter<V>> {
    private T presenter;

    public Fragment(T presenter) {
        this.presenter =presenter;
    }

    public void onResume(V view) {
        presenter.upgradeUi(view);
    }

    public void onPause() {
        presenter.stopUi();
    }
}
