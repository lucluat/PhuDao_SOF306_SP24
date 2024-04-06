package com.example.phu_dao_sof306_sp24.repository;

import com.example.phu_dao_sof306_sp24.entity.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu,Integer> {
}
