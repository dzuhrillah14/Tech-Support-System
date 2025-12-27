import java.util.Scanner;

public class InputReader {
    private Scanner pembaca;

    public InputReader() {
        pembaca = new Scanner(System.in);
    }

    public String ambilInput() {
        System.out.print("> ");
        String barisInput = pembaca.nextLine();
        
        if (barisInput == null) {
            return "";
        }
        // Mengubah ke huruf kecil agar cocok dengan kata kunci di Responder
        return barisInput.toLowerCase().trim();
    }
}
