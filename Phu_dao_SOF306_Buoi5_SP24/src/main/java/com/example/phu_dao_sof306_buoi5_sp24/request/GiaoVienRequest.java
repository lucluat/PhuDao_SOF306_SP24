package com.example.phu_dao_sof306_buoi5_sp24.request;

import com.example.phu_dao_sof306_buoi5_sp24.entity.Lop;
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
public class GiaoVienRequest {

    @NotNull(message = "id ko dc trong")
    private Integer id;

    @NotBlank(message = "ma ko dc trong")
    private String ma;

    @NotBlank(message = "ten ko dc trong")
    private String ten;

    @NotNull(message = "ngay sinh ko dc trong")
    private Date ngaySinh;

    @NotBlank(message = "gioi tinh ko dc trong")
    private String gioiTinh;

    @NotNull(message = "so nam cong tac sinh ko dc trong")
    private Integer soNamCongTac;

    @NotBlank(message = "dia ko dc trong")
    private String diaChi;

    @NotBlank(message = "sdt ko dc trong")
    private String sdt;

    @NotBlank(message = "email ko dc trong")
    private String email;

    @NotNull(message = "lop sinh ko dc trong")
    private Lop lop;
}
