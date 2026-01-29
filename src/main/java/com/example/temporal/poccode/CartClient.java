package com.example.temporal.poccode;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;

public class CartClient {

    public static void main(String[] args) {

        // 1️⃣ Connect to Temporal Server (local)
        WorkflowServiceStubs service =
                WorkflowServiceStubs.newLocalServiceStubs();

        WorkflowClient client =
                WorkflowClient.newInstance(service);

        // 2️⃣ Start multiple independent workflows
        for (int i = 5; i < 10; i++) {

            CartWorkflow workflow =
                    client.newWorkflowStub(
                            CartWorkflow.class,
                            WorkflowOptions.newBuilder()
                                    .setTaskQueue("CART_TASK_QUEUE")
                                    .setWorkflowId("CART-WORKFLOW-" + i)
                                    .build()
                    );

            // 3️⃣ Start workflow asynchronously (NON-blocking)
            WorkflowClient.start(
                    workflow::processCart,
                    "ORDER-" + i
            );
        }
    }
}
