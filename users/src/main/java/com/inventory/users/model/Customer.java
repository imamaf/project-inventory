package com.inventory.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
    private long id;
    private String namaLengkap;
    private String email;
    private String noTelepon;
    private String password;
    private String konfirmPassword;

    public Customer(){

    }

    public Customer(String namaLengkap, String email, String noTelepon, String password, String konfirmPassword){
        this.namaLengkap = namaLengkap;
        this.email = email;
        this.noTelepon = noTelepon;
        this.password = password;
        this.konfirmPassword = konfirmPassword;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

    @Column(name = "nama_lengkap", nullable = false)
    public String getNamaLengkap(){
        return namaLengkap;
    }
    public void setNamaLengkap(String namaLengkap){
        this.namaLengkap = namaLengkap;
    }

    @Column(name = "email", nullable = false)
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    @Column(name = "no_telepon", nullable = false)
    public String getNoTelepon(){
        return noTelepon;
    }
    public void setNoTelepon(String noTelepon){
        this.noTelepon = noTelepon;
    }

    @Column(name = "password", nullable = false)
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    @Column(name = "konfirm_password", nullable = false)
    public String getKonfirmPassword(){
        return konfirmPassword;
    }
    public void setKonfirmPassword(String konfirmPassword){
        this.konfirmPassword = konfirmPassword;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id +", namaLengkap=" + namaLengkap +", email=" + email +", noTelepon=" + noTelepon 
        +", password=" + password +", konfirmPassword=" + konfirmPassword + "]";
    }
}