package oiasso.system.listadocoches.api;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * Para utilizar Swager con Spring Data Rest es necesario importar la clase SpringDataRestConfiguration
 */

@Configuration
@EnableSwagger2WebMvc
@Import({ SpringDataRestConfiguration.class, BeanValidatorPluginsConfiguration.class })
public class SwaggerConfiguration {

	@Autowired
	private BuildProperties buildProperties;
	
	/************************
	 ******** Beans ********* 
	 ************************/
	
	@Bean
	public Docket usersApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(usersApiInfo())
				.select()
				.paths(userPaths())
				.apis(RequestHandlerSelectors.any())
				.build();
	}

	/************************
	 *** Metodos privados *** 
	 ************************/

	private ApiInfo usersApiInfo() {
		return new ApiInfoBuilder()
				.title(buildProperties.getArtifact())
				.version(buildProperties.getVersion())
				.license("Oiasso Systems License")
				.build();
	}

	/** Especificar las URLs para documentar */
	private Predicate<String> userPaths() {
		return regex("/api.*");
	}

}
