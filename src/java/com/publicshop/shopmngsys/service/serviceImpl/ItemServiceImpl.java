/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.publicshop.shopmngsys.service.serviceImpl;

import com.publicshop.shopmngsys.dao.DaoFactory;
import com.publicshop.shopmngsys.dao.ItemDao;
import com.publicshop.shopmngsys.dto.ItemDto;
import com.publicshop.shopmngsys.model.ItemModel;
import com.publicshop.shopmngsys.service.ItemService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DEll
 */
public class ItemServiceImpl implements ItemService{

    @Override
    public boolean saveItem(ItemDto itemDto) {
        ItemDao itemDao=new DaoFactory().getItemDao();
        ItemModel itemModel=new ItemModel();
        itemModel.setDescription(itemDto.getDescription());
        itemModel.setUnitPrice(itemDto.getUnitPrice());
        itemModel.setQty(itemDto.getQty());
        boolean res=false;
        try {
            res=(0<itemDao.insert(itemModel));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public List<ItemDto> showItems() {
        ItemDao itemDao=new DaoFactory().getItemDao();
        ArrayList<ItemDto> alItemDtos=new ArrayList<>();
        try {
            ArrayList<ItemModel> alItemModels=(ArrayList<ItemModel>) itemDao.readAll();
            for (ItemModel alItemModel : alItemModels) {
                if (alItemModel!=null) {
                    ItemDto itemDto=new ItemDto();
                itemDto.setDescription(alItemModel.getDescription());
                itemDto.setUnitPrice(alItemModel.getUnitPrice());
                itemDto.setQty(alItemModel.getQty());
                alItemDtos.add(itemDto);
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alItemDtos;
    }

    @Override
    public boolean editItem(ItemDto itemDto) {
        ItemDao itemDao=new DaoFactory().getItemDao();
        ItemModel itemModel=new ItemModel();
        itemModel.setDescription(itemDto.getDescription());
        itemModel.setUnitPrice(itemDto.getUnitPrice());
        itemModel.setQty(itemDto.getQty());
        int res=-1;
        try {
            res=itemDao.update(itemModel);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0<res;
    }

    @Override
    public boolean deleteItem(ItemDto itemDto) {
        ItemDao itemDao=new DaoFactory().getItemDao();
        ItemModel itemModel=new ItemModel();
        itemModel.setDescription(itemDto.getDescription());
        int res=-1;
        try {
            res=itemDao.delete(itemModel);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0<res;
    }

    @Override
    public ItemDto searchItem(String name) {
        ItemDao itemDao=new DaoFactory().getItemDao();
        ItemModel item=null;
        try { 
            item=itemDao.searchItem(name);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (item!=null) {
            ItemDto itemDto=new ItemDto();
            itemDto.setDescription(item.getDescription());
            itemDto.setUnitPrice(item.getUnitPrice());
            itemDto.setQty(item.getQty());
            return itemDto;
        }else{
            return null;
        }
    }
    
}
