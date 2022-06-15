package com.example.listingapp.dto;

import com.example.listingapp.model.UserListen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserListenDAO {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @SuppressWarnings("unchecked")
    public List<UserListen> allUserListen(Integer price){
        System.out.println("beginquery");
        String query = "SELECT u.name, l.description " +
                "FROM `listing_app`.user u   " +
                "JOIN `listing_app`.`listing` l ON l.user_id = u.id " +
                "join listing_app.category c on l.category_id=c.id" +
                " where l.price > "+ price +" and c.name='Auto'";
        System.out.println("endquery");



        return  jdbcTemplate.query(query, new BeanPropertyRowMapper(UserListen.class));




    }


}
