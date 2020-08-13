package com.yuhao.core.service;

import com.yuhao.core.entity.Menu;

import java.util.List;

public interface MenuService {

    public List<Menu> getChildMenusById(Menu menu);

    public List<Menu> getChildMenusAll();
}
