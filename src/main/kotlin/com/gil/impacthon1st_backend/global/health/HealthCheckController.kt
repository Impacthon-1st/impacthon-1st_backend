package com.gil.impacthon1st_backend.global.health

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/health")
@RestController
class HealthCheckController {

    @GetMapping
    fun healthCheck() = "OK"
}