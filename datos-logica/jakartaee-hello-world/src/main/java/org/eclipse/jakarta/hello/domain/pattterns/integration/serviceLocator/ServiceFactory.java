package org.eclipse.jakarta.hello.domain.pattterns.integration.serviceLocator;

import jakarta.mail.Service;
import jakarta.persistence.Cache;

public class ServiceFactory {
    /*
    private static Cache cache;

    static {
        cache = new Cache() {
            @Override
            public boolean contains(Class cls, Object primaryKey) {
                return false;
            }

            @Override
            public void evict(Class cls, Object primaryKey) {

            }

            @Override
            public void evict(Class cls) {

            }

            @Override
            public void evictAll() {

            }

            @Override
            public <T> T unwrap(Class<T> cls) {
                return null;
            }
        };
    }

    public static Service getService(String jndiName) {

        Service service = cache.getService(jndiName);

        if (service != null) {
            return service;
        }

        InitialContext context = new InitialContext();
        Service service1 = (Service) context.lookup(jndiName);
        cache.addService(service1);
        return service1;
    }
    */
}
