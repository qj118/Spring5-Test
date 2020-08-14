package org.demon.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@ComponentScan(basePackages = {"org.demon.spring5.annotation"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopConfig {
}
