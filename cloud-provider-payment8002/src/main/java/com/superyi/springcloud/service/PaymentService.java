package com.superyi.springcloud.service;

import com.superyi.springcloud.model.entity.Payment;

/**
 * @author Super-Yi
 * @date 2021/4/4
 **/
public interface PaymentService {
    int addPayment(Payment payment);

    Payment getPaymentById(Long id);

}
