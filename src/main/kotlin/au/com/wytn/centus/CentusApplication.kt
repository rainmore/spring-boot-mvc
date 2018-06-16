package au.com.wytn.centus

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@EnableAutoConfiguration
@ComponentScan(value = arrayOf("au.com.wytn.centus"))
@SpringBootApplication
class CentusApplication


fun main(args: Array<String>) {
    runApplication<CentusApplication>(*args)
}
