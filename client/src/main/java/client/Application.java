package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@Controller
public class Application {

	@Autowired
	SampleClient client;

	@FeignClient(name = "SAMPLESERVICE")
	interface SampleClient {
		@RequestMapping(value = "/test", method = RequestMethod.GET)
		String test();
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
	public String test() {
		return client.test();
	}

}
