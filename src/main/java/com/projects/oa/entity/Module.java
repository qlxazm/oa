package com.projects.oa.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "OA_MODULE")
public class Module {

    @Id
    @Column(name = "CODE", length = 100)
    private String code;

    @Column(name = "NAME", length = 50)
    private String name;

    @Column(name = "URL", length = 50)
    private String url;

    @Column(name = "REMARK", length = 500)
    private String remark;

    /**
     * 创建人
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "CREATER", referencedColumnName = "ID",
            foreignKey = @ForeignKey(name = "MODULE_CREATER"))
    private User creater;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "MODIFIER", referencedColumnName = "ID",
            foreignKey = @ForeignKey(name = "MODULE_MODIFIER"))
    private User modifier;

    /**
     * 修改时间
     */
    @Column(name = "MODIFY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate;


    /**
     * 审核时间
     */
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public User getCreater() {
        return creater;
    }

    public void setCreater(User creater) {
        this.creater = creater;
    }

    public User getModifier() {
        return modifier;
    }

    public void setModifier(User modifier) {
        this.modifier = modifier;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
