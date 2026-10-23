import java.util.ArrayList;

public class Perpustakaan {

    private ArrayList<Buku> daftarBuku;
    private ArrayList<Peminjaman> daftarPeminjaman;
    private ArrayList<Pengembalian> daftarPengembalian;

    public Perpustakaan() {

        daftarBuku = new ArrayList<>();
        daftarPeminjaman = new ArrayList<>();
        daftarPengembalian = new ArrayList<>();
    }

    public void tambahBuku(Buku buku) {

        daftarBuku.add(buku);

        System.out.println("Buku berhasil ditambahkan.");
    }

    public void tambahPeminjaman(Peminjaman peminjaman) {

        daftarPeminjaman.add(peminjaman);

        System.out.println("Peminjaman berhasil dicatat.");
    }

    public void tambahPengembalian(Pengembalian pengembalian) {

        daftarPengembalian.add(pengembalian);

        System.out.println("Pengembalian berhasil dicatat.");
    }

    public ArrayList<Buku> getDaftarBuku() {
        return daftarBuku;
    }

    public ArrayList<Peminjaman> getDaftarPeminjaman() {
        return daftarPeminjaman;
    }

    public ArrayList<Pengembalian> getDaftarPengembalian() {
        return daftarPengembalian;
    }
}