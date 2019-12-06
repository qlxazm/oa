package com.projects.oa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @Table注解的indexes属性指定了创建的注解以及注解的名称
 */
@Entity
@Table(name = "OA_USER",
indexes = {@Index(columnList = "NAME", name = "IDX_USER_NAME")})
public class User implements Serializable {
    @Id
    @Column(name = "ID", length = 50)
    private String id;

    @Column(name = "PASSWORD", length = 50)
    private String passWord;

    @Column(name = "NAME", length = 50)
    private String name;

    @Column(name = "SEX")
    private Short sex = 1;

    /**
     * 用户与部门之间是多对一关系
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Dept.class)
    @JoinColumn(name = "DEPT_ID", referencedColumnName = "ID",
    foreignKey = @ForeignKey(name = "USER_DEPT"))
    private Dept dept;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Job.class)
    @JoinColumn(name = "JOB_ID", referencedColumnName = "CODE",
    foreignKey = @ForeignKey(name = "USER_JOB"))
    private Job job;

    @Column(name = "EMAIL", length = 50)
    private String email;

    /**
     * 固定电话
     */
    @Column(name = "TEL", length = 50)
    private String tel;

    @Column(name = "PHONE", length = 50)
    private String phone;

    @Column(name = "QQ_NUM", length = 20)
    private String qqNum;

    public String getQqNum() {
        return qqNum;
    }

    public void setQqNum(String qqNum) {
        this.qqNum = qqNum;
    }

    /**
     * 问题编号
     */
    @Column(name = "QUESTION")
    private Short question;

    /**
     * 问题回答
     */
    @Column(name = "ANSWER", length = 200)
    private String answer;

    /**
     * 状态 0 新建 1 审核 2 不通过审核 3 冻结
     */
    @Column(name = "STATUS")
    private Short status = 0;

    /**
     * 用户创建人
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "CREATER", referencedColumnName = "ID",
    foreignKey = @ForeignKey(name = "USER_CREATER"))
    private User creater;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "MODIFIER", referencedColumnName = "ID",
            foreignKey = @ForeignKey(name = "USER_MODIFIER"))
    private User modifier;

    /**
     * 修改时间
     */
    @Column(name = "MODIFY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    /**
     * 审核人
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "CHECKER", referencedColumnName = "ID",
    foreignKey = @ForeignKey(name = "USER_CHECKER"))
    private User checker;

    /**
     * 审核时间
     */
    @Column(name = "CHECK_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkDate;

    /**
     * 用户与角色之间是多对多关系
     */
    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Role.class, mappedBy = "users")
    private Set<Role> roles = new HashSet<>();

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Short getQuestion() {
        return question;
    }

    public void setQuestion(Short question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
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

    public User getChecker() {
        return checker;
    }

    public void setChecker(User checker) {
        this.checker = checker;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
