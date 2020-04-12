package co.edu.udea.produccionesacademicas.api.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //La configuración de Swagger se centra en un bean Docket
    public Docket api(){
        // Se establece el tipo de documentación
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //Se seleciona como disponible toda la API para la documentación
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                //Se construye
                .build();
    }
}
