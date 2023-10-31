package ls_10_23.ls_31_10_23;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class WorkWithFiles {
    public static void main(String[] args) throws IOException {
        File file = new File("./Legend.txt");

        file.createNewFile();

//        System.out.println(file.getAbsolutePath());

//        Files
//        C:\Users\Andre\IdeaProjects\CyderSistematics\src\ls_10_23\ls_31_10_23\WorkWithFiles.java - absolute path to file
//        CyderSistematics\src\ls_10_23\ls_31_10_23\WorkWithFiles.java - vidnosnyi path to file

        Path pathToFile = Paths.get("./Poem.txt");

//        Files.createFile(pathToFile);

        Files.write(pathToFile, "Hello, students!".getBytes(), StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING);

//        System.out.println();

//        new Scanner(System.in)
/*
        List<String> lines = Files.readAllLines(pathToFile);

        System.out.println(lines);*/
    }
}
