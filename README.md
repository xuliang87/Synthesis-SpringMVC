### 预值机管理后台及接口系统
-  **应用部署注意事项**
   * **数据库连接**
      + 数据库连接已经切换到Tomcat JNDI,撇弃**jdbc.properties**文件  
      + JNDI 配置请查看 **spring-context.xml**文件  
```
<!-- 配置dataSource数据源c3p0 -->  
<bean id="dataSource" class="org.springframework.jndi.JndiObjectFactoryBean">  
    <!-- 启动环境为webSphere下 -->  
	<property name="jndiName">  
		<value>java:comp/env/jdbc/khyzjDB</value>  
	</property>  
</bean>  
```

  * **配置SVC接口，配置信息如下：**
      + **remote.properties**配置远程连接信息
```
#Created by JInto - www.guh-software.de  
#Fri May 15 15:49:06 CST 2015  
host.ip = 10.14.64.36  
host.port = 80  
host.webContext = TravelSkySvc  
```

      + **spring-context.xml**加载**remote.properties**配置信息  
```
<!-- 配置SVC接口 -->   
<bean id="propertyConfigurer"   class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">    
	<property name="locations">   
		 <list>   
		     <value>classpath:remote.properties</value>   
		 </list>   
    </property>   
</bean>   
```

- **dubbo接口**
```java
package com.kmair.dubbo.precheckin;

import java.io.IOException;

/**
 * Created by michael edison on 2016/9/20.
 */
public interface ICheckinService {

    public String detrTicket(String certificateNumber, String certificateType, String name);
    public String doSYPR(String flightDate, String flightNo, String dptAptCode, String arvAptCode, String etCode);
    public String querySeatChart(String flightDate, String flightNo, String fromCity, String toCity, String tourClass);
    public String doPsrCheckin(String name, String type, String idCard, String mobile, String flightNo,
                               String flightDate, String flightTime, String fromCity, String toCity, String tourClass, String seatNo,
                               String etCode, String boardingGateNumber, String tourIndex,
                               String boardingType, String barcodeType);
    public String doDelPsr(String name, String type, String idCard, String mobile, String flightNo, String flightDate,
                           String flightTime, String fromCity, String toCity, String tourClass, String seatNo, String etCode,
                           String boardingGateNumber, String tourIndex);
    public String getBarCodeEbp(String boardStream) throws IOException;
    public String getPdf417Ebp(String boardStream);
    public String rePrint(String passengerEnName, String mobile, String airlineCode,
                          String tourClass, String flightDate, String flightNumber, String fromCity, String toCity,
                          String reissue, String etCode, String tourIndex, String boardingType, String barcodeType);
    public String queryFlightBoardInAirport(String flightDate, String flightNo, String fromCity);

}
```
