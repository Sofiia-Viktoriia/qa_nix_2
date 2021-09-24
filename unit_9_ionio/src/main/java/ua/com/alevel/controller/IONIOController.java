package ua.com.alevel.controller;

import ua.com.alevel.service.*;
import ua.com.alevel.model.*;

public class IONIOController {

    public void run() {
        IONIOService service = new IONIOServiceImpl();
        String inputText = service.read("input.txt");
        FileModel file = new FileModel();
        file.setName("output");
        file.setFileType(FileType.TXT);
        file.setContent(service.countInfo(inputText));
        service.create(file);
    }
}
