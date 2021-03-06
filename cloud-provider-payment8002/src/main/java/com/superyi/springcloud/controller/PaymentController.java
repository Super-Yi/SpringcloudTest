package com.superyi.springcloud.controller;

import com.superyi.springcloud.model.entity.CommonResult;
import com.superyi.springcloud.model.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.superyi.springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * @author Super-Yi
 * @date 2021/4/4
 **/
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/add")
    public CommonResult addPayment(@RequestBody Payment payment) {
        int result = paymentService.addPayment(payment);
        log.info("**********插入结果"+result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,serverPort+"+serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("**********插入结果"+payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功,serverPort+"+serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录，查询ID："+id, null);
        }
    }
}
