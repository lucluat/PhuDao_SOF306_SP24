package com.example.phudao_sof306_sp24_buoi4.repository;

import com.example.phudao_sof306_sp24_buoi4.entity.Sach;
import com.example.phudao_sof306_sp24_buoi4.response.SachResponse;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface SachRepository extends JpaRepository<Sach,Integer> {

    @Query(
            value = "SELECT new com.example.phudao_sof306_sp24_buoi4.response.SachResponse(s.ma," +
                    "s.ten,s.ngayXuatBan,s.soTrang,s.donGia,nxb.ten) " +
                    " FROM Sach s JOIN NhaXuatBan nxb ON nxb.id= s.nhaXuatBan.id"
    )
    List<SachResponse> getSachh();

    @Query(
            value = "SELECT new com.example.phudao_sof306_sp24_buoi4.response.SachResponse(s.ma," +
                    "s.ten,s.ngayXuatBan,s.soTrang,s.donGia,nxb.ten) " +
                    " FROM Sach s JOIN NhaXuatBan nxb ON nxb.id= s.nhaXuatBan.id"
    )
    List<SachResponse> getSachh(Pageable pageable);

    @Transactional
    @Modifying
    @Query(
             """
            DELETE  FROM Sach
             WHERE ma = :ma
    """ )
    void delete(@Param("ma") String ma);
}
