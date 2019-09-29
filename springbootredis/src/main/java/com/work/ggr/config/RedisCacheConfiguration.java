//package com.work.ggr.config;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.RedisPassword;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import org.springframework.util.ObjectUtils;
//
//import java.time.Duration;
//
///**
// * @author : gr
// * @date : 2019/9/29 9:47
// */
//@Configuration
//public class RedisCacheConfiguration {
////    @Value("${spring.redis.host}")
////    private String host;
////    @Value("${spring.redis.port}")
////    private String port;
////    @Value("${spring.redis.password}")
////    private String password;
////    @Value("${spring.redis.jedis.pool.max-active}")
////    private String max_active;
////    @Value("${spring.redis.jedis.pool.max-wait}")
////    private String max_wait;
////    @Value("${spring.redis.jedis.pool.max-idle}")
////    private String max_idle;
////    @Value("${spring.redis.jedis.pool.min-idle}")
////    private String min_idle;
//    /**
//     * 数据源1 默认配置(127.0.0.1) redis template
//     *
//     * @param redisConnectionFactory
//     * @return
//     */
//    @Bean
//    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        return createRedisTemplate(redisConnectionFactory);
//    }
//
//    /**
//     * 数据源2 redis template
//     */
//    @Bean
//    public RedisTemplate redisTemplate2(
//            @Value("${spring.redis.database}") int database,
//            @Value("${spring.redis.timeout}") long timeout,
//            @Value("${spring.redis.jedis.pool.max-active}") int maxActive,
//            @Value("${spring.redis.jedis.pool.max-wait}") int maxWait,
//            @Value("${spring.redis.jedis.pool.max-idle}") int maxIdle,
//            @Value("${spring.redis.jedis.pool.min-idle}") int minIdle,
//
//            @Value("${spring.redis2.host}") String hostName,
//            @Value("${spring.redis2.port}") int port,
//            @Value("${spring.redis2.password}") String password) {
//
//        /* ========= 基本配置 ========= */
//        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
//        configuration.setHostName(hostName);
//        configuration.setPort(port);
//        configuration.setDatabase(database);
//        if (!ObjectUtils.isEmpty(password)) {
//            RedisPassword redisPassword = RedisPassword.of(password);
//            configuration.setPassword(redisPassword);
//        }
//
//        /* ========= 连接池通用配置 ========= */
//        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
//        genericObjectPoolConfig.setMaxTotal(maxActive);
//        genericObjectPoolConfig.setMinIdle(minIdle);
//        genericObjectPoolConfig.setMaxIdle(maxIdle);
//        genericObjectPoolConfig.setMaxWaitMillis(maxWait);
//
//        /* ========= jedis pool ========= */
//        /*
//        JedisClientConfiguration.DefaultJedisClientConfigurationBuilder builder = (JedisClientConfiguration.DefaultJedisClientConfigurationBuilder) JedisClientConfiguration
//                .builder();
//        builder.connectTimeout(Duration.ofSeconds(timeout));
//        builder.usePooling();
//        builder.poolConfig(genericObjectPoolConfig);
//        JedisConnectionFactory connectionFactory = new JedisConnectionFactory(configuration, builder.build());
//        // 连接池初始化
//        connectionFactory.afterPropertiesSet();
//        */
//
//        /* ========= lettuce pool ========= */
//        LettucePoolingClientConfiguration.LettucePoolingClientConfigurationBuilder builder = LettucePoolingClientConfiguration.builder();
//        builder.poolConfig(genericObjectPoolConfig);
//        builder.commandTimeout(Duration.ofSeconds(timeout));
//        LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory(configuration, builder.build());
//        connectionFactory.afterPropertiesSet();
//
//        /* ========= 创建 template ========= */
//        return createRedisTemplate(connectionFactory);
//    }
//
//    /**
//     * json 实现 redisTemplate
//     * <p>
//     * 该方法不能加 @Bean 否则不管如何调用，connectionFactory都会是默认配置
//     *
//     * @param redisConnectionFactory
//     * @return
//     */
//    public RedisTemplate createRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//
//        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
//
//        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }
//}
