import edu.princeton.cs.algs4.StdOut;

import java.io.File;

public class ListingFiles {

    public static void main(String[] args) {
        File file = new File("I:/books/Android");

        listFile(file, 0);
    }

    private static void listFile(File file, int indentCount) {
        int i = indentCount;
        while (i > 0) {
            StdOut.print("\t");
            i--;
        }
        StdOut.print(file.getName() + "\n");

        if (file.isDirectory()) {
            File[] files = file.listFiles();

            for (int j = 0; j < files.length; ++j) {
                listFile(files[j], indentCount + 1);
            }
        }
    }
}
