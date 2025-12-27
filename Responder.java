import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class Responder {
    private HashMap<String, String> petaRespon;
    private ArrayList<String> responDefault;
    private Random generatorAcak;

    public Responder() {
        petaRespon = new HashMap<>();
        responDefault = new ArrayList<>();
        generatorAcak = new Random();
        
        isiPetaRespon();
        isiResponDefault();
    }

    private void isiPetaRespon() {
        // --- RESPON AFIRMASI & SOPAN SANTUN ---
        petaRespon.put("baik", "Baguslah kalau begitu. Ada lagi kendala teknis yang bisa saya bantu?");
        petaRespon.put("oke", "Siap! Ingat untuk selalu merawat hardware Anda secara berkala.");
        petaRespon.put("okee", "Sip! Ada hal lain yang ingin Anda tanyakan?");
        petaRespon.put("siap", "Oke! Saya stand-by di sini jika Anda butuh bantuan lebih lanjut.");
        petaRespon.put("terima", "Sama-sama! Senang bisa membantu mencarikan solusi untuk Anda.");
        petaRespon.put("makasih", "Sama-sama! Jangan ragu untuk bertanya lagi jika komputer bermasalah.");
        petaRespon.put("thanks", "You're welcome! Ada lagi yang bisa saya bantu?");

        // --- MASALAH PERFORMA & SISTEM ---
        petaRespon.put("lambat", "Coba buka Task Manager (Ctrl+Shift+Esc) dan matikan aplikasi yang memakan banyak RAM.");
        petaRespon.put("lemot", "Bersihkan file sampah (Cache) dengan menekan Windows+R, ketik %temp%, lalu hapus isinya.");
        petaRespon.put("hang", "Jika macet total, tekan tombol power selama 10 detik untuk melakukan restart paksa.");
        petaRespon.put("biru", "Layar biru (BSOD) biasanya karena crash driver. Cobalah update Windows atau driver grafis Anda.");
        petaRespon.put("restart", "Jika sering restart sendiri, periksa apakah suhu laptop terlalu panas atau ada masalah di PSU.");

        // --- MASALAH HARDWARE ---
        petaRespon.put("panas", "Pastikan kipas tidak tertutup debu. Gunakan cooling pad jika perlu dan ganti thermal paste.");
        petaRespon.put("baterai", "Jika boros, turunkan kecerahan layar. Jika tidak mengisi, cek kabel charger atau driver baterai.");
        petaRespon.put("layar", "Layar bergaris bisa jadi karena kabel fleksibel atau LCD rusak. Cek dengan monitor eksternal.");
        petaRespon.put("keyboard", "Jika ada tombol macet, coba bersihkan dengan kuas. Jika mengetik sendiri, biasanya ada jalur korslet.");
        petaRespon.put("bunyi", "Bunyi beep berulang biasanya tanda RAM kotor. Coba lepas RAM dan bersihkan kuningannya dengan penghapus.");

        // --- MASALAH KONEKSI & KEAMANAN ---
        petaRespon.put("wifi", "Coba klik kanan ikon WiFi lalu pilih 'Troubleshoot'. Atau restart router internet Anda.");
        petaRespon.put("internet", "Pastikan Airplane Mode mati. Jika tetap tidak bisa, reset pengaturan network di settings.");
        petaRespon.put("virus", "Matikan internet, lalu jalankan full scan menggunakan Windows Defender atau antivirus terpercaya.");
        petaRespon.put("flashdisk", "Jika tidak terbaca, coba colok ke port USB di bagian belakang (untuk PC) atau cek di Disk Management.");
    }

    private void isiResponDefault() {
        responDefault.add("Mohon maaf, bisa jelaskan lebih detail masalahnya?");
        responDefault.add("Saya kurang paham maksud Anda. Bisa gunakan kata kunci seperti 'layar', 'wifi', atau 'lambat'?");
        responDefault.add("Apakah sudah Anda coba restart komputernya? Itu seringkali membantu.");
        responDefault.add("Sudah berapa lama masalah ini terjadi? Berikan informasi lebih spesifik.");
        responDefault.add("Saya butuh info tambahan. Apakah ada pesan error yang muncul di layar?");
    }

    public String hasilkanRespon(String inputPengguna) {
        // Memecah kalimat menjadi kata-kata (menghapus tanda baca)
        String[] kataKata = inputPengguna.split("[\\s\\p{Punct}]+");
        
        for (String kata : kataKata) {
            if (petaRespon.containsKey(kata)) {
                return petaRespon.get(kata);
            }
        }

        // Jika tidak ada kata kunci yang cocok, ambil respon acak
        int indeks = generatorAcak.nextInt(responDefault.size());
        return responDefault.get(indeks);
    }
}
