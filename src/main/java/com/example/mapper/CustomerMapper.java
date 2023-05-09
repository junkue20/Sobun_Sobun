package com.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.dto.Customer;

@Mapper
public interface CustomerMapper {
    
    // 회원가입
    @Insert({ " INSERT INTO customer(id, pw, name, phone, email, nickname, gender) ", 
    " VALUES(#{id}, #{pw}, #{name}, #{phone}, #{email}, #{nickname}, #{gender}) " })
    public int joinCustomer(Customer customer);

    // 회원 정보 모두 불러오기
    @Select({ " SELECT m.* FROM customer m WHERE m.id=#{id} " })
    public Customer selectCustomerOne(String id);
}
