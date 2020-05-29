package ru.savin.homework29;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Класс {@code MyDuplicateMap} позволяет добавить записи в карту {@code Map},
 * проверить значения на дубли и удалить их.
 * @author Savin Vladimir
 */
public class MyDuplicateMap {
    static final Logger log = LogManager.getLogger(MyDuplicateMap.class.getName());

    /**
     * Точка входа.
     * @param args содержит аргументы командной строки.
     */
    public static void main(String[] args) {
        PersonHashMap map = new PersonHashMap();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                log.info("");
                log.info("Введите № операции (exit для выхода):");
                log.info("1 - создать элементы карты");
                log.info("2 - проверить значения карты на дубли");
                log.info("3 - вывести элементы карты");

                String line = br.readLine();
                if (line.equals("exit")) return;

                switch (line) {
                    case "1":
                        map.fillMapWithElements();
                        break;
                    case "2":
                        map.deleteDuplicates();
                        break;
                    case "3":
                        map.showMap();
                        break;
                    default:
                        log.error("Введён некорректный номер операции");
                        break;
                }
            }
        } catch (Exception e) {
            log.error(e.fillInStackTrace());
        }
    }
}
