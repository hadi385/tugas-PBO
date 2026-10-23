import java.time.LocalDate;

public class Peminjaman {

    private Peminjam peminjam;
    private Buku buku;
    private LocalDate tanggalPeminjaman;
    private LocalDate tanggalTenggat;
    private boolean sudahDikembalikan;

    public Peminjaman(
            Peminjam peminjam,
            Buku buku,
            LocalDate tanggalPeminjaman,
            LocalDate tanggalTenggat) {

        this.peminjam = peminjam;
        this.buku = buku;
        this.tanggalPeminjaman = tanggalPeminjaman;
        this.tanggalTenggat = tanggalTenggat;
        this.sudahDikembalikan = false;

        buku.setTersedia(false);
    }

    public Peminjam getPeminjam() {
        return peminjam;
    }

    public Buku getBuku() {
        return buku;
    }

    public LocalDate getTanggalPeminjaman() {
        return tanggalPeminjaman;
    }

    public LocalDate getTanggalTenggat() {
        return tanggalTenggat;
    }

    public boolean isSudahDikembalikan() {
        return sudahDikembalikan;
    }

    public void setSudahDikembalikan(boolean status) {
        this.sudahDikembalikan = status;
    }

    public void tampilkanData() {

        System.out.println("================================");
        System.out.println("DATA PEMINJAMAN");
        System.out.println("================================");

        System.out.println("Peminjam       : "
                + peminjam.getNama());

        System.out.println("Unit           : "
                + peminjam.getUnit());

        System.out.println("Buku           : "
                + buku.getJudulBuku());

        System.out.println("Kode Buku      : "
                + buku.getKodeBuku());

        System.out.println("Tanggal Pinjam : "
                + tanggalPeminjaman);

        System.out.println("Tanggal Tenggat: "
                + tanggalTenggat);

        System.out.println("Status         : "
                + (sudahDikembalikan
                ? "Sudah Dikembalikan"
                : "Masih Dipinjam"));
    }
}