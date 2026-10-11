package com.ryan.micro.demo.config;

import org.springframework.aot.hint.ExecutableMode;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;

@Configuration(proxyBeanMethods = false)
@ImportRuntimeHints(HibernateNativeConfiguration.HibernateRuntimeHintsRegistrar.class)
public class HibernateNativeConfiguration {

    static class HibernateRuntimeHintsRegistrar implements RuntimeHintsRegistrar {

        @Override
        public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
            System.out.println(">>>> hints = " + hints);
            hints.reflection().registerType(
                    org.hibernate.bytecode.internal.bytebuddy.BytecodeProviderImpl.class,
                    builder -> builder.withConstructor(java.util.Collections.emptyList(), ExecutableMode.INVOKE)
            );
        }
    }
}
