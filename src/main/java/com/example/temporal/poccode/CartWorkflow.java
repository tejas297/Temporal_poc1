package com.example.temporal.poccode;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface CartWorkflow {
    @WorkflowMethod
    void processCart(String orderId);
}