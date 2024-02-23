package my_opp;

public abstract class Track {

    protected final long id;

    protected Track(long id) {
        this.id = id;
    }

    public void play(Player player) {
        player.play(id);
    }

    public abstract void changeLike(ChangeLike[] services);
}

interface ChangeLike {
    void likeTrack(long id);
    void unlikeTrack(long id);
}
