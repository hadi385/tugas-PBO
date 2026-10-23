import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Buku {

    private String kodeBuku;
    private String judulBuku;
    private LocalDateTime tanggalInput;
    private boolean tersedia;

    public Buku(String kodeBuku, String judulBuku) {
        this.kodeBuku = kodeBuku;
        this.judulBuku = judulBuku;
        this.tanggalInput = LocalDateTime.now();
        this.tersedia = true;
    }

    public String getKodeBuku() {
        return kodeBuku;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public LocalDateTime getTanggalInput() {
        return tanggalInput;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    public void tampilkanData() {

        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        System.out.println("--------------------------------");
        System.out.println("Kode Buku     : " + kodeBuku);
        System.out.println("Judul Buku    : " + judulBuku);
        System.out.println("Tanggal Input : " +
                tanggalInput.format(format));
        System.out.println("Status        : " +
                (tersedia ? "Tersedia" : "Dipinjam"));
    }
}