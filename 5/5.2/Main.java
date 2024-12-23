
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int[] cells = {1, 2, 0, 1, 3, 2, 0, 0, 1};

        StringBuilder binaryString = new StringBuilder();
        for (int cell : cells) {
            binaryString.append(String.format("%2s", Integer.toBinaryString(cell)).replace(' ', '0'));
        }

        byte[] bytes = new byte[3];
        for (int i = 0; i < 3; i++) {
            bytes[i] = (byte) Integer.parseInt(binaryString.substring(i * 8, (i + 1) * 8), 2);
        }

        try (FileOutputStream fos = new FileOutputStream("tictactoe.dat")) {
            fos.write(bytes);
            System.out.println("Данные успешно записаны в файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



