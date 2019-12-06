package com.projects.oa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "OA_JOB")
public class Job implements Serializable {

    @Id
    @Column(name = "CODE", length = 100)
    private String code;

    @Column(name = "NAME", length = 50)
    private String name;

    @Column(name = "REMARK", length = 50)
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
