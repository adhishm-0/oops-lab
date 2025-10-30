package exp9;

import java.io.*;
import java.util.*;

public class question1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== FILE OPERATIONS MENU =====");
            System.out.println("1. Analyze data.txt and create report.txt");
            System.out.println("2. Create a new file");
            System.out.println("3. Rename a file");
            System.out.println("4. Delete a file");
            System.out.println("5. Create a directory");
            System.out.println("6. Find absolute path of a file");
            System.out.println("7. Display all file names in a directory");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                	analyzeTextFile();
                    break;
                case 2:
                    createFile();
                    break;
                case 3:
                    renameFile();
                    break;
                case 4:
                    deleteFile();
                    break;
                case 5:
                    createDirectory();
                    break;
                case 6:
                    findAbsolutePath();
                    break;
                case 7:
                    listFilesInDirectory();
                    break;
                case 8:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 8);
    }

    public static void analyzeTextFile() {
        File inputFile = new File("data.txt");
        File reportFile = new File("report.txt");

        if (!inputFile.exists()) {
            System.out.println("data.txt not found!");
            return;
        }

        int charCount = 0, wordCount = 0, lineCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length();
                String[] words = line.trim().split("\\s+");
                if (words.length > 0 && !line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportFile))) {
                writer.write("===== File Analysis Report =====\n");
                writer.write("Total Characters: " + charCount + "\n");
                writer.write("Total Words: " + wordCount + "\n");
                writer.write("Total Lines: " + lineCount + "\n");
                System.out.println("Report created successfully in 'report.txt'");
            }

        } catch (IOException e) {
            System.out.println("Error reading or writing file: " + e.getMessage());
        }
    }

    public static void createFile() {
        System.out.print("Enter the filename to create: ");
        String name = sc.nextLine();
        File file = new File(name);
        try {
            if (file.createNewFile()) {
                System.out.println("File created successfully: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    public static void renameFile() {
        System.out.print("Enter the current filename: ");
        String oldName = sc.nextLine();
        System.out.print("Enter the new filename: ");
        String newName = sc.nextLine();
        File oldFile = new File(oldName);
        File newFile = new File(newName);

        if (oldFile.exists()) {
            if (oldFile.renameTo(newFile)) {
                System.out.println("File renamed successfully.");
            } else {
                System.out.println("Rename failed.");
            }
        } else {
            System.out.println("File not found.");
        }
    }

    public static void deleteFile() {
        System.out.print("Enter the filename to delete: ");
        String name = sc.nextLine();
        File file = new File(name);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Failed to delete the file.");
            }
        } else {
            System.out.println("File not found.");
        }
    }

    public static void createDirectory() {
        System.out.print("Enter directory name to create: ");
        String dirName = sc.nextLine();
        File dir = new File(dirName);
        if (dir.mkdir()) {
            System.out.println("Directory created successfully.");
        } else {
            System.out.println("Failed to create directory.");
        }
    }

    public static void findAbsolutePath() {
        System.out.print("Enter filename: ");
        String name = sc.nextLine();
        File file = new File(name);
        System.out.println("Absolute Path: " + file.getAbsolutePath());
    }

    public static void listFilesInDirectory() {
        System.out.print("Enter directory path: ");
        String dirPath = sc.nextLine();
        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            String[] files = dir.list();
            System.out.println("Files in directory '" + dirPath + "':");
            for (String f : files) {
                System.out.println(f);
            }
        } else {
            System.out.println("Invalid directory.");
        }
    }
}

