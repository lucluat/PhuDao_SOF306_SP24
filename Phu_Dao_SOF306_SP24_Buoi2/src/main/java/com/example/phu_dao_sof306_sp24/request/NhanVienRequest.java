package com.example.phu_dao_sof306_sp24.request;

import com.example.phu_dao_sof306_sp24.entity.ChucVu;
import com.example.phu_dao_sof306_sp24.entity.NhanVien;
import com.example.phu_dao_sof306_sp24.repository.ChucVuRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import jdk.jfr.Registered;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    @NotBlank(message = "ten đệm khong duoc trong")
    private String tenDem;

    @NotBlank(message = "ho khong duoc trong")
    private String ho;

    @NotBlank(message = "gioi tinh đệm khong duoc trong")
    private String gioiTinh;

    @NotNull(message = "ngay sinh khong duoc trong")
    private Date ngaySinh;

    @NotBlank(message = "dia chi khong duoc trong")
    private String diaChi;

    @NotBlank(message = "ten đệm khong duoc trong")
    private String sdt;

    @NotBlank(message = "ten đệm khong duoc trong")
    private String matKhau;

    @Min(value = 0,message = "trang thai ko dc < 0")
    @Max(value = 1,message = "trang thai ko đc >1")
    @NotNull(message = "trang thai ko dc null")
    private Integer trangThai;

    @Min(value = 1,message = "min ko dc nhỏ hon 1 ok chưa")
    private Integer idChucVu;


}
