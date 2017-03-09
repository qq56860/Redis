package Test;

import redis.clients.jedis.Jedis;
import redis.dao.impl.RedisDateSourceImpl;

public class Test1 {
	
	private static RedisDateSourceImpl redisDateSource = new RedisDateSourceImpl();
	
	public static void main(String[] args) {
		Jedis jedis = null;
		
		try {
			jedis = redisDateSource.getRedisClientForSingleServer();
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jedis.set("NO1", "1");
//		jedis.set("NO1", "2");
//		jedis.set("NO2", "3");
//		jedis.set("NO2", "3");
//		
		System.out.println(jedis.get("NO1"));
//		System.out.println(jedis.get("NO2"));
		
	}
}
