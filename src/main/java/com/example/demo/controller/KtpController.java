package com.example.demo.controller;

import com.example.demo.model.Ktp;
import com.example.demo.service.KtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ktp")
public class KtpController {
    @Autowired
    private KtpService ktpService;

    @PostMapping
    public Ktp createKtp(@RequestBody Ktp ktp) {
        return ktpService.saveKtp(ktp);
    }

    @GetMapping
    public List<Ktp> getAllKtp() {
        return ktpService.getAllKtp();
    }

    @GetMapping("/{id}")
    public Ktp getKtpById(@PathVariable Integer id) {
        return ktpService.getKtpById(id);
    }

    @PutMapping("/{id}")
    public Ktp updateKtp(@PathVariable Integer id, @RequestBody Ktp ktp) {
        return ktpService.updateKtp(id, ktp);
    }

    @DeleteMapping("/{id}")
    public void deleteKtp(@PathVariable Integer id) {
        ktpService.deleteKtp(id);
    }
}