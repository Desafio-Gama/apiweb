package br.com.chocode.apiWeb.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.params.SetParams;

@Service
public class RedisServiceImp {
    private Jedis jedis;

    @Autowired
    public RedisServiceImp() {
        this.jedis = new Jedis("http://localhost:6379");
    }

    public void write(String key, String value, long expireInSecconds) {
        SetParams params = new SetParams();
        params.ex(expireInSecconds);
        jedis.set(key, value, params);
    }

    public String read(String key) {
        return jedis.get(key);
    }

    public void publish(String channel, String message) {
        jedis.publish(channel, message);
    }

    public void subscribe(String key) {
        jedis.subscribe(new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                System.out.println("Canal: " + channel);
                System.out.println("Mensagem: " + message);
            }
        }, key);
    }

    public void close() {
        jedis.close();
    }
}
