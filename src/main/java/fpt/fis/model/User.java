package fpt.fis.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class User {
    @Id
    private int id;
    private String name;
    private String phoneNumber;

    @OneToMany
    private List<NguoiThan> nguoiThans;

    @OneToOne
    private ExtraInformation extraInformation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<NguoiThan> getNguoiThans() {
        return nguoiThans;
    }

    public void setNguoiThans(List<NguoiThan> nguoiThans) {
        this.nguoiThans = nguoiThans;
    }

    public ExtraInformation getExtraInformation() {
        return extraInformation;
    }

    public void setExtraInformation(ExtraInformation extraInformation) {
        this.extraInformation = extraInformation;
    }
}
