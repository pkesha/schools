package com.ga.contentbackend.security;

import com.ga.contentbackend.model.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

public class CustomSecurityContextFactory
        implements WithSecurityContextFactory<WithCustomUser> {

    @Override
    public SecurityContext createSecurityContext(
            WithCustomUser withCustomUser) {
        SecurityContext context =
                SecurityContextHolder.createEmptyContext();

        User user = new User(1L,withCustomUser.username(),"123456");


        MyUserDetails myUserDetails = new MyUserDetails(user);

        var a = new UsernamePasswordAuthenticationToken(
                myUserDetails, null, null);

        context.setAuthentication(a);

        return context;
    }
}
