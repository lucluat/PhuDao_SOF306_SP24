package com.example.phudao_sof306_sp24_buoi4.controller;

import com.example.phudao_sof306_sp24_buoi4.entity.Sach;
import com.example.phudao_sof306_sp24_buoi4.repository.NhaXuatBanRepository;
import com.example.phudao_sof306_sp24_buoi4.repository.SachRepository;
import com.example.phudao_sof306_sp24_buoi4.request.SachRequest;
import com.example.phudao_sof306_sp24_buoi4.response.SachResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
public class SachController {

    @Autowired
    private SachRepository sachRepository;

    @Autowired
    private NhaXuatBanRepository nhaXuatBanRepository;

//    Viết API hiển thị danh sách Sách gồm (Mã sách, Tên sách,
//    Ngày xuất bản, Số trang, Đơn giá, Tên Nhà Xuất Bản)  sử dụng method GET
    @GetMapping("/get-all")
    public List<SachResponse> getAll(){
        return sachRepository.getSachh();
    }

    @GetMapping("/phan-trang")
    public List<SachResponse> phanTrang(@RequestParam("currentPage") Integer currentPage ){
        // số phần tử trên 1 trang
        int pageSize = 5;
        Pageable pageable = PageRequest.of(currentPage,pageSize);
        return sachRepository.getSachh(pageable);
    }
//    Viết API add 1 đối tượng Sách vào DB sử dụng
//    method POST (có sử dụng request )
    @PostMapping("/add")
    public String add (@RequestBody @Valid SachRequest sachRequest , BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError());
            return "them sach that bai";
        }else{
            Sach sach = new Sach();
            sach.setMa(sachRequest.getMa());
            sach.setTen(sachRequest.getTen());
            sach.setNhaXuatBan(nhaXuatBanRepository.findById(sachRequest.getIdNhaXuatBan()).get());
            sach.setSoTrang(sachRequest.getSoTrang());
            sach.setDonGia(sachRequest.getDonGia());
            sach.setNgayXuatBan(sachRequest.getNgayXuatBan());
            sach.setTrangThai(sachRequest.getTrangThai());
            Sach newSach = sachRepository.save(sach);
            if (newSach == null){
                return "thêm sách thất bại";
            }else{
                return "thêm sách thành công";
            }
        }
    }

//    Viết API update 1 đối tượng Sách
//    sử dụng method PUT (có sử dụng request )
    @PutMapping("/update")
    public String update(@RequestBody SachRequest sachRequest){
       try {
           Sach sach = new Sach();
           sach.setId(sachRequest.getId());
           sach.setMa(sachRequest.getMa());
           sach.setTen(sachRequest.getTen());
           sach.setNhaXuatBan(nhaXuatBanRepository.findById(sachRequest.getIdNhaXuatBan()).get());
           sach.setSoTrang(sachRequest.getSoTrang());
           sach.setDonGia(sachRequest.getDonGia());
           sach.setNgayXuatBan(sachRequest.getNgayXuatBan());
           sach.setTrangThai(sachRequest.getTrangThai());
           sachRepository.save(sach);
           return "update thành công";
       }catch (Exception e){
           return "update thất bại";
       }
    }
    //        Viết API xóa 1 đối tượng Sách
//        theo Mã Sách sử dụng method DELETE
   @DeleteMapping("/delete/{ma}")
    public String delete(@PathVariable("ma")String ma){
        try {
            sachRepository.delete(ma);
            return "xoa thành công";
        }catch (Exception e){
            return "xoa thất bại";
        }
   }

   @GetMapping("/detail")
    public Sach detail(@RequestParam("id") Integer id){
        return sachRepository.findById(id).get();
   }

    @GetMapping("/list-sach-nguyen-van-an")
    public List<SachResponse> listSachTenNguyenVanAn(){
        return sachRepository.getSachh().stream()
                .filter(item -> item.getTenNXB().equalsIgnoreCase("Nguyễn Văn An")).toList();
    }

    @GetMapping("/sap-xep")
    public List<SachResponse> sapXep(){
        return sachRepository.getSachh().stream()
                .sorted(Comparator.comparing(SachResponse::getDonGia).reversed())
                .toList();
    }

    @GetMapping("/loc-sach")
    public List<SachResponse> locSach(){
        return sachRepository.getSachh()
                .stream()
                .filter(item -> item.getTenNXB().contains("a"))
                .filter(item -> item.getDonGia()>=100 && item.getDonGia()<=200)
                .toList();
    }

}
