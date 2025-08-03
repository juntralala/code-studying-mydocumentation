package com.juntralala.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Slf4j
public class Connection implements InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        // disini, melakukan koneksi kedatabase misalnya
        log.info("Koneksi siap untuk digunakan.");
    }

    @Override
    public void destroy() throws Exception {
        // dan disininya, menutup koneksi ke database
        log.info("Koneksi telah ditutup.");
    }
}
