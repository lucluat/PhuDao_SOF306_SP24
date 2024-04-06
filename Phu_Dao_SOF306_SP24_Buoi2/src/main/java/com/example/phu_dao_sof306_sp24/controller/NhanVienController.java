package com.example.phu_dao_sof306_sp24.controller;

import com.example.phu_dao_sof306_sp24.entity.NhanVien;
import com.example.phu_dao_sof306_sp24.repository.ChucVuRepository;
import com.example.phu_dao_sof306_sp24.repository.NhanVienRepository;
import com.example.phu_dao_sof306_sp24.request.NhanVienRequest;
import com.example.phu_dao_sof306_sp24.response.NhanVienResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NhanVienController {


    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private ChucVuRepository chucVuRepository;

//    Viết API hiển thị danh sách nhân viên gồm
//    (Mã nhân viên, Tên nhân viên, Giới tính, SĐT, Tên chức vụ)
//    sử dụng method GET
    @GetMapping("/get-all")
    public List<NhanVienResponse> getAll(){
        return nhanVienRepository.listNhanVienResponse();
    }

    //Viết API add 1 đối tượng nhân viên vào DB sử dụng method POST
    @PostMapping("/add")
    public String addNhanVien(@RequestBody @Valid NhanVienRequest nhanVienRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError());
            return "them nhan vien that bai";
        } else{
            NhanVien nhanVien = new NhanVien();
            nhanVien.setMa(nhanVienRequest.getMa());
            nhanVien.setTen(nhanVienRequest.getTen());
            nhanVien.setTenDem(nhanVienRequest.getTenDem());
            nhanVien.setHo(nhanVienRequest.getHo());
            nhanVien.setGioiTinh(nhanVienRequest.getGioiTinh());
            nhanVien.setDiaChi(nhanVienRequest.getDiaChi());
            nhanVien.setSdt(nhanVienRequest.getSdt());
            nhanVien.setNgaySinh(nhanVienRequest.getNgaySinh());
            nhanVien.setMatKhau(nhanVienRequest.getMatKhau());
            nhanVien.setTrangThai(nhanVienRequest.getTrangThai());
            nhanVien.setChucVu(chucVuRepository.findById(nhanVienRequest.getIdChucVu()).get());

            NhanVien nv = nhanVienRepository.save(nhanVien);
            if (nv==null){
                return "thêm nhân viên thất bại";
            }else {
                return "thêm nhân viên thành công";
            }
        }
    }

    //detail
    @GetMapping("/detail")
    public NhanVien detail(@RequestParam("id") Integer id){
        return nhanVienRepository.findById(id).get();
    }

    //update
    @PutMapping("/update")
    public String update(@RequestBody NhanVien nhanVien){
        NhanVien nv = nhanVienRepository.save(nhanVien);
        if (nv == null){
            return "update nhanh vien thất bại";
        }else{
            return "update nhan vien thanh cong";
        }
    }

//    Viết API xóa 1 đối tượng nhân viên vào DB theo
//    ID nhân viên sử dụng method DELETE
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        nhanVienRepository.deleteById(id);
    }

//    Viết API hiển thị danh sách nhân viên có phân trang
//    trên table 5 phần tử trên 1 trang sử dụng method GET
    @GetMapping("/phan-trang")
    public List<NhanVienResponse> phanTrang(@RequestParam(value = "currentPage",required = false,defaultValue = "0") Integer currentPage){
        //số phần tử trên 1 trang
        int pageSize = 5;
        Pageable pageable = PageRequest.of(currentPage,pageSize);
        return nhanVienRepository.listNhanVienResponse(pageable).getContent();
    }
}
