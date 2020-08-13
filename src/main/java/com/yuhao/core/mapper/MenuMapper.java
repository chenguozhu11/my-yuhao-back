package com.yuhao.core.mapper;

import com.yuhao.core.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {

    List<Menu> getChildMenusById(@Param("m") Menu menu);

    List<Menu> getChildMenusAll();
}
