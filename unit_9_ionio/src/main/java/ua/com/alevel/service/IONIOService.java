package ua.com.alevel.service;

import ua.com.alevel.model.FileModel;

public interface IONIOService {

    void create(FileModel fileModel);
    String read(String pathToFile);
    String countInfo(String text);
}
