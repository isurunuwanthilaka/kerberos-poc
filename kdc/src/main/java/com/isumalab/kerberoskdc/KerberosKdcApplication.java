package com.isumalab.kerberoskdc;

import org.apache.commons.io.FileUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.kerberos.test.MiniKdc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class KerberosKdcApplication {

    private static final String KRB_WORK_DIR = "/workdir";

    public static void main(String[] args) throws Exception {

        String[] config = MiniKdcConfigBuilder.builder()
                .workDir(prepareWorkDir())
                .confDir("minikdc-krb5.conf")
                .keytabName("kdc.keytab")
                .principals("client/localhost", "HTTP/localhost")
                .build();

        MiniKdc.main(config);
    }

    private static String prepareWorkDir() throws IOException {
        Path dir = Paths.get(KRB_WORK_DIR);
        File directory = dir.normalize().toFile();

        FileUtils.deleteQuietly(directory);
        FileUtils.forceMkdir(directory);
        return dir.toString();
    }
}
