package com.example.temporal.poccode;


import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.serviceclient.WorkflowServiceStubsOptions;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;

public class CartWorker {



    public static void main(String[] args) {

        WorkflowServiceStubs service =
                WorkflowServiceStubs.newServiceStubs(  WorkflowServiceStubsOptions.newBuilder()
                        .setTarget("localhost:7233")
                        .build());

        WorkflowClient client =
                WorkflowClient.newInstance(service);

        WorkerFactory factory =
                WorkerFactory.newInstance(client);

        Worker worker =
                factory.newWorker("CART_TASK_QUEUE");

        worker.registerWorkflowImplementationTypes(CartWorkflowImpl.class);
        worker.registerActivitiesImplementations(new CartActivityImpl());

        factory.start();
    }
}