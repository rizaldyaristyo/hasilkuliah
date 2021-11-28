package com.jadwalPack;

public class TabelJadwal {
    private int idTab;
    private String matKulTab, waktuTab, GKBTab, ruanganTab, dosenTab;

    public TabelJadwal(int idTab, String matKulTab, String waktuTab, String gkbTab, String ruanganTab, String dosenTab) {
        this.idTab = idTab;
        this.matKulTab = matKulTab;
        this.waktuTab = waktuTab;
        GKBTab = gkbTab;
        this.ruanganTab = ruanganTab;
        this.dosenTab = dosenTab;
    }

    public int getIdTab() {
        return idTab;
    }

    public void setIdTab(int idTab) {
        this.idTab = idTab;
    }

    public String getMatKulTab() {
        return matKulTab;
    }

    public void setMatKulTab(String matKulTab) {
        this.matKulTab = matKulTab;
    }

    public String getWaktuTab() {
        return waktuTab;
    }

    public void setWaktuTab(String waktuTab) {
        this.waktuTab = waktuTab;
    }

    public String getGKBTab() {
        return GKBTab;
    }

    public void setGKBTab(String GKBTab) {
        this.GKBTab = GKBTab;
    }

    public String getRuanganTab() {
        return ruanganTab;
    }

    public void setRuanganTab(String ruanganTab) {
        this.ruanganTab = ruanganTab;
    }

    public String getDosenTab() {
        return dosenTab;
    }

    public void setDosenTab(String dosenTab) {
        this.dosenTab = dosenTab;
    }
}
