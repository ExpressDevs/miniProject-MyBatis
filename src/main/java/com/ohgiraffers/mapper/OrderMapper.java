package com.ohgiraffers.mapper;

public interface OrderMapper {
    int insertOrder(String ticketNum, String id, String startStation, String endStation, String departureTime, int billingAmount, String paymentMethod, int totalAmount);
}