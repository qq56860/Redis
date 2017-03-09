package config;

import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import redis.clients.jedis.HostAndPort;



public class RedisConfig {
	private ResourceBundle resourceBundle;
	
	/*
     * 当前模式
     */
    private String model = null;
    
    /*
     * 同步条数
     */
    private Integer synchronizedCount = 0;
    
    /*
     * 同步开关
     */
    private Boolean synchronizedSwitches = false;
    
    /*
    池配置,用Integer因为如果出现异常可以捕获空指针,如果用基本数据类型虽然性能更好,但这个类只在加载时构建一次。
     */
    private Integer maxTotal = null;
    private Integer maxIdle = null;
    private Integer maxWaitMillis = null;
    private Boolean testOnBorrow = null;
    private Boolean testOnReturn = null;

    /*
    单实例配置
     */
    private String Host = null;
    private Integer Port  = null;
    private Integer TimeOut = null;
    private String Password = null;

    /*
    集群配置
     */
    private Set<HostAndPort> set = new HashSet<HostAndPort>();
    private Integer connectionTimeout = null;
    private Integer soTimeout = null;
    private Integer maxAttempts = null;
    private String clusterPassword = null;
    
    public RedisConfig(){
    	if(resourceBundle == null){
    		resourceBundle = ResourceBundle.getBundle("system");
    		if (resourceBundle != null){
                if(!StringUtil.isEmpty(resourceBundle.getString("redis.model"))) {
                    if (!StringUtil.isEmpty(resourceBundle.getString("redis.pool.maxTotle"))) {
                        this.maxTotal = Integer.parseInt(resourceBundle.getString("redis.pool.maxTotle"));
                    }
                    if (!StringUtil.isEmpty(resourceBundle.getString("redis.pool.maxIdle"))) {
                        this.maxIdle = Integer.parseInt(resourceBundle.getString("redis.pool.maxIdle"));
                    }
                    if (!StringUtil.isEmpty(resourceBundle.getString("redis.pool.maxWaitMillis"))) {
                        this.maxWaitMillis = Integer.parseInt(resourceBundle.getString("redis.pool.maxWaitMillis"));
                    }
                    if (!StringUtil.isEmpty(resourceBundle.getString("redis.pool.testOnBorrow"))) {
                        this.testOnBorrow = Boolean.valueOf(resourceBundle.getString("redis.pool.testOnBorrow"));
                    }
                    if (!StringUtil.isEmpty(resourceBundle.getString("redis.pool.testOnReturn"))) {
                        this.testOnReturn = Boolean.valueOf(resourceBundle.getString("redis.pool.testOnReturn"));
                    }
                    if (!StringUtil.isEmpty(resourceBundle.getString("redis.synchronizedCount"))) {
                        this.synchronizedCount = Integer.parseInt(resourceBundle.getString("redis.synchronizedCount"));
                    }
                    if (!StringUtil.isEmpty(resourceBundle.getString("redis.synchronizedSwitches"))) {
                        this.synchronizedSwitches = Boolean.valueOf(resourceBundle.getString("redis.synchronizedSwitches"));
                    }
                    this.model = resourceBundle.getString("redis.model");
                    if("single".equals(model)) {
                        //单实例redis配置项
                        if (!StringUtil.isEmpty(resourceBundle.getString("redis.Host"))) {
                            this.Host = resourceBundle.getString("redis.Host");
                        }
                        if (!StringUtil.isEmpty(resourceBundle.getString("redis.Port"))) {
                            this.Port = Integer.parseInt(resourceBundle.getString("redis.Port"));
                        }
                        if (!StringUtil.isEmpty(resourceBundle.getString("redis.TimeOut"))) {
                            this.TimeOut = Integer.parseInt(resourceBundle.getString("redis.TimeOut"));
                        }
                        if (!StringUtil.isEmpty(resourceBundle.getString("redis.Password"))) {
                            this.Password = resourceBundle.getString("redis.Password");
                        }
                        
                    }else{
                        
                        throw new RuntimeException("unknow model of redis");
                    }
                }
    		}
    		
    		
    		
    	}
    	
    	
    	
    	
    }
    public Integer getMaxTotal() {
        return maxTotal;
    }

    public Integer getMaxIdle() {
        return maxIdle;
    }

    public Integer getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public Boolean getTestOnBorrow() {
        return testOnBorrow;
    }

    public Boolean getTestOnReturn() {
        return testOnReturn;
    }

    public String getHost() {
        return Host;
    }

    public Integer getPort() {
        return Port;
    }

    public Integer getTimeOut() {
        return TimeOut;
    }

    public String getPassword() {
        return Password;
    }

    public Set<HostAndPort> getSet() {
        return set;
    }

    public Integer getConnectionTimeout() {
        return connectionTimeout;
    }

    public Integer getSoTimeout() {
        return soTimeout;
    }

    public Integer getMaxAttempts() {
        return maxAttempts;
    }

    public String getClusterPassword() {
        return clusterPassword;
    }

	public Integer getSynchronizedCount() {
		return synchronizedCount;
	}

	public void setSynchronizedCount(Integer synchronizedCount) {
		this.synchronizedCount = synchronizedCount;
	}


	public Boolean getSynchronizedSwitches() {
		return synchronizedSwitches;
	}


	public void setSynchronizedSwitches(Boolean synchronizedSwitches) {
		this.synchronizedSwitches = synchronizedSwitches;
	}
    
    
}
