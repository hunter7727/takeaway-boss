package com.pmdiss.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceProperties {

    private String url; //数据库连接url

    private String username; //数据库用户名

    private String password; //数据库密码

    private String driverClassName; //驱动名称

    private int initialSize; //连接池初始连接个数

    private int maxActive; //连接池最大连接个数

    private int minIdle; //连接池最小连接个数

    private long maxWait;//获取连接最大等待时间

    private String validationQuery; //用来检测连接是否有效的sql

    private boolean testOnBorrow; //申请连接时执行validationQuery检测连接是否有效

    private boolean testWhileIdle; //如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效

    private long timeBetweenEvictionRunsMillis; //testWhileIdle的判断依据，详细看testWhileIdle属性的说明

    private String filters;//属性类型是字符串，通过别名的方式配置扩展插件，常用的插件有：监控统计用的filter:stat、日志用的filter:log4j、防御sql注入的filter:wall

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public int getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public long getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(long maxWait) {
        this.maxWait = maxWait;
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public boolean isTestWhileIdle() {
        return testWhileIdle;
    }

    public void setTestWhileIdle(boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    public long getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }

    public void setTimeBetweenEvictionRunsMillis(long timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }
}
