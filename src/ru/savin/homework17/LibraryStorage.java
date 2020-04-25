package ru.savin.homework17;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

/**
 * Класс сериализует и десериализует Library
 */
public class LibraryStorage {
    static final Logger log = LogManager.getLogger(LibraryStorage.class.getName());

    public void saveLibrary(Library library) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("library.dat"))) {
            oos.writeObject(library);
            log.info("Библиотека сохранена в library.dat");
        } catch (IOException e) {
            log.error("Ошибка ввода-вывода:");
            e.printStackTrace();
        }
    }

    public Library loadLibrary() {
        File file = new File("library.dat");
        if (file.exists() && file.isFile()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                return (Library) ois.readObject();
            } catch (IOException e) {
                log.error("Ошибка ввода-вывода:");
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                log.error("Не найден считываемый класс:");
                e.printStackTrace();
            }
        } else {
            log.info("Файл сохранения library.dat не найден. Восстановление невозможно");
        }
        return null;
    }
}
