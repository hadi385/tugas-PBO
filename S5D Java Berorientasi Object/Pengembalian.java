import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pengembalian {

    private Peminjaman peminjaman;
    private LocalDate tanggalPengembalian;
    private long keterlambatan;
    private long denda;

    private final long DENDA_PER_HARI = 5000;

    public Pengembalian(
            Peminjaman peminjaman,
            LocalDate tanggalPengembalian) {

        this.peminjaman = peminjaman;
        this.tanggalPengembalian = tanggalPengembalian;

        hitungDenda();

        peminjaman.setSudahDikembalikan(true);
        peminjaman.getBuku().setTersedia(true);
    }

    private void hitungDenda() {

        if (tanggalPengembalian.isAfter(
                peminjaman.getTanggalTenggat())) {

            keterlambatan =
                    ChronoUnit.DAYS.between(
                            peminjaman.getTanggalTenggat(),
                            tanggalPengembalian);

            denda = keterlambatan * DENDA_PER_HARI;

        } else {

            keterlambatan = 0;
            denda = 0;
        }
    }

    public void tampilkanData() {

        System.out.println("================================");
        System.out.println("DATA PENGEMBALIAN");
        System.out.println("================================");

        System.out.println("Nama Peminjam  : "
                + peminjaman.getPeminjam().getNama());

        System.out.println("Buku           : "
                + peminjaman.getBuku().getJudulBuku());

        System.out.println("Tanggal Tenggat: "
                + peminjaman.getTanggalTenggat());

        System.out.println("Tanggal Kembali: "
                + tanggalPengembalian);

        System.out.println("Keterlambatan  : "
                + keterlambatan + " hari");

        System.out.println("Denda          : Rp "
                + String.format("%,d", denda));
    }
}