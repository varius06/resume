package oop;

public abstract class Track {

    protected final long id;
    protected final boolean isPremiumRequired;

    public Track(long id, boolean isPremiumRequired) {
        this.id = id;
        this.isPremiumRequired = isPremiumRequired;
    }

    public void play(Player player) {
        player.play(id);
    }
}

class LikeService {
   /* 1. public void changeLike(boolean isLiked) {
    }*/
    public void likeTrack(long id) {

    }

    public void unlikeTrack(long id) {

    }
}

class Ui{
    public void likeTrack(long id) {

    }

    public void unlikeTrack(long id) {

    }
}

class Player {
    void play(long id) {

    }
}

