import java.io.*;

public class Main {

    public static void createBackup(String sourceDirPath) {
        File sourceDir = new File(sourceDirPath);
        File backupDir = new File(sourceDirPath, "backup");


        if (!backupDir.exists() && !backupDir.mkdir()) {
            System.out.println("Не удалось создать папку backup.");
            return;
        }


        File[] files = sourceDir.listFiles();
        if (files == null) {
            System.out.println("Директория пуста или не существует.");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                try (InputStream input = new FileInputStream(file);
                     OutputStream output = new FileOutputStream(new File(backupDir, file.getName()))) {

                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = input.read(buffer)) > 0) {
                        output.write(buffer, 0, length);
                    }

                    System.out.println("Файл " + file.getName() + " успешно скопирован.");
                } catch (IOException e) {
                    System.out.println("Ошибка при копировании файла: " + file.getName());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        String directoryPath = "C:/projects/JavaCore/5";
        createBackup(directoryPath);
    }
}
