package redis.dao.impl;



import config.RedisConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.dao.RedisDataSource;



public class RedisDateSourceImpl implements RedisDataSource {

	
    private RedisConfig redisConfig = new RedisConfig();

    private JedisPool jedisPool;

    public Jedis getRedisClientForSingleServer() throws Throwable{
    	//System.out.println("1");
    	if( jedisPool == null ){
    		//System.out.println("2");
    		jedisPool = new JedisPool();
    		JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(redisConfig.getMaxTotal());
            config.setMaxIdle(redisConfig.getMaxIdle());
            config.setMaxWaitMillis(redisConfig.getMaxWaitMillis());
            config.setTestOnBorrow(redisConfig.getTestOnBorrow());
            config.setTestOnReturn(redisConfig.getTestOnReturn());
            String Host = redisConfig.getHost();
            Integer Port = redisConfig.getPort() ;
            Integer TimeOut = redisConfig.getTimeOut();
            String Password = redisConfig.getPassword();
            //System.out.println(Password);
            jedisPool = new JedisPool(config , Host , Port , TimeOut , Password);
        }
        return jedisPool.getResource();
    }

    public void returnResource(Jedis jedis){
        try {
			if (jedis != null) {
			    jedis.close();
			}else{
			    throw new RuntimeException("ERROR : COULD NOT RELEASE RESOURCE TO THE POOL , BECAUSE THE JEDIS IS NULL !!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
