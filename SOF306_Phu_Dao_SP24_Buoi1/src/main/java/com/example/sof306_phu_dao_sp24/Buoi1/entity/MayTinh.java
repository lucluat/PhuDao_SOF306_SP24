package com.example.sof306_phu_dao_sp24.Buoi1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "may_tinh")
@Getter
@Setter
public class MayTinh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "gia")
    private Float gia;

    @Column(name = "bo_nho")
    private String boNho;

    @Column(name = "mau_sac")
    private String mauSac;

    @Column(name = "hang")
    private String hang;

    @Column(name = "mieu_ta")
    private String mieuTa;

}
