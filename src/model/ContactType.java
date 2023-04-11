package model;

public enum ContactType {
    PHONE("���."),
    MOBILE("���������"),
    HOME_PHONE("�������� ���."),
    SKYPE("Skype"),
    MAIL("�����"),
    LINKEDIN("������� LinkedIn"),
    GITHUB("������� GitHub"),
    STATCKOVERFLOW("������� Stackoverflow"),
    HOME_PAGE("�������� ��������");

    private final String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
