package com.example.temporal.poccode;


public class CartActivityImpl implements CartActivity {

    @Override
    public Cart addToCart(Cart cart) {
        try {
            // ⏳ Simulate slow checkout (6 seconds)
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Checkout interrupted", e);
        }
        cart.put("items", "Laptop, Mouse");
        cart.put("status", "ITEMS_ADDED");
        System.out.println("🛒 addToCart: " + cart);

        return cart;
    }

    @Override
    public Cart checkout(Cart cart) {

        cart.put("status", "CHECKED_OUT");
        System.out.println("✅ checkout: " + cart);
        return cart;
    }

    @Override
    public Cart billingPrint(Cart cart) {
        cart.put("billAmount", 75000);
        cart.put("status", "BILLED");
        System.out.println("🧾 billingPrint: " + cart);
        return cart;
    }
}
