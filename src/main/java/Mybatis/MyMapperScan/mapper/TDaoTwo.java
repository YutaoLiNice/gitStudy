package Mybatis.MyMapperScan.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface TDaoTwo {

    @Select("select * from member where id=3")
    public List query();

    @Select("select * from xxx")
    public List<Map<String,Object>> list();
}
