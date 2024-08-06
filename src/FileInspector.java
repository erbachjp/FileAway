import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileInspector {

    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser(new File("src"));

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String fileName = selectedFile.getName();

            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lineCount++;
                    wordCount += line.split("\\s+").length;
                    charCount += line.length();
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
             }
            System.out.println("\nSummary Report:");
            System.out.println("File: " + fileName);
            System.out.println("lines: " + lineCount);
            System.out.println("words: " + wordCount);
            System.out.println("characters: " + charCount);
        }  else   {
             System.out.println("error try again");
          }
     }
}
