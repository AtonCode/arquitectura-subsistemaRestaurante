package org.eclipse.jakarta.hello.domain.core;

public interface IUser {

     long getId();
     void setId(long id);

     String getName();
     void setName(String name);

     String getEmail();
     void setEmail(String email);

     String getPassword();
     void setPassword(String password);
}
