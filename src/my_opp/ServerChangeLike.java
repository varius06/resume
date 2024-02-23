package my_opp;

public class ServerChangeLike implements ChangeLike{
    @Override
    public void likeTrack(long id) {
        System.out.println("Like track server");
    }

    @Override
    public void unlikeTrack(long id) {

    }
}
