package com.example.phu_dao_sof306_sp24.repository;

import com.example.phu_dao_sof306_sp24.entity.NhanVien;
import com.example.phu_dao_sof306_sp24.response.NhanVienResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NhanVienRepository extends JpaRepository<NhanVien,Integer> {

    @Query("SELECT new com.example.phu_dao_sof306_sp24.response.NhanVienResponse(nv.ma,nv.ten,nv.gioiTinh,nv.sdt,nv.chucVu.ten)" +
            "FROM NhanVien nv JOIN ChucVu cv ON nv.chucVu.id = cv.id ")
    List<NhanVienResponse> listNhanVienResponse();

}