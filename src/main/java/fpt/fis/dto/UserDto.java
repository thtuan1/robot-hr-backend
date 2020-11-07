package fpt.fis.dto;

import java.util.Date;

public class UserDto {

    private  Long Id;
    private  String userName;
    private  String password;
    private Date createdTime;
    private  Date updatedTime;
    private  String nguoiTao;
    private  String nguoiUpdate;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public String getNguoiUpdate() {
        return nguoiUpdate;
    }

    public void setNguoiUpdate(String nguoiUpdate) {
        this.nguoiUpdate = nguoiUpdate;
    }
}
