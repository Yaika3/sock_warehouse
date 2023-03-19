package me.socks.onlinestoreofsocks.services;

public interface FileService {
    boolean saveToFile(String json);

    String readFromFile();
}
