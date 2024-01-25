package com.ohgiraffers.model.service;

import com.ohgiraffers.mapper.ProductMapper;
import com.ohgiraffers.model.DTO.TicketDTO;
import org.apache.ibatis.session.SqlSession;

import static com.ohgiraffers.common.ProductTemplate.getProductSqlSession;

public class ProductService {
    private ProductMapper productMapper;

    public void insertAdultGoods(TicketDTO ticketDTO) {
        SqlSession sqlSession = getProductSqlSession();

        productMapper = sqlSession.getMapper(ProductMapper.class);
        int result = productMapper.insertAdultGoods(ticketDTO);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

    }

    public void insertSeniorGoods(TicketDTO ticketDTO) {
        SqlSession sqlSession = getProductSqlSession();

        productMapper = sqlSession.getMapper(ProductMapper.class);
        int result = productMapper.insertSeniorGoods(ticketDTO);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

    }

    public void insertTeenagerGoods(TicketDTO ticketDTO) {
        SqlSession sqlSession = getProductSqlSession();

        productMapper = sqlSession.getMapper(ProductMapper.class);
        int result = productMapper.insertTeenagerGoods(ticketDTO);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

    }

    public void insertChildrenGoods(TicketDTO ticketDTO) {
        SqlSession sqlSession = getProductSqlSession();

        productMapper = sqlSession.getMapper(ProductMapper.class);
        int result = productMapper.insertChildrenGoods(ticketDTO);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

    }
}
