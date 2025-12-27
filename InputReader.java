import java.util.Scanner;

public class InputReader {
    private Scanner reader;

    public InputReader() {
        reader = new Scanner(System.in);
    }

    /**
     * Membaca input dari terminal dan mengubahnya menjadi huruf kecil.
     */
    public String getInput() {
        System.out.print("> ");
        String inputLine = reader.nextLine();
        return inputLine.toLowerCase();
    }
}
