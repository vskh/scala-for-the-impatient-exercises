package chapter15;

import static chapter15.task5.readFile;

/**
 * Created by vadya on 11.08.15.
 */
public class task5Main {
    public static void main(String[] args) {
        System.out.println("File content:\n" + readFile("/etc/passwd"));
    }
}
