package oiasso.system.listadocoches.api;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import oiasso.system.listadocoches.api.variables.VariablesEntornoListadoCochesAPI;

@Configuration
@DependsOn(value = "variablesEntornoListadoCochesAPI")
public class DataSourceConfig {

	private static final Logger LOG = LoggerFactory.getLogger(DataSourceConfig.class);
	
	@Bean
	public DataSource dataSource(VariablesEntornoListadoCochesAPI variablesEntornoListadoCochesAPI) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		LOG.info("DB_URL: {}", variablesEntornoListadoCochesAPI.getUrl());
		dataSource.setUrl(variablesEntornoListadoCochesAPI.getUrl());
		dataSource.setSchema(variablesEntornoListadoCochesAPI.getSchema());
		dataSource.setUsername(variablesEntornoListadoCochesAPI.getUsername());
		dataSource.setPassword(variablesEntornoListadoCochesAPI.getPassword());		
		return dataSource;
	}

}
