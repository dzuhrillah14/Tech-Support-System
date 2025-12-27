public class SupportSystem {
    private InputReader pembaca;
    private Responder pemberiRespon;

    public SupportSystem() {
        pembaca = new InputReader();
        pemberiRespon = new Responder();
    }

    public void mulai() {
        boolean selesai = false;

        tampilkanWelcome();

        while (!selesai) {
            String input = pembaca.ambilInput();

            if (input.equals("keluar") || input.equals("bye") || input.equals("selesai")) {
                selesai = true;
            } else if (input.isEmpty()) {
                System.out.println("Anda belum mengetikkan apa pun. Silakan masukkan masalah Anda.");
            } else {
                String jawaban = pemberiRespon.hasilkanRespon(input);
                System.out.println(jawaban);
            }
        }
        tampilkanPamit();
    }

    private void tampilkanWelcome() {
        System.out.println("====================================================");
        System.out.println("Sistem Bantuan Teknis Komputer Otomatis (DodgySoft)");
        System.out.println("====================================================");
        System.out.println("Selamat datang! Ada masalah apa dengan komputer Anda?");
        System.out.println("Ketik 'keluar' untuk mengakhiri bantuan.");
        System.out.println("----------------------------------------------------");
    }

    private void tampilkanPamit() {
        System.out.println("Terima kasih telah berkonsultasi. Semoga harimu menyenangkan!");
    }

    public static void main(String[] args) {
        SupportSystem sistem = new SupportSystem();
        sistem.mulai();
    }
}
