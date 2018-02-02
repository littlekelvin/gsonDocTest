package com.oocl.ir4.doc.entity;

import javax.persistence.Entity;

@Entity
public class Partner {
    private int pid;
    private String name;
    private String phone;

    public Partner() {
    }

    public Partner(int pid, String name, String phone) {
        this.pid = pid;
        this.name = name;
        this.phone = phone;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Partner{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
