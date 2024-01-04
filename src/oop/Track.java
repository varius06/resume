package oop;

public class Track {

    private  boolean isLiked;
    private final long id;

    public Track(boolean isLiked, long id) {
        this.isLiked = isLiked;
        this.id = id;
    }

    public void changeLiked(LikeService service, Ui ui) {
/*        1. service.changeLike(isLiked);*/
        if(isLiked) {
            service.likeTrack(id);
            ui.likeTrack(id);

        } else {
            service.unlikeTrack(id);
            ui.unlikeTrack(id);
        }

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

