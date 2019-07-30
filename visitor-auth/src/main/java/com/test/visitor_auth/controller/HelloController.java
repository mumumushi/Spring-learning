package com.test.visitor_auth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/admin/hello")
    @PreAuthorize("hasAnyRole('admin', 'dba')")
    public String admin() {
        return "hello admin!";
    }
    @GetMapping("/db/hello")
    @PreAuthorize("hasRole('dba')")
    public String dba() {
        return "hello dba!";
    }
    @GetMapping("/user/hello")
    @PreAuthorize("hasAnyRole('user', 'admin')")
    public String user() {
        return "hello user!";
    }
    @GetMapping("/hello")
    public String hello() {
        return "helllllllo!";
    }
    
}
