package id.ac.uad.plankton.model;

/**
 * Created by kipli on 14/10/15.
 */
public class Nilai {
    private int id;
    private int kodeKuliah;
    private String namaKuliah;
    private String nilai;

    public Nilai(){

    }

    public Nilai(int id, int kodeKuliah, String namaKuliah, String nilai) {
        this.id = id;
        this.kodeKuliah = kodeKuliah;
        this.namaKuliah = namaKuliah;
        this.nilai = nilai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKodeKuliah() {
        return kodeKuliah;
    }

    public void setKodeKuliah(int kodeKuliah) {
        this.kodeKuliah = kodeKuliah;
    }

    public String getNamaKuliah() {
        return namaKuliah;
    }

    public void setNamaKuliah(String namaKuliah) {
        this.namaKuliah = namaKuliah;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }
}
