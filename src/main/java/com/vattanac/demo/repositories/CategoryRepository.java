package com.vattanac.demo.repositories;

import com.vattanac.demo.models.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository {
    @Select("select* from tbl_category order by id")
    List<Category> getAll();

    @Select("select count(*) from tbl_category")
    Integer count();

    @Select("select * from tbl_category  where id=#{id} ")
    Category findOne(Integer id);
    @Insert("insert into tbl_category(name) values(#{name}) ")
    boolean add(Category model);
    @Update("Update tbl_category  set name=#{name} where id=#{id}")
    boolean update(Category model);
    @Delete("delete from tbl_category  where id=#{id}")
    boolean delete(Integer id);
    @Select("select * from tbl_category where lower(name)=#{name}")
    List<Category> isExisted(String name);

}
