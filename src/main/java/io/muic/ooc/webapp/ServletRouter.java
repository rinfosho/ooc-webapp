/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.muic.ooc.webapp;

import io.muic.ooc.webapp.service.SecurityService;
import io.muic.ooc.webapp.servlet.DeleteServlet;
import io.muic.ooc.webapp.servlet.HomeServlet;
import io.muic.ooc.webapp.servlet.LoginServlet;
import io.muic.ooc.webapp.servlet.RegisterServlet;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

/**
 *
 * @author gigadot
 */
public class ServletRouter {
    
    private SecurityService securityService;

    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }

    public void init(Context ctx) {
        initHome(ctx);
        initLogin(ctx);
        initRegister(ctx);
        initDelete(ctx);
    }

    private void initHome(Context ctx) {
        HomeServlet homeServlet = new HomeServlet();
        homeServlet.setSecurityManager(securityService);
        Tomcat.addServlet(ctx, "HomeServlet", homeServlet);
        ctx.addServletMapping("/index.jsp", "HomeServlet");
    }

    private void initLogin(Context ctx) {
        LoginServlet loginServlet = new LoginServlet();
        loginServlet.setSecurityService(securityService);
        Tomcat.addServlet(ctx, "LoginServlet", loginServlet);
        ctx.addServletMapping("/login", "LoginServlet");
    }
    private void initRegister(Context ctx){
        RegisterServlet registerServlet = new RegisterServlet();
        registerServlet.setSecurityService(securityService);
        Tomcat.addServlet(ctx, "RegisterServlet", registerServlet);
        ctx.addServletMapping("/signup", "RegisterServlet");
    }
    private void initDelete(Context ctx){
        DeleteServlet deleteServlet = new DeleteServlet();
        deleteServlet.setSecurityService(securityService);
        Tomcat.addServlet(ctx, "DeleteServlet", deleteServlet);
        ctx.addServletMapping("/delete", "DeleteServlet");
    }
}
