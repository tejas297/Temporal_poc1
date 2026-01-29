package com.example.temporal.poccode;

import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface CartActivity {

    Cart addToCart(Cart cart);

    Cart checkout(Cart cart);

    Cart billingPrint(Cart cart);
}