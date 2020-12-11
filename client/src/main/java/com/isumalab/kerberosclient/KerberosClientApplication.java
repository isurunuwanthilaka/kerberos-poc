package com.isumalab.kerberosclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Paths;

@SpringBootApplication
public class KerberosClientApplication {

    static {
        System.setProperty("java.security.krb5.conf",
                Paths.get("\\workdir\\krb5.conf").normalize().toAbsolutePath().toString());
        System.setProperty("sun.security.krb5.debug", "true");
        // disable usage of local kerberos ticket cache
        System.setProperty("http.use.global.creds", "false");
    }

    public static void main(String[] args) {
        SpringApplication.run(KerberosClientApplication.class, args);
    }
}
