/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.publicshop.shopmngsys.service;

import com.publicshop.shopmngsys.dto.AdminDto;

/**
 *
 * @author DEll
 */
public interface AdminService {
    public AdminDto findAdmin(String name,String password);
}
