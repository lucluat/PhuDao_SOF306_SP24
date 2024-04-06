package com.example.phu_dao_sof306_sp24.controller;

import com.example.phu_dao_sof306_sp24.entity.ChucVu;
import com.example.phu_dao_sof306_sp24.entity.NhanVien;
import com.example.phu_dao_sof306_sp24.repository.ChucVuRepository;
import com.example.phu_dao_sof306_sp24.repository.NhanVienRepository;
import com.example.phu_dao_sof306_sp24.request.NhanVienRequest;
import com.example.phu_dao_sof306_sp24.response.NhanVienResponse;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
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

//    Viết API add 1 đối tượng nhân viên vào DB sử dụng method POST
    @PostMapping("/add")
    public String addNhanVien(@RequestBody @Valid NhanVienRequest nhanVienRequest, BindingResult bindingResult){
        try {
            if (bindingResult.hasErrors()){
                System.out.println(bindingResult.getFieldError());
                return "thêm thất bại";
            }
            NhanVien nhanVien = new NhanVien();
            nhanVien.setMa(nhanVienRequest.getMa());
            nhanVien.setTen(nhanVienRequest.getTen());
            nhanVien.setTenDem(nhanVienRequest.getTenDem());
            nhanVien.setHo(nhanVienRequest.getHo());
            nhanVien.setGioiTinh(nhanVienRequest.getGioiTinh());
            nhanVien.setNgaySinh(nhanVienRequest.getNgaySinh());
            nhanVien.setDiaChi(nhanVienRequest.getDiaChi());
            nhanVien.setSdt(nhanVienRequest.getSdt());
            nhanVien.setMatKhau(nhanVienRequest.getMatKhau());
            nhanVien.setTrangThai(nhanVienRequest.getTrangThai());
            nhanVien.setChucVu(chucVuRepository.findById(nhanVienRequest.getIdChucVu()).get());
            nhanVienRepository.save(nhanVien);
            return "thêm thành công";
        }catch (Exception e){
            e.printStackTrace();
            return "thêm thất bại";
        }

    }

//    @Viết API hiển thị danh sách nhân viên có phân trang trên
//    table 5 phần tử trên 1 trang sử dụng method GET
    @GetMapping("/phanTrang")
    public List<NhanVienResponse> phanTrang(@RequestParam(value = "currentPage",defaultValue = "0") Integer currentPage){
        Pageable pageable = PageRequest.of(currentPage,5);
        return nhanVienRepository.phanTrang(pageable);
    }

//    Viết API xóa 1 đối tượng nhân viên vào DB theo ID nhân viên sử dụng method DELETE
    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") Integer id){
        try {
            nhanVienRepository.deleteById(id);
            return "xóa thành công";
        }catch(Exception e){
            e.printStackTrace();
            return "xóa thất bại";
        }
    }
}
