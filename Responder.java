import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class Responder {
    private HashMap<String, String> responseMap;
    private ArrayList<String> defaultResponses;
    private Random randomGenerator;

    public Responder() {
        responseMap = new HashMap<>();
        defaultResponses = new ArrayList<>();
        randomGenerator = new Random();
        
        fillResponseMap();
        fillDefaultResponses();
    }

    private void fillResponseMap() {
        // Masalah Software
        responseMap.put("crash", "Mohon pastikan driver kartu grafis Anda sudah diperbarui.");
        responseMap.put("slow", "Coba tutup aplikasi latar belakang dan periksa penggunaan RAM di Task Manager.");
        responseMap.put("save", "Pastikan Anda memiliki izin akses ke folder tujuan penyimpanan.");
        responseMap.put("virus", "Segera jalankan full scan menggunakan Antivirus yang terupdate.");
        
        // Masalah Hardware & Koneksi
        responseMap.put("panas", "Bersihkan lubang ventilasi dan pastikan kipas (fan) bekerja dengan normal.");
        responseMap.put("baterai", "Kurangi kecerahan layar atau ganti baterai jika sudah menunjukkan tanda kerusakan.");
        responseMap.put("layar", "Coba hubungkan ke monitor eksternal untuk memastikan apakah itu kerusakan hardware LCD.");
        responseMap.put("keyboard", "Pastikan tidak ada kotoran di bawah tombol atau coba instal ulang driver keyboard.");
        responseMap.put("internet", "Coba restart router Anda dan pastikan Airplane Mode tidak aktif.");
        responseMap.put("suara", "Periksa pengaturan output audio dan pastikan driver audio sudah terinstal.");
    }

    private void fillDefaultResponses() {
        defaultResponses.add("Itu terdengar menarik. Bisa jelaskan lebih detail?");
        defaultResponses.add("Hmm, saya perlu informasi lebih lanjut untuk membantu masalah tersebut.");
        defaultResponses.add("Apakah masalah ini sering terjadi atau baru saja muncul?");
        defaultResponses.add("Bisa Anda ceritakan kronologi sebelum masalah itu terjadi?");
    }

    public String generateResponse(String userInput) {
        // Memecah kalimat menjadi kata-kata (menggunakan spasi atau tanda baca sebagai pemisah)
        String[] words = userInput.split("[\\s\\p{Punct}]+");
        
        for (String word : words) {
            if (responseMap.containsKey(word)) {
                return responseMap.get(word);
            }
        }

        // Jika tidak ada kata kunci yang cocok
        int index = randomGenerator.nextInt(defaultResponses.size());
        return defaultResponses.get(index);
    }
}
