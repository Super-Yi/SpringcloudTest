package com.superyi.springcloud.controller;

import com.superyi.springcloud.model.entity.CommonResult;
import com.superyi.springcloud.model.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Super-Yi
 * @date 2021/4/4
 **/
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    //public static final String Payment_url = "http://localhost:8001/payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/add")
    public CommonResult<Integer> addPayment(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/add", payment, CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/"+id, CommonResult.class);
    }
}
