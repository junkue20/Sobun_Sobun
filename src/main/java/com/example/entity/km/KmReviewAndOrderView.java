package com.example.entity.km;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.data.annotation.Immutable;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Immutable // 뷰일경우 추가 => 조회만 가능한 엔티티
@Entity
@Table(name = "KMREVIEWANDORDERVIEW")
public class KmReviewAndOrderView {

    @Id
    @Column(name = "reviewno")
    private BigDecimal reviewno;

    @Column(name = "rating")
    private BigDecimal rating;

    @Lob
    @Column(name = "comment")
    private String comment;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Column(name = "reviewdate")
    private Date reviewdate;
    
    @Column(name = "itemno")
    private BigDecimal itemno;

    @Column(name = "orderno")
    private String orderno;

    @Column(name = "memid")
    private String memid;

    @Column(name = "purchaseno")
    private BigDecimal purchaseno;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Column(name = "orderdate")
    private Date orderdate;

    @Column(name = "totalprice")
    private BigDecimal totalprice;

    @Column(name = "orderstate")
    private BigDecimal orderstate;
}
