package Mybatis.MyMapperScan.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface  TDao {


    @Select("select * from member")
   public List<Map<String,Object>> list();

    public String  toString();
}
