package com.example.demo.controller;

import com.example.demo.model.Ktp;
import com.example.demo.service.KtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ktp")
@CrossOrigin(origins = "*")
public class KtpController {

    @Autowired
    private KtpService ktpService;

    @GetMapping
    public List<Ktp> getAll() {
        return ktpService.getAllKtp();
    }

    @PostMapping
    public Ktp create(@RequestBody Ktp ktp) {
        return ktpService.saveKtp(ktp);
    }

    @PutMapping("/{id}")
    public Ktp update(@PathVariable Integer id, @RequestBody Ktp ktp) {
        return ktpService.updateKtp(id, ktp);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        ktpService.deleteKtp(id);
    }
}