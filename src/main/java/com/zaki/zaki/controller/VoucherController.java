package com.zaki.zaki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.zaki.zaki.model.Voucher;
import com.zaki.zaki.repository.VoucherRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/vouchers")
public class VoucherController {
    @Autowired
    private VoucherRepository voucherRepository;

    @GetMapping()
    public List<Voucher> getAllVouchers() {
        return voucherRepository.findAll();
    }

    @GetMapping("/{code}")
    public Voucher getOneVoucher(@PathVariable("code") String code) {
        return voucherRepository.findByCode(code);
    }

    @PostMapping()
    public Voucher createVoucher(@RequestBody Voucher voucher) {
        return voucherRepository.save(voucher);
    }   

    @PatchMapping("/{id}")
    public Voucher updateVoucher(@PathVariable("id") long id, @RequestBody Voucher voucher) {
        Voucher voucherToUpdate = voucherRepository.findById(id).get();
        voucherToUpdate.setCode(voucher.getCode());
        voucherToUpdate.setDiscount(voucher.getDiscount());
        return voucherRepository.save(voucherToUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteVoucher(@PathVariable("id") long id) {
        voucherRepository.deleteById(id);
    }
}
