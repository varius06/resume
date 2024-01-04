package oop;

public class LikedTrack extends Track{
    public LikedTrack(long id, boolean isPremiumRequired) {
        super(id, isPremiumRequired);
    }

    public void unlike(LikeService likeService) {
        // ������� ���� �� ���������� �� ������� ��������� ������ LikeService ������� ������ ����.
        likeService.unlikeTrack(id);
    }
}
