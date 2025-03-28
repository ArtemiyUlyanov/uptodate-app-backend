package me.artemiyulyanov.uptodate.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.artemiyulyanov.uptodate.mail.MailConfirmationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
//    @Autowired
//    private ObjectMapper objectMapper;

    @Bean
    public RedisTemplate<String, MailConfirmationMessage> mailConfirmationCodeRedisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, MailConfirmationMessage> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }

    @Bean
    public RedisTemplate<String, Object> defaultRedisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }
}