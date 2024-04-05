package com.example.phu_dao_sof306_sp24.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NhanVienResponse {
//    (Mã nhân viên, Tên nhân viên, Giới tính, SĐT, Tên chức vụ
    private String maNhanVien;

    private String tenNhanVien;

    private String gioiTinh;

    private String sdt;

    private String tenChucVu;
}
