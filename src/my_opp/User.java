package my_opp;

public abstract class User {
    abstract void play(long id, boolean isPremium);

    public static class Premium extends User{
        private Player player;

        public Premium(Player player) {
            this.player = player;
        }

        @Override
        void play(long id, boolean isPremium) {
            player.play(id);
        }
    }

    public static class RegularUser extends User{
        private Player player;

        public RegularUser(Player player) {
            this.player = player;
        }

        @Override
        void play(long id, boolean isPremium) {
            if(isPremium) {

            } else {
                player.play(id);
            }
        }
    }
}
