package ua.com.alevel.model;

public enum FileType {

    TXT("txt");

    private final String type;

    FileType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
