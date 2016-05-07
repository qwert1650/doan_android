package com.hongoctuan.admin.ungdungxemphim.DTO;

/**
 * Created by admin on 4/29/2016.
 */
public class AccountDTO {

    public String getAge() {
        return age;
    }

    public void setAge(String tuoi) {
        this.age = tuoi;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String gioitinh) {
        this.sex = gioitinh;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phone) {
        this.phoneNumber = phone;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String name) {
        this.accountName = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    int id;
    String accountName;
    String password;
    String idNumber;
    String phoneNumber;
    String sex;
    String age;
}
