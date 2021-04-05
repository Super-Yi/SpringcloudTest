package com.superyi.springcloud.model.dao;

import com.superyi.springcloud.model.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Super-Yi
 * @date 2021/4/4
 **/
@Mapper
public interface PaymentDao {
    int addPayment(Payment payment);

    Payment getPaymentById(Long id);
}
