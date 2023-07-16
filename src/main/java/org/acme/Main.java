//package org.acme;
//
//import io.quarkus.runtime.QuarkusApplication;
//import io.quarkus.runtime.annotations.QuarkusMain;
//import jakarta.inject.Inject;
//import org.acme.client.TodoClient;
//import org.acme.client.TodoDynamicClient;
//
//import java.util.UUID;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//@QuarkusMain
//public class Main implements QuarkusApplication {
//
//    @Inject
//    TodoClient clientApi;
//
//    @Inject
//    JvmClient jvmClient;
//
//    @Inject
//    TodoDynamicClient dynamicClient;
//
//
//    @Inject
//    JaxrsClient jaxrsClient;
//    public static final Logger LOGGER = Logger.getLogger(Main.class.getName());
//
//    @Override
//    public int run(String... args) throws Exception {
//
//        String id = UUID.randomUUID().toString();
//        var todo = this.clientApi.getTodoById(id);
//        if (todo.isPresent()) {
//            LOGGER.log(Level.INFO, "found: {0}", todo.get());
//        }
//        if (todo.hasErrors()) {
//            todo.getErrors().forEach(
//                    error -> LOGGER.log(Level.INFO, "error: path={0}, message={1}", new Object[]{error.getPath(), error.getMessage()})
//            );
//        }
//
//
//        this.clientApi.getAllTodos().forEach(
//                p -> LOGGER.log(Level.INFO, "todos: {0}", p)
//        );
//
//        this.jvmClient.getAllTodos()
//                .thenAccept(
//                        p -> LOGGER.log(Level.INFO, "todos from jvm client: {0}", p)
//                )
//                .whenComplete((d, e) -> LOGGER.info("The request is done in the jvm client."))
//                .toCompletableFuture()
//                .join();
//
//        this.jaxrsClient.getAllTodos()
//                .thenAccept(
//                        p -> LOGGER.log(Level.INFO, "todos from Jaxrs client: {0}", p)
//                )
//                .whenComplete((d, e) -> LOGGER.info("The request is done in the Jaxrs client."))
//                .toCompletableFuture()
//                .join();
//
//
//        this.dynamicClient.getAllTodos().forEach(
//                p -> LOGGER.log(Level.INFO, "todos from dynamic client: {0}", p)
//        );
//
//        return 0;
//    }
//}
