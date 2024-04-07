package com.example.phudao_sof306_sp24_buoi4.request;

import com.example.phudao_sof306_sp24_buoi4.entity.NhaXuatBan;
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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SachRequest {

    private Integer id;

    @NotBlank(message = "ma khong duoc trong")
    private String ma;

    @NotBlank(message = "ten khong duoc trong")
    private String ten;

    @NotNull(message = "ngay xuat ban khong duoc trong")
    private Date ngayXuatBan;

    @NotNull(message = "so trang khong duoc trong")
    private Integer soTrang;

    @NotNull(message = "don gia khong duoc trong")
    private Float donGia;

    @NotNull(message = "id nha xuat ban khong duoc trong")
    private Integer idNhaXuatBan;

    @NotNull(message = "trang thai  khong duoc trong")
    private Integer trangThai;

}
