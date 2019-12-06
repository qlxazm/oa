package com.projects.oa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Entity将类定义成被JPA管理的实体
 * @Table(name = "OA_DEPT")
 */
@Entity
@Table(name = "OA_DEPT")
public class Dept implements Serializable {
    private static final Long serialVersionUID = 678100638005497352L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", length = 50)
    private String name;

    @Column(name = "REMARK", length = 500)
    private String remark;

    /**
     * 修改人与部门之间是多对一关系
     * referencedColumnName指的是User中的属性名
     * foreignKey定义了外键约束的名称，方便以后更改
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "MODIFIER", referencedColumnName = "ID",
    foreignKey = @ForeignKey(name = "DEPT_MODIFIER"))
    private User modifier;

    public User getCreater() {
        return creater;
    }

    public void setCreater(User creater) {
        this.creater = creater;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * 创建人
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "CREATER", referencedColumnName = "ID",
            foreignKey = @ForeignKey(name = "DEPT_CREATER"))
    private User creater;

    @Column(name = "MODIFY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate;

    /**
     * @Temporal定义时间类型属性的精度
     */
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getModifier() {
        return modifier;
    }

    public void setModifier(User modifier) {
        this.modifier = modifier;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
