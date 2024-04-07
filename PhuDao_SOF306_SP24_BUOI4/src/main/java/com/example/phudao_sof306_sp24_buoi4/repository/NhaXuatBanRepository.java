package com.example.phudao_sof306_sp24_buoi4.repository;

import com.example.phudao_sof306_sp24_buoi4.entity.NhaXuatBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhaXuatBanRepository extends JpaRepository<NhaXuatBan,Integer> {
}
