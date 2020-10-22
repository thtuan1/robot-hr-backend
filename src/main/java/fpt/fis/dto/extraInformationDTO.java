package fpt.fis.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class extraInformationDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String phongBan;
    private String soHDLD;
    private String loaiHD;
    private String heSoLuong;


    public Long getId() {
        return Id;
    }


    public void setId(Long id) {
        Id = id;
    }

    private String jodCode;
    private Date contractendDate;
    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public String getSoHDLD() {
        return soHDLD;
    }

    public void setSoHDLD(String soHDLD) {
        this.soHDLD = soHDLD;
    }

    public String getLoaiHD() {
        return loaiHD;
    }

    public void setLoaiHD(String loaiHD) {
        this.loaiHD = loaiHD;
    }

    public String getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(String heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public String getJodCode() {
        return jodCode;
    }

    public void setJodCode(String jodCode) {
        this.jodCode = jodCode;
    }

    public Date getContractendDate() {
        return contractendDate;
    }

    public void setContractendDate(Date contractendDate) {
        this.contractendDate = contractendDate;
    }



}
