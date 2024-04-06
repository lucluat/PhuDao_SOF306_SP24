package com.example.phu_dao_sof306_sp24.request;

import com.example.phu_dao_sof306_sp24.entity.ChucVu;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVienRequest {

    @NotBlank(message = "ma khong duoc trong")
    private String ma;

    @NotBlank(message = "ten khong duoc trong")
    private String ten;

    @NotBlank(message = "ten dem khong duoc trong")
    private String tenDem;

    @NotBlank(message = "ho khong duoc trong")
    @Column(name = "Ho")
    private String ho;

    @NotBlank(message = "gioi tinh khong duoc trong")
    @Column(name = "GioiTinh")
    private String gioiTinh;

    @NotNull(message = "ngay sinh khong duoc trong")
    private Date ngaySinh;

    @NotBlank(message = "dia chi tinh khong duoc trong")
    private String diaChi;

    @NotBlank(message = "sdt tinh khong duoc trong")
    private String sdt;

    @NotBlank(message = "mat khau khong duoc trong")
    private String matKhau;

    @NotNull(message = "chuc vu khong duoc trong")
    private Integer idChucVu;

    @NotNull(message = "trang thai khong được trống")
    private Integer trangThai;

}
