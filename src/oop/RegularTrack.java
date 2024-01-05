package oop;

public class RegularTrack extends Track{
    public RegularTrack(long id, boolean isPremiumRequired) {
        super(id, isPremiumRequired);
    }

    public void changeLike(ChangeLike[] services) {
        for(ChangeLike service: services) {
            service.likeTrack(id);
        }
    }
}
