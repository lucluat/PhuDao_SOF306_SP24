package com.example.phu_dao_sof306_sp24.controller;

import com.example.phu_dao_sof306_sp24.entity.NhanVien;
import com.example.phu_dao_sof306_sp24.repository.NhanVienRepository;
import com.example.phu_dao_sof306_sp24.response.NhanVienResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NhanVienController {

    @Autowired
    private NhanVienRepository nhanVienRepository;

//    Viết API hiển thị danh sách nhân viên gồm
//    (Mã nhân viên, Tên nhân viên, Giới tính, SĐT, Tên chức vụ)
//    sử dụng method GET
    @GetMapping("/get-all")
    public List<NhanVienResponse> getAll(){
        return nhanVienRepository.listNhanVienResponse();
    }

//    Viết API add 1 đối tượng nhân viên vào DB sử dụng method POST
    @PostMapping("/add")
    public String addNhanVien(@RequestBody NhanVien nhanVien){
        nhanVienRepository.save(nhanVien);
        return "them thanh cong";
    }
}
