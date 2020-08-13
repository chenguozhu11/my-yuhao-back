package com.yuhao.core.service.impl;

import com.yuhao.core.entity.Menu;
import com.yuhao.core.mapper.MenuMapper;
import com.yuhao.core.service.MenuService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getChildMenusById(Menu me) {
        List<Menu> menus = menuMapper.getChildMenusById(me);
        checkData(menus);
        return menus;
    }

    public void checkData(List<Menu> menus) {
        for (Menu m : menus) {
            Menu menu = new Menu();
            menu.setParentId(m.getId());
            List<Menu> menus1 = menuMapper.getChildMenusById(menu);
            if (menus1 == null) {
                continue;
            } else {
                checkData(menus1);
            }
            m.setChildren(menus1);
        }
    }


    @Override
    public List<Menu> getChildMenusAll() {
        List<Menu> allMenus = menuMapper.getChildMenusAll();

        return buildGroupTree(allMenus);
    }

    private static List<Menu> findChildren(Menu root, List<Menu> allOrgs) {
        List<Menu> children = new ArrayList<Menu>();
        for (Menu comparedOne : allOrgs) {
            if (comparedOne.getParentId() != null && comparedOne.getParentId().equals(root.getId())) {
                children.add(comparedOne);
            }
        }
        List<Menu> notChildren = (List<Menu>) CollectionUtils.subtract(allOrgs, children);
        for (Menu child : children) {
            List<Menu> tempChild = findChildren(child, notChildren);
            if (tempChild == null) {
                tempChild = new ArrayList<Menu>();
            }
            child.setChildren(tempChild);

        }
        return children;
    }


    private static List<Menu> findRoots(List<Menu> allOrgs) {
        List<Menu> results = new ArrayList<Menu>();
        for (Menu Menu : allOrgs) {
            boolean isRoot = true;
            for (Menu comparedOne : allOrgs) {
                if (Menu.getParentId() != null && Menu.getParentId().equals(comparedOne.getId())) {
                    isRoot = false;
                    break;
                }
            }
            if (isRoot) {
                results.add(Menu);
            }
        }
        return results;
    }

    /**
     * 只组装组的 组织架构
     *
     * @param childrenOrgs
     * @param isAllOpen
     * @return
     * @throws Exception
     */
    public static List<Menu> buildGroupTree(List<Menu> childrenOrgs) {
        List<Menu> roots = findRoots(childrenOrgs);
        Iterator<Menu> iters = roots.iterator();
        Menu rootSub = null;
        //存在-1 这种企业
        while (iters.hasNext()) {
            Menu itersOrg = iters.next();
            if ("-1".equals(itersOrg.getParentId())) {
                rootSub = itersOrg;
                iters.remove();
                break;
            }

        }
        for (Menu rot : roots) {
            List<Menu> rotChilds = findChildren(rot, childrenOrgs);
            rot.setChildren(rotChilds);
        }
        if (rootSub != null) {//表示有-1这种拼接的公司节点
            rootSub.setChildren(roots);
            List<Menu> hasRoots = new ArrayList<Menu>();
            hasRoots.add(rootSub);
            return hasRoots;
        }
        return roots;

    }


}
