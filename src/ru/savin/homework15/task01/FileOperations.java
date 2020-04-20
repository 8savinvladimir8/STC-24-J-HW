package ru.savin.homework15.task01;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileOperations {
    public boolean checkIfNameCorrect(String name) {
        Pattern pattern = Pattern.compile("(.+)?[><\\|\\?*/:\\\\\"](.+)?");
        Matcher matcher = pattern.matcher(name);
        return !matcher.find();
    }

    public boolean createDirectory(String pathName) {
        File folder = new File(pathName);
        if (folder.exists() && folder.isDirectory()) {
            System.out.println("Папка " + pathName + " уже существует");
            return true;
        }
        if (folder.mkdir()) {
            System.out.println("Папка " + pathName + " создана");
            return true;
        } else {
            System.out.println("Папка " + pathName + " не создана");
            return false;
        }
    }

    public boolean createFile(String pathName, String fileName) {
        File file = new File(pathName + File.separator + fileName);
        if (file.exists() && file.isFile()) {
            System.out.println("Файл " + file.getAbsolutePath() + " уже существует");
            return true;
        }
        try {
            if (file.createNewFile()) {
                System.out.println("Файл " + file.getAbsolutePath() + " создан");
                return true;
            } else {
                System.out.println("Файл " + file.getAbsolutePath() + " не создан");
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean renameFile(String fileName1, String fileName2) {
        File file1 = new File(fileName1);
        File file2 = new File(fileName2);
        if (file2.exists() && file2.isFile()) {
            System.out.println("Файл " + fileName2 + " уже существует");
            return true;
        }
        if (file1.renameTo(file2)) {
            System.out.println("Файл " + fileName1 + " переименован в " + fileName2);
            return true;
        } else {
            System.out.println("Файл " + fileName1 + " не был переименован");
            return false;
        }

    }

    public boolean copyFile(String file, String path) throws IOException {
        File inputFile = new File(file);
        File outputFile = new File(path + File.separator + inputFile.getName());
        try (FileInputStream fis = new FileInputStream(inputFile);
                FileOutputStream fos = new FileOutputStream(outputFile)) {
            if (copyFileWithStream(fis, fos)) {
                System.out.println("Файл " + file + " скопирован в " + path);
                return true;
            }
        }
        return false;
    }

    public boolean copyFileWithStream(InputStream is, OutputStream os) {
        int nLength;
        byte[] buf = new byte[8000];
        try {
            while (true) {
                nLength = is.read(buf);
                if (nLength < 0) {
                    break;
                }
                os.write(buf, 0, nLength);
            }
            is.close();
            os.close();
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public boolean deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("Файл " + fileName + " удалён");
                return true;
            } else {
                System.out.println("Файл " + fileName + " не был удалён");
                return false;
            }
        }
        return false;
    }
}
