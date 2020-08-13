package com.yuhao.core.controller;

import com.yuhao.core.entity.Menu;
import com.yuhao.core.service.MenuService;
import com.yuhao.core.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ResponseBody
    @GetMapping("/getChildMenus")
    public ResponseUtil getChildMenusById(Menu menu) {
        if (menu == null) {
            return new ResponseUtil(ResponseUtil.ResponseRet.ERROR, "null");
        }
        return new ResponseUtil(ResponseUtil.ResponseRet.NORMAL, "操作成功", menuService.getChildMenusById(menu));
    }

    @ResponseBody
    @GetMapping("/getChildMenusAll")
    public ResponseUtil getChildMenusAll() {

        return new ResponseUtil(ResponseUtil.ResponseRet.NORMAL, "操作成功", menuService.getChildMenusAll());
    }
}
