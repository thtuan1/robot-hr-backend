package fpt.fis.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NguoiThan {
    @Id
    private int id;
    private String name;
    private String relationship;

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

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
}
