package com.isumalab.kerberosclient.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(KerberosConfig.class)
class AppConfig {

}
