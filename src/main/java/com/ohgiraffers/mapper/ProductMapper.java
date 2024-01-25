package com.ohgiraffers.mapper;

import com.ohgiraffers.model.DTO.TicketDTO;

public interface ProductMapper {

    int insertAdultGoods(TicketDTO ticketDTO);
    int insertSeniorGoods(TicketDTO ticketDTO);
    int insertTeenagerGoods(TicketDTO ticketDTO);
    int insertChildrenGoods(TicketDTO ticketDTO);


}
