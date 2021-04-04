package com.superyi.springcloud.service.impl;

import com.superyi.springcloud.model.dao.PaymentDao;
import com.superyi.springcloud.model.entity.Payment;
import com.superyi.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Super-Yi
 * @date 2021/4/4
 **/
@Service
public class PaymentServiceIml implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int addPayment(Payment payment) {
        return paymentDao.addPayment(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
