package com.zaki.zaki.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;
    private BigDecimal discount;
    private String expire_date;

    public long getId() {
        return id;
    }
    public String getCode() {
        return code;
    }
    public BigDecimal getDiscount() {
        return discount;
    }
    public String getExpire_date() {
        return expire_date;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
    public void setExpire_date(String expire_date) {
        this.expire_date = expire_date;
    }
}
