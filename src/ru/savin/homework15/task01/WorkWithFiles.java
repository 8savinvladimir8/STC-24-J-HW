package ru.savin.homework15.task01;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс создаёт, переименовывает, копирует и удаляет файл.
 */
public class WorkWithFiles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isWorking = true;
        int operationFlag = 0;
        String filePath1 = "";
        String filePath2 = "";
        String fileName1 = "";
        String fileName2 = "";
        FileOperations fo = new FileOperations();

        System.out.println("Для выхода из программы можно ввести: exit");
        while (isWorking) {
            // Создание папки для файла
            if (operationFlag == 0) {
                System.out.println("Введите имя папки на диске С: в которой будет создан файл");
                filePath1 = br.readLine();
                if (filePath1.equals("exit")) break;
                if (!fo.checkIfNameCorrect(filePath1)) {
                    System.out.println("Некорректное имя папки: " + filePath1);
                    continue;
                } else {
                    filePath1 = "C:" + File.separator + filePath1;
                    if (fo.createDirectory(filePath1)) operationFlag = 1;
                    System.out.println();
                }
            }

            // Создание файла в папке
            if (operationFlag == 1) {
                System.out.println("Введите имя файла, который будет создан в папке " + filePath1);
                fileName1 = br.readLine();
                if (fileName1.equals("exit")) break;
                if (!fo.checkIfNameCorrect(fileName1)) {
                    System.out.println("Некорректное имя файла: " + fileName1);
                    continue;
                } else {
                    if (fo.createFile(filePath1, fileName1)) operationFlag = 2;
                    System.out.println();
                }
            }

            // Переименование созданного файла
            if (operationFlag == 2) {
                System.out.println("Переименуем файл " + fileName1 + " - введите новое имя");
                fileName2 = br.readLine();
                if (fileName2.equals("exit")) break;
                if (!fo.checkIfNameCorrect(fileName2)) {
                    System.out.println("Некорректное имя файла: " + fileName2);
                    continue;
                } else {
                    if (fo.renameFile(filePath1 + File.separator + fileName1, filePath1 + File.separator + fileName2)) {
                        fileName1 = fileName2;
                        operationFlag = 3;
                        System.out.println();
                    }
                }
            }

            // Создание папки для копирования файла
            if (operationFlag == 3) {
                System.out.println("Введите имя папки, которая будет создана в " + filePath1);
                filePath2 = br.readLine();
                if (filePath2.equals("exit")) break;
                if (!fo.checkIfNameCorrect(filePath2)) {
                    System.out.println("Некорректное имя папки: " + filePath2);
                    continue;
                } else {
                    filePath2 = filePath1 + File.separator + filePath2;
                    if (fo.createDirectory(filePath2)) operationFlag = 4;
                    System.out.println();
                }
            }

            // Копирование файла
            if (operationFlag == 4) {
                System.out.println("Копируем файл " + filePath1 + File.separator + fileName1 + " в папку " + filePath2);
                try {
                    fo.copyFile(filePath1 + File.separator + fileName1, filePath2);
                } catch (IOException e) {
                    System.out.println("Ошибка ввода-вывода! " + e);
                    e.printStackTrace();
                }
                operationFlag = 5;
                System.out.println();
            }

            // Удаление файла
            if (operationFlag == 5) {
                System.out.println("Удаляем файл " + filePath1 + File.separator + fileName1);
                if (fo.deleteFile(filePath1 + File.separator + fileName1)) {
                    System.out.println();
                }
                isWorking = false;
            }
        }
    }
}
