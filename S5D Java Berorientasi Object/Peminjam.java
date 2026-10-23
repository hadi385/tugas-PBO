public class Peminjam {

    private String nama;
    private String unit;
    private String alamat;
    private String nomorIdentitas;

    public Peminjam(
            String nama,
            String unit,
            String alamat,
            String nomorIdentitas) {

        this.nama = nama;
        this.unit = unit;
        this.alamat = alamat;
        this.nomorIdentitas = nomorIdentitas;
    }

    public String getNama() {
        return nama;
    }

    public String getUnit() {
        return unit;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNomorIdentitas() {
        return nomorIdentitas;
    }

    public void tampilkanData() {

        System.out.println("--------------------------------");
        System.out.println("Nama           : " + nama);
        System.out.println("Unit           : " + unit);
        System.out.println("Alamat         : " + alamat);
        System.out.println("Nomor ID/KTP   : " + nomorIdentitas);
    }
}