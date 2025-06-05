package com.trung_kieen.finance.core.security.https;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * HTTPRedirectRequest
 * Redirect all HTTP request to HTTPS with a self sign in TLS certificate
 * Https keep user and client comunicate data encrypted instead of raw
 * text
 */

/**
 * HTTPResolverRequest
 */
@Configuration
public class HttpRedirectRequest {
  @Value("${server.port}")
  private String  securePort;

  @Bean
  public ServletWebServerFactory servletContainer() {

    var tomcat = new TomcatServletWebServerFactory() {

      @Override
      protected void postProcessContext(Context context) {

        var securityConstraint = new SecurityConstraint();
        securityConstraint.setUserConstraint("CONFIDENTIAL");

        var collection = new SecurityCollection();
        collection.addPattern("/*");
        securityConstraint.addCollection(collection);
        context.addConstraint(securityConstraint);
      }
    };

    tomcat.addAdditionalTomcatConnectors(redirectConnector());
    return tomcat;
  }

  private Connector redirectConnector() {

    var connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
    connector.setScheme("http");
    connector.setPort(8080);
    connector.setSecure(false);
    connector.setRedirectPort(Integer.parseInt(securePort));

    return connector;
  }

}
