package com.zlm.homework0703.mapper;

import com.zlm.homework0703.model.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderMapper {

    /**
     * 写
     *
     * @param order 订单
     * @return 数量
     */
    @Insert("insert into t_order(id,user_id,product_id,price,create_time,pay_time) values(#{id},#{user_id},#{product_id},#{price},#{create_time},#{pay_time})")
    int insert(Order order);

    /**
     * 读
     *
     * @param id 主键
     * @return Order
     */
    @Select("select id,user_id,product_id,price,create_time,pay_time from t_order where id = #{id}")
    Order selectOne(int id);
}
