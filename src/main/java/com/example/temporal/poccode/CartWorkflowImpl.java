package com.example.temporal.poccode;


import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;

public class CartWorkflowImpl implements CartWorkflow {

    ActivityOptions options =
            ActivityOptions.newBuilder()
                    .setTaskQueue("CART_TASK_QUEUE")
                    .setStartToCloseTimeout(Duration.ofSeconds(10))
                    .setRetryOptions(
                            RetryOptions.newBuilder()
                                    .setMaximumAttempts(3)   // 🔁 retry 3 times
                                    .build()
                    )
                    .build();

    private final CartActivity activity =
            Workflow.newActivityStub(CartActivity.class, options);

    private void beforeActivities(Cart cart) {
        System.out.println("🔧 Before hook executed");
        cart.put("validated", true);
    }

    @Override
    public void processCart(String orderId) {

        Cart cart = new Cart(orderId);

        beforeActivities(cart);

        cart = activity.addToCart(cart);  // step 1
        cart = activity.checkout(cart);   // step 2
        cart = activity.billingPrint(cart);  // step 3

        Workflow.getLogger(this.getClass())
                .info("🎉 Final Cart State: " + cart);
    }



}