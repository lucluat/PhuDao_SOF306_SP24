package com.example.phu_dao_sof306_buoi5_sp24.repository;

import com.example.phu_dao_sof306_buoi5_sp24.entity.GiaoVien;
import com.example.phu_dao_sof306_buoi5_sp24.response.GiaoVienResponse;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiaoVienRepository extends JpaRepository<GiaoVien,Integer> {

    @Query("""
        SELECT new com.example.phu_dao_sof306_buoi5_sp24.response.GiaoVienResponse(gv.ma,gv.ten,gv.ngaySinh,gv.soNamCongTac,gv.sdt,gv.email,l.ten)
        FROM GiaoVien gv
        JOIN Lop l ON gv.lop.id = l.id
""")
    List<GiaoVienResponse> getAll();

    @Query("""
        SELECT new com.example.phu_dao_sof306_buoi5_sp24.response.GiaoVienResponse(gv.ma,gv.ten,gv.ngaySinh,gv.soNamCongTac,gv.sdt,gv.email,l.ten)
        FROM GiaoVien gv
        JOIN Lop l ON gv.lop.id = l.id
""")
    List<GiaoVienResponse> getAll(Pageable pageable);

    @Transactional
    @Modifying
    @Query("""
        DELETE GiaoVien gv
        WHERE gv.ma = :ma
""")
    void delete(String ma);

}
