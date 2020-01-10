package com.web.application.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConf {

	@Bean(name="primaryDataSource")
	@ConfigurationProperties(prefix="app.datasource.primary")
	@Primary
	public DataSource primaryDataSource() {
		return new HikariDataSource();
	}
	@Bean(name="secondaryDataSource") //数据源2
	@ConfigurationProperties(prefix="app.datasource.secondary")
	public DataSource secondaryDataSource() {
		return new HikariDataSource();
	}
	
	
	// 配置CURD Temp-----------------
		@Bean(name="jdbcTempPrimary")//Temp 数据源一
		public NamedParameterJdbcTemplate jdbcTemplate(@Qualifier("primaryDataSource") DataSource dataSource) {
			return new NamedParameterJdbcTemplate(dataSource);
		}
		@Bean(name="jdbcTempSencondary")//Temp 数据源二
		public NamedParameterJdbcTemplate jdbcTemplateSonf(@Qualifier("secondaryDataSource") DataSource dataSource) {
			return new NamedParameterJdbcTemplate(dataSource);
		}
	
}
