package com.ohgiraffers.model.service;

import com.ohgiraffers.mapper.OrderMapper;
import org.apache.ibatis.session.SqlSession;

import static com.ohgiraffers.common.OrderTemplate.getOrderSqlSession;

public class OrderService {

    private OrderMapper orderMapper;

    public void insertOrder(String ticketNum, String id, String startStation, String endStation, String departureTime, int billingAmount, String paymentMethod, int totalAmount) {
        SqlSession sqlSession = getOrderSqlSession();

        orderMapper = sqlSession.getMapper(OrderMapper.class);
        int result = orderMapper.insertOrder(ticketNum, id, startStation, endStation, departureTime, billingAmount, paymentMethod, totalAmount);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
    }
}