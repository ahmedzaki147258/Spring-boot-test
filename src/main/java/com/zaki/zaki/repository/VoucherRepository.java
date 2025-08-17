package com.zaki.zaki.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zaki.zaki.model.Voucher;

public interface VoucherRepository extends JpaRepository<Voucher, Long> {
    Voucher findByCode(String code);
}
