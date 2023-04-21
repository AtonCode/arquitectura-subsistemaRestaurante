package org.eclipse.jakarta.hello.domain.pattterns.integration.serviceLocator;

public class ServiceLocator {
    //Singleton pattern
    //Service locator pattern

    private static ServiceLocator instance;

    private ServiceLocator() {
    }

    public static ServiceLocator getInstance() {
        if (instance == null) {
            instance = new ServiceLocator();
        }
        return instance;
    }

}
