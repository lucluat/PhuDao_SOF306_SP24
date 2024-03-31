package com.example.sof306_phu_dao_sp24.Buoi1.controller;

import com.example.sof306_phu_dao_sp24.Buoi1.entity.MayTinh;
import com.example.sof306_phu_dao_sp24.Buoi1.repository.MayTinhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MayTinhController {

    @Autowired
    private MayTinhRepository mayTinhRepository;

//    Viết API hiển thị  danh sách các máy tính sử dụng method GET
    @GetMapping("/all")
    public List<MayTinh> getAll(){
        return mayTinhRepository.findAll();
    }

//    Viết API Thêm 1 đối tượng máy tính sử dụng method POST
    @PostMapping("/them")
    public MayTinh createMayTinh(@RequestBody MayTinh mayTinh){
        return mayTinhRepository.save(mayTinh);
    }

//    Viết API xóa 1 đối tượng máy tính sử dụng method DELETE
    @DeleteMapping("/xoa")
    public void xoa(@RequestParam(name = "id") Integer id){
        mayTinhRepository.deleteById(id);
    }

//    Viết API Detail 1 đối tượng máy tính sử dụng method GET
    @GetMapping("/detail/{id}")
    public MayTinh detail(@PathVariable Integer id){
        return mayTinhRepository.findById(id).get();
    }

//    Viết API Update 1 đối tượng máy tính sử dụng method PUT
    @PutMapping("/update")
    public String updateMayTinh(@RequestBody MayTinh mayTinhUpdate){
        mayTinhRepository.save(mayTinhUpdate);
        return "Update Thành Công!";
    }
}
