package com.gil.impacthon1st_backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@ConfigurationPropertiesScan
@SpringBootApplication
class Impacthon1stBackendApplication

fun main(args: Array<String>) {
    runApplication<Impacthon1stBackendApplication>(*args)
}
