//15-05-2019
//Muhammad Ilyas
//10116339
//IF -8

package com.example.datakontak.model;

public class ContactModel {
    private String Name,NIM,Kelas,Telepon,Email,FB;
    private int Gambar;

    public ContactModel(ContactModel c){

    }

    public ContactModel(String name, String NIM, String kelas, String telepon, String email, String fb, int gambar) {
        Name = name;
        this.NIM = NIM;
        Kelas = kelas;
        Telepon = telepon;
        Email = email;
        FB = fb;
        Gambar = gambar;
    }

    public String getName() {
        return Name;
    }

    public String getNIM() {
        return NIM;
    }

    public String getKelas() {
        return Kelas;
    }

    public String getTelepon() {
        return Telepon;
    }

    public String getEmail() {
        return Email;
    }

    public String getFB() {
        return FB;
    }

    public int getGambar() {
        return Gambar;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public void setKelas(String kelas) {
        Kelas = kelas;
    }

    public void setTelepon(String telepon) {
        Telepon = telepon;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setSteam(String fb) {
        FB = fb;
    }

    public void setGambar(int gambar) {
        Gambar = gambar;
    }
}
