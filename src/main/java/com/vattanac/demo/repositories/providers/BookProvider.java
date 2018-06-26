package com.vattanac.demo.repositories.providers;

import com.vattanac.demo.models.Book;
import org.apache.ibatis.jdbc.SQL;

public class BookProvider {

    public String getAllProvider(){
        return new SQL(){{
            SELECT("*");
            FROM("tbl_book b");
            INNER_JOIN("tbl_category c  ON b.cate_id=c.id");
            ORDER_BY("b.id desc");
        }}.toString();
    }

    public String create(Book book){
        return new SQL(){{
            INSERT_INTO("tbl_book");
            VALUES("title","#{title}");
            VALUES("author","#{author}");
            VALUES("publisher","#{publisher}");
            VALUES("thumbnail","#{thumbnail}");
            VALUES("cate_id","#{category.id}");

        }}.toString();
    }


//    public  String bookFilterProvider(Boo)



}
