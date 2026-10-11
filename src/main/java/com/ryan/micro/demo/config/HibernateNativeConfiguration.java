package com.ryan.micro.demo.config;

import org.hibernate.bytecode.internal.none.BytecodeProviderImpl;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;

import java.util.stream.Stream;
@Configuration(proxyBeanMethods = false)
@ImportRuntimeHints(HibernateNativeConfiguration.HibernateRuntimeHintsRegistrar.class)
public class HibernateNativeConfiguration {

    static class HibernateRuntimeHintsRegistrar implements RuntimeHintsRegistrar {

        @Override
        public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
            Stream.of(BytecodeProviderImpl.class)
                    .forEach(x -> hints.reflection().registerType(x, MemberCategory.values()));
            hints.proxies().registerJdkProxy(HibernateProxy.class);
        }
    }
}
