package id.ac.uad.plankton.model;

/**
 * Created by kipli on 14/10/15.
 */
public class MataKuliah {

    private int kodeKuliah;
    private String namaKuliah;
    private int sks;

    public MataKuliah(){

    }

    public MataKuliah(int kodeKuliah, String namaKuliah, int sks) {
        this.kodeKuliah = kodeKuliah;
        this.namaKuliah = namaKuliah;
        this.sks = sks;
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

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }
}
