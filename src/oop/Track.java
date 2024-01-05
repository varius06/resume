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

    public abstract void changeLike(ChangeLike[] service);
}

class LikeService extends CloudDateSource implements ChangeLike{

    @Override
    public void likeTrack(long id) {

    }

    @Override
    public void unlikeTrack(long id) {

    }
}

class Ui implements ChangeLike{

    @Override
    public void likeTrack(long id) {

    }

    @Override
    public void unlikeTrack(long id) {

    }
}

abstract class CloudDateSource {

}

class Player {
    void play(long id) {

    }
}

interface ChangeLike {
    void likeTrack(long id);
    void unlikeTrack(long id);
}
