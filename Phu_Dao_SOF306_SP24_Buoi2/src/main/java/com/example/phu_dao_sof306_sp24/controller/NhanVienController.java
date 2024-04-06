package com.example.phu_dao_sof306_sp24.controller;

import com.example.phu_dao_sof306_sp24.repository.NhanVienRepository;
import com.example.phu_dao_sof306_sp24.response.NhanVienResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NhanVienController {

    @Autowired
    private ChucVuRepository chucVuRepository;

    @Autowired
    private NhanVienRepository nhanVienRepository;

//    Viết API hiển thị danh sách nhân viên gồm
//    (Mã nhân viên, Tên nhân viên, Giới tính, SĐT, Tên chức vụ)
//    sử dụng method GET
    @GetMapping("/get-all")
    public List<NhanVienResponse> getAll(){
        return nhanVienRepository.listNhanVienResponse();
    }


}
