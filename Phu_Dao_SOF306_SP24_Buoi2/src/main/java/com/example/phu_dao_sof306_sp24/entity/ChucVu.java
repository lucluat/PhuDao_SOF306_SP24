package com.example.phu_dao_sof306_sp24.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ChucVu")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChucVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;
}
