package stg.transferws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


import stg.transferws.feign.UserAttijariFeign;


@EnableFeignClients @SpringBootApplication(scanBasePackages = {"stg.transferws"})
public class TransferwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransferwsApplication.class, args);
	}
    @Autowired
    private UserAttijariFeign attijariFeign;
}
