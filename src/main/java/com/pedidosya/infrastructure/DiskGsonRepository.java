package com.pedidosya.infrastructure;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DiskGsonRepository<T> {
    private final String filePath;
    private final Class<T> objectClass;

    public DiskGsonRepository(String fileName, Class<T> objectClass) {
        filePath = "./" + fileName;
        this.objectClass = objectClass;
    }

    protected void saveValue(T object) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath, true);
            GsonSerializer.getGson().toJson(object, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected T getSavedValue() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filePath);
            return GsonSerializer.getGson().fromJson(new FileReader(filePath), objectClass);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
