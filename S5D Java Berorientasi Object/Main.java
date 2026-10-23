import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    static Perpustakaan perpustakaan =
            new Perpustakaan();

    public static void main(String[] args) {

        int pilihan;

        do {

            tampilkanMenu();

            System.out.print("Pilih menu : ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                case 1:
                    inputBuku();
                    break;

                case 2:
                    tampilkanBuku();
                    break;

                case 3:
                    peminjamanBuku();
                    break;

                case 4:
                    tampilkanPeminjaman();
                    break;

                case 5:
                    pengembalianBuku();
                    break;

                case 6:
                    tampilkanPengembalian();
                    break;

                case 7:
                    System.out.println(
                            "Terima kasih telah menggunakan sistem.");
                    break;

                default:
                    System.out.println(
                            "Menu tidak tersedia.");
            }

        } while (pilihan != 7);
    }

    static void tampilkanMenu() {

        System.out.println();
        System.out.println("================================");
        System.out.println("       SYSTEM PERPUSTAKAAN");
        System.out.println("================================");
        System.out.println("1. Input Buku");
        System.out.println("2. Data Buku");
        System.out.println("3. Peminjaman Buku");
        System.out.println("4. Data Peminjaman");
        System.out.println("5. Pengembalian Buku");
        System.out.println("6. Data Pengembalian");
        System.out.println("7. Keluar");
        System.out.println("================================");
    }

    static void inputBuku() {

        System.out.println();
        System.out.println("=== INPUT BUKU ===");

        System.out.print("Kode Buku : ");
        String kode = input.nextLine();

        System.out.print("Judul Buku : ");
        String judul = input.nextLine();

        Buku buku = new Buku(kode, judul);

        perpustakaan.tambahBuku(buku);
    }

    static void tampilkanBuku() {

        System.out.println();
        System.out.println("=== DATA BUKU ===");

        if (perpustakaan.getDaftarBuku().isEmpty()) {

            System.out.println("Belum ada data buku.");

            return;
        }

        for (Buku buku :
                perpustakaan.getDaftarBuku()) {

            buku.tampilkanData();
        }
    }

    static void peminjamanBuku() {

        System.out.println();
        System.out.println("=== PEMINJAMAN BUKU ===");

        if (perpustakaan.getDaftarBuku().isEmpty()) {

            System.out.println(
                    "Belum ada buku yang tersedia.");

            return;
        }

        System.out.print("Nama Peminjam : ");
        String nama = input.nextLine();

        System.out.print("Unit Peminjam : ");
        String unit = input.nextLine();

        System.out.print("Alamat        : ");
        String alamat = input.nextLine();

        System.out.print("Nomor ID/KTP  : ");
        String ktp = input.nextLine();

        Peminjam peminjam =
                new Peminjam(
                        nama,
                        unit,
                        alamat,
                        ktp);

        System.out.println();
        System.out.println("DAFTAR BUKU");

        for (int i = 0;
             i < perpustakaan.getDaftarBuku().size();
             i++) {

            Buku buku =
                    perpustakaan.getDaftarBuku().get(i);

            if (buku.isTersedia()) {

                System.out.println(
                        (i + 1) + ". "
                        + buku.getKodeBuku()
                        + " - "
                        + buku.getJudulBuku());
            }
        }

        System.out.print("Pilih nomor buku : ");
        int nomor = input.nextInt();
        input.nextLine();

        Buku buku =
                perpustakaan
                .getDaftarBuku()
                .get(nomor - 1);

        if (!buku.isTersedia()) {

            System.out.println(
                    "Buku sedang dipinjam.");

            return;
        }

        System.out.print(
                "Tanggal Tenggat (YYYY-MM-DD): ");

        String tanggal =
                input.nextLine();

        LocalDate tanggalTenggat =
                LocalDate.parse(tanggal);

        Peminjaman peminjaman =
                new Peminjaman(
                        peminjam,
                        buku,
                        LocalDate.now(),
                        tanggalTenggat);

        perpustakaan
                .tambahPeminjaman(peminjaman);
    }

    static void tampilkanPeminjaman() {

        System.out.println();
        System.out.println("=== DATA PEMINJAMAN ===");

        if (perpustakaan
                .getDaftarPeminjaman()
                .isEmpty()) {

            System.out.println(
                    "Belum ada data peminjaman.");

            return;
        }

        for (Peminjaman p :
                perpustakaan.getDaftarPeminjaman()) {

            p.tampilkanData();
        }
    }

    static void pengembalianBuku() {

        System.out.println();
        System.out.println("=== PENGEMBALIAN BUKU ===");

        if (perpustakaan
                .getDaftarPeminjaman()
                .isEmpty()) {

            System.out.println(
                    "Belum ada data peminjaman.");

            return;
        }

        System.out.println("DAFTAR PEMINJAMAN:");

        int nomor = 1;

        for (Peminjaman p :
                perpustakaan.getDaftarPeminjaman()) {

            if (!p.isSudahDikembalikan()) {

                System.out.println(
                        nomor + ". "
                        + p.getPeminjam().getNama()
                        + " - "
                        + p.getBuku().getJudulBuku());

                nomor++;
            }
        }

        System.out.print(
                "Pilih peminjaman : ");

        int pilihan = input.nextInt();
        input.nextLine();

        int index = 0;

        for (Peminjaman p :
                perpustakaan.getDaftarPeminjaman()) {

            if (!p.isSudahDikembalikan()) {

                index++;

                if (index == pilihan) {

                    System.out.print(
                            "Tanggal Pengembalian (YYYY-MM-DD): ");

                    String tanggal =
                            input.nextLine();

                    LocalDate tanggalKembali =
                            LocalDate.parse(tanggal);

                    Pengembalian pengembalian =
                            new Pengembalian(
                                    p,
                                    tanggalKembali);

                    perpustakaan
                            .tambahPengembalian(
                                    pengembalian);

                    pengembalian.tampilkanData();

                    return;
                }
            }
        }

        System.out.println(
                "Data peminjaman tidak ditemukan.");
    }

    static void tampilkanPengembalian() {

        System.out.println();
        System.out.println("=== DATA PENGEMBALIAN ===");

        if (perpustakaan
                .getDaftarPengembalian()
                .isEmpty()) {

            System.out.println(
                    "Belum ada data pengembalian.");

            return;
        }

        for (Pengembalian p :
                perpustakaan.getDaftarPengembalian()) {

            p.tampilkanData();
        }
    }
}