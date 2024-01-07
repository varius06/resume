package oop_base_part_four;

public class Screen1Presenter extends Presenter<Screen1View>{

    @Override
    public void upgradeUi(Screen1View view) {
        super.upgradeUi(view);
        super.view.goToScreen2();
    }
}
