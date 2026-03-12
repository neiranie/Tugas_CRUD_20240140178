package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ktp")
public class Ktp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomorKtp;
    private String namaLengkap;
    private String alamat;
    private String tanggalLahir;
    private String jenisKelamin;
}