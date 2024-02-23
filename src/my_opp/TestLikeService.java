package my_opp;

public class TestLikeService {

    public static  void  main(String [] args) {
        ChangeLike[] changeLikes = new ChangeLike[2];
        ServerChangeLike serverChangeLike = new ServerChangeLike();
        UiChangeLike uiChangeLike = new UiChangeLike();
        changeLikes[0] = serverChangeLike;
        changeLikes[1] = uiChangeLike;
        Track likedTrack = new LikedTrack(1);
        likedTrack.changeLike(changeLikes);
        Player player = new Player();
        User premiumUser = new User.Premium(player);
        premiumUser.play(2, true);
    }

}
