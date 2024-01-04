package oop;

public class RegularTrack extends Track{
    public RegularTrack(long id, boolean isPremiumRequired) {
        super(id, isPremiumRequired);
    }

    public void likeTrack(LikeService service) {
        // добавляем трэк в избранное на сервер передавая службе LikeService которая добавит трэк.
        service.likeTrack(id);
    }
}
