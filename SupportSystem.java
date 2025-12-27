public class SupportSystem {
    private InputReader reader;
    private Responder responder;

    public SupportSystem() {
        reader = new InputReader();
        responder = new Responder();
    }

    /**
     * Memulai sistem dukungan teknis.
     */
    public void start() {
        boolean finished = false;

        printWelcome();

        while (!finished) {
            String input = reader.getInput().trim();

            if (input.equals("bye")) {
                finished = true;
            } else if (input.isEmpty()) {
                System.out.println("Tolong ketikkan sesuatu agar saya bisa membantu.");
            } else {
                String response = responder.generateResponse(input);
                System.out.println(response);
            }
        }
        printGoodbye();
    }

    private void printWelcome() {
        System.out.println("Welcome to the DodgySoft Technical Support System.");
        System.out.println();
        System.out.println("Silakan beri tahu kami masalah komputer Anda.");
        System.out.println("Ketik 'bye' untuk keluar dari sistem.");
    }

    private void printGoodbye() {
        System.out.println("Terima kasih telah menghubungi kami. Semoga harimu menyenangkan!");
    }

    public static void main(String[] args) {
        SupportSystem system = new SupportSystem();
        system.start();
    }
}
