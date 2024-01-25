package com.ohgiraffers.model.service;

import com.ohgiraffers.mapper.OrderMapper;
import com.ohgiraffers.model.DTO.TicketDTO;
import org.apache.ibatis.session.SqlSession;

import static com.ohgiraffers.common.OrderTemplate.getOrderSqlSession;

public class OrderService {

    private OrderMapper orderMapper;

    public void insertOrder(TicketDTO ticketDTO) {
        SqlSession sqlSession = getOrderSqlSession();

        orderMapper = sqlSession.getMapper(OrderMapper.class);
        int result = orderMapper.insertOrder(ticketDTO);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
    }
}