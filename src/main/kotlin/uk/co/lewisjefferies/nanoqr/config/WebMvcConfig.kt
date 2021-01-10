package uk.co.lewisjefferies.nanoqr.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.BufferedImageHttpMessageConverter
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.awt.image.BufferedImage

@Configuration
@EnableWebMvc
class WebMvcConfig: WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
                .allowedMethods("POST", "OPTIONS")
    }

    override fun extendMessageConverters(converters: MutableList<HttpMessageConverter<*>>) {
        converters.add(BufferedImageHttpMessageConverter())
        super.extendMessageConverters(converters)
    }
}