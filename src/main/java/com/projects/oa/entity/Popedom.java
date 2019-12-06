package com.projects.oa.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 权限表
 */
@Entity
@Table(name = "OA_POPEDOM")
public class Popedom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    /**
     * 权限和模块是多对一关系
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Module.class)
    @JoinColumn(name = "MODULE_CODE", referencedColumnName = "CODE",
    foreignKey = @ForeignKey(name = "POPEDOM_MODULE"))
    private Module module;

    /**
     * 权限和操作存在多对一关系
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Module.class)
    @JoinColumn(name = "OPERA_CODE", referencedColumnName = "CODE",
            foreignKey = @ForeignKey(name = "POPEDOM_OPERA"))
    private Module opera;

    /**
     * 权限与角色是多对一关系
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Role.class)
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID",
    foreignKey = @ForeignKey(name = "POPEDOM_ROLE"))
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "CREATER", referencedColumnName = "ID",
    foreignKey = @ForeignKey(name = "POPEDOM_CREATER"))
    private User creater;

    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creatDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Module getOpera() {
        return opera;
    }

    public void setOpera(Module opera) {
        this.opera = opera;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getCreater() {
        return creater;
    }

    public void setCreater(User creater) {
        this.creater = creater;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }
}
