package oop;

public class LikedTrack extends Track{
    public LikedTrack(long id, boolean isPremiumRequired) {
        super(id, isPremiumRequired);
    }

    @Override
    public void changeLike(ChangeLike[] services) {
        for(ChangeLike service: services) {
            service.unlikeTrack(id);
        }
    }

}
