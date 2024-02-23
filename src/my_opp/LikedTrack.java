package my_opp;

public class LikedTrack extends Track{
    protected LikedTrack(long id) {
        super(id);
    }

    @Override
    public void changeLike(ChangeLike[] services) {
        for (ChangeLike service: services) {
            service.likeTrack(id);
        }
    }
}
