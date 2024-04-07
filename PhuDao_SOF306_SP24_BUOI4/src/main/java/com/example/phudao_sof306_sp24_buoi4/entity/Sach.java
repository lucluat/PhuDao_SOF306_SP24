package com.example.phudao_sof306_sp24_buoi4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Sach")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "NgayXuatBan")
    private Date ngayXuatBan;

    @Column(name = "SoTrang")
    private Integer soTrang;

    @Column(name = "DonGia")
    private Float donGia;

    @ManyToOne
    @JoinColumn(name = "IdNXB")
    private NhaXuatBan nhaXuatBan;

    @Column(name = "TrangThai")
    private Integer trangThai;

}
