/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.publicshop.shopmngsys.service;

import com.publicshop.shopmngsys.dto.ItemDto;
import com.publicshop.shopmngsys.model.ItemModel;
import java.util.List;

/**
 *
 * @author DEll
 */
public interface ItemService {
    public boolean saveItem(ItemDto itemDto);
    public List<ItemDto> showItems();
    public boolean editItem(ItemDto itemDto);
    public boolean deleteItem(ItemDto itemDto);
    public ItemDto searchItem(String name);
}
