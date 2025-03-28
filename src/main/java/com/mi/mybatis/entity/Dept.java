package com.mi.mybatis.entity;

import java.util.List;

public class Dept {

    private Long did;

    private String deptName;

    private List<Emp> emps;

    public Dept() {
    }

    public Dept(Long did, String deptName) {
        this.did = did;
        this.deptName = deptName;
    }

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", deptName='" + deptName + '\'' +
                ", emps=" + emps +
                '}';
    }
}
