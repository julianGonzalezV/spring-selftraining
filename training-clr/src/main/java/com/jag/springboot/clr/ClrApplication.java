package com.jag.springboot.clr;

import com.jag.springboot.entity.DemoEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * https://howtodoinjava.com/spring-boot/command-line-runner-interface-example/
 */
@SpringBootApplication
public class ClrApplication{
	private static final Logger LOG = LoggerFactory.getLogger(ClrApplication.class);

	/**
	 *  for methods  restTemplate and x are here in the entry point just for testing purposes but actually it fits better
	 *  being part of a separate class
	 */


	/**
	 *
	 * @param builder: RestTemplateBuilder for getting an autoconfigured RestTemplate
	 * @return
	 */
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}

	//@Bean
	public CommandLineRunner runner1(RestTemplate restTemplate) throws Exception{
		return args -> {
			LOG.info("Starting CLR-1");
			// Most important part
			ResponseEntity<List<DemoEntity>> entities = restTemplate.exchange("http://localhost:8000/api/demo",
					HttpMethod.GET, null, new ParameterizedTypeReference<List<DemoEntity>>() {
					});
			entities.getBody().forEach(demoEntity -> LOG.info(demoEntity.toString()));
			LOG.info("Finishing CLR-1");
		};
	}

	@Bean
	public CommandLineRunner runner2() throws Exception{
		return args -> {
			LOG.info("Starting CLR-2 ");
			IntStream.range(1,8).forEach(System.out::println);
			LOG.info("Finishing CLR-2");
		};
	}

	@Bean
	public CommandLineRunner fizzBuzzRunner() throws Exception{
		return args -> {
			LOG.info("Starting fizzBuzzRunner ");
			IntStream.range(1,101).forEach(
					number-> {
						String result = "";
						if(number%3 == 0) result += result.concat("Fizz");
						if(number%5 == 0)  result +=  result.concat("Buzz");
						LOG.info(result.isEmpty()? Integer.toString(number):result);
					});
			LOG.info("Finishing fizzBuzzRunner");
		};
	}


	public static void main(String[] args) {
		SpringApplication.run(ClrApplication.class, args);
	}

}
