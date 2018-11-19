package com.xym.entities;

/**
 * @ClassName Address
 * @Description TODO
 * @Author ak
 * @Date 2018/11/18 下午10:34
 * @Version 1.0
 **/
public class Address {
    private String schoolAddress;
    private String homeAddress;

    @Override
    public String toString() {
        return "Address{" +
                "schoolAddress='" + schoolAddress + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                '}';
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
}