package org.delta.storage;

import com.google.gson.Gson;
import jakarta.inject.Singleton;

import java.util.LinkedList;
import java.util.List;

@Singleton
public class FileStorageSystem {
    private List<String> files = new LinkedList<>();

    public void addToFileSystem(String fileName) {
        files.add(fileName);
    }

    public List<String> getFiles() {
        return files;
    }
}
