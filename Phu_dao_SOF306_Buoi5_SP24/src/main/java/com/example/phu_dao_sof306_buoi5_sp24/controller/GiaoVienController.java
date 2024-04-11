package com.example.phu_dao_sof306_buoi5_sp24.controller;

import com.example.phu_dao_sof306_buoi5_sp24.entity.GiaoVien;
import com.example.phu_dao_sof306_buoi5_sp24.repository.GiaoVienRepository;
import com.example.phu_dao_sof306_buoi5_sp24.request.GiaoVienRequest;
import com.example.phu_dao_sof306_buoi5_sp24.response.GiaoVienResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
public class GiaoVienController {

    @Autowired
    private GiaoVienRepository giaoVienRepository;

    @GetMapping("/all")
    public List<GiaoVienResponse> getAll(){
        return giaoVienRepository.getAll();
    }

    @GetMapping("/phantrang")
    public List<GiaoVienResponse> phanTrang(@RequestParam(value = "currentPage",defaultValue = "0") Integer currentPage){
        int pageSize = 5;
        Pageable pageable = PageRequest.of(currentPage,pageSize);
        return giaoVienRepository.getAll(pageable);
    }

    @PostMapping("/add")
    public String themGiaoVien(@RequestBody GiaoVien giaoVien){
        GiaoVien gv = giaoVienRepository.save(giaoVien);
        if (gv==null){
            return "them giao vien that bai";
        }
        return "them thanh cong";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("ma") String ma){
        try{
            int check =0;
            for (GiaoVienResponse x: giaoVienRepository.getAll()){
                if (x.getMa().equalsIgnoreCase(ma)){
                    check =1;
                    break;
                }
            }
            if (check ==0){
                return "ma khong ton tai";
            }
            giaoVienRepository.delete(ma);
            return "xoa thanh cong";
        }catch (Exception e){
            return "xoa that bai";
        }
    }

    @PutMapping("/update")
    public String update (@RequestBody @Valid GiaoVienRequest giaoVienRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "update that bai";
        }
        GiaoVien gv= new GiaoVien();
        gv.setId(giaoVienRequest.getId());
        gv.setMa(giaoVienRequest.getMa());
        gv.setTen(giaoVienRequest.getTen());
        gv.setNgaySinh(giaoVienRequest.getNgaySinh());
        gv.setGioiTinh(giaoVienRequest.getGioiTinh());
        gv.setSoNamCongTac(giaoVienRequest.getSoNamCongTac());
        gv.setDiaChi(giaoVienRequest.getDiaChi());
        gv.setSdt(giaoVienRequest.getSdt());
        gv.setEmail(giaoVienRequest.getEmail());
        gv.setLop(giaoVienRequest.getLop());
        GiaoVien giaoVien= giaoVienRepository.save(gv);
        if (giaoVien ==null){
            return "update that bai";
        }
        return "update thanh cong";
    }
    @GetMapping("/loctenlop")
    public List<GiaoVienResponse> locTenLop() {
        return giaoVienRepository.getAll()
                .stream().filter(gv -> gv.getTenLop().startsWith("SD"))
                .toList();
    }

    @GetMapping("/namcongtac")
    public List<GiaoVienResponse> sepXep() {
        return giaoVienRepository.getAll()
                .stream()
                .sorted(Comparator.comparing(GiaoVienResponse::getSoNamCongTac).reversed())
                .toList();
    }

    @GetMapping("/loc")
    public List<GiaoVienResponse> locsepXep() {
        return giaoVienRepository.getAll()
                .stream()
                .filter(item -> item.getTenLop().contains("IT"))
                .filter(item -> item.getSoNamCongTac() >= 10 && item.getSoNamCongTac() <= 20)
                .toList();
    }
}
