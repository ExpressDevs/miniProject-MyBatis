package com.ohgiraffers.mapper;

import com.ohgiraffers.model.DTO.TicketDTO;

public interface OrderMapper {
    int insertOrder(TicketDTO ticketDTO);
}