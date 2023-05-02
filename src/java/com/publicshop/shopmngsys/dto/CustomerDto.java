/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.publicshop.shopmngsys.dto;

/**
 *
 * @author DEll
 */
public class CustomerDto {
    private String name;
    private String password;
    private int mobile;

    public CustomerDto() {
    }

    public CustomerDto(String name, String password, int mobile) {
        this.name = name;
        this.password = password;
        this.mobile = mobile;
    }
    public CustomerDto(String name, String password) {
        this.name = name;
        this.password = password;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the mobile
     */
    public int getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(int mobile) {
        this.mobile = mobile;
    }
    
}
