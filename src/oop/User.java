package oop;

public abstract class User {

    public abstract void play(long id, boolean isPremiumRequired);

    public static class Premium extends User{
        private final Player player;

        public Premium(Player player) {
            this.player = player;
        }

        @Override
        public void play(long id, boolean isPremiumRequired) {
            player.play(id);
        }
    }

    public static class Regular extends User{

        private final Player player;

        public Regular(Player player) {
            this.player = player;
        }

        @Override
        public void play(long id, boolean isPremiumRequired) {
            if (isPremiumRequired) {

            } else {
                player.play(id);
            }
        }
    }
}
