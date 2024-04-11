package com.example.phu_dao_sof306_buoi5_sp24.response;

import com.example.phu_dao_sof306_buoi5_sp24.entity.Lop;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GiaoVienResponse {

    private String ma;

    private String ten;

    private Date ngaySinh;

    private Integer soNamCongTac;

    private String sdt;

    private String email;

    private String tenLop;

}
