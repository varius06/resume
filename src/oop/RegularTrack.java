package oop;

public class RegularTrack extends Track{
    public RegularTrack(long id, boolean isPremiumRequired) {
        super(id, isPremiumRequired);
    }

    public void likeTrack(LikeService service) {
        // ��������� ���� � ��������� �� ������ ��������� ������ LikeService ������� ������� ����.
        service.likeTrack(id);
    }
}
