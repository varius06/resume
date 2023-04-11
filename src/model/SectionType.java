package model;

public enum SectionType {
    PERSONAL("������ ��������"),
    OBJECTIVE("�������"),
    ACHIEVEMENT("����������"),
    QUALIFICATIONS("������������"),
    EXPERIENCE("���� ������"),
    EDUCATION("�����������");

    private String title;

    SectionType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
