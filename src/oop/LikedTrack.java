package oop;

public class LikedTrack extends Track{
    public LikedTrack(long id, boolean isPremiumRequired) {
        super(id, isPremiumRequired);
    }

    public void unlike(LikeService likeService) {
        // удаляем трэк из избранного на сервере передавая службе LikeService которая удалит трэк.
        likeService.unlikeTrack(id);
    }
}
