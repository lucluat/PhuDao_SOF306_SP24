package com.example.phudao_sof306_sp24_buoi4.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SachResponse {
//    Mã sách, Tên sách, Ngày xuất bản, Số trang, Đơn giá, Tên Nhà Xuất Bản
    private String ma;

    private String ten;

    private Date ngayXuatBan;

    private Integer soTrang;

    private Float donGia;

    private String tenNXB;
}
