package com.example.demo.service;

import com.example.demo.model.Ktp;
import com.example.demo.repository.KtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class KtpService {
    @Autowired
    private KtpRepository ktpRepository;

    public Ktp saveKtp(Ktp ktp) {
        if(ktpRepository.findByNomorKtp(ktp.getNomorKtp()).isPresent()) {
            throw new RuntimeException("Error: Nomor KTP sudah terdaftar!");
        }
        return ktpRepository.save(ktp);
    }

    public List<Ktp> getAllKtp() {
        return ktpRepository.findAll();
    }

    public Ktp getKtpById(Integer id) {
        return ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: Data KTP tidak ditemukan"));
    }

    public Ktp updateKtp(Integer id, Ktp details) {
        Ktp ktp = getKtpById(id);
        ktp.setNamaLengkap(details.getNamaLengkap());
        ktp.setAlamat(details.getAlamat());
        ktp.setTanggalLahir(details.getTanggalLahir());
        ktp.setJenisKelamin(details.getJenisKelamin());
        return ktpRepository.save(ktp);
    }

    public void deleteKtp(Integer id) {
        ktpRepository.deleteById(id);
    }
}