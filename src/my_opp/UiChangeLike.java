package my_opp;

public class UiChangeLike implements ChangeLike {
    @Override
    public void likeTrack(long id) {
        System.out.println("Like track UI");
    }

    @Override
    public void unlikeTrack(long id) {

    }
}
