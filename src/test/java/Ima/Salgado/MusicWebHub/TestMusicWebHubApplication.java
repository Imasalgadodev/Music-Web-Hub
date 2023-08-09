package Ima.Salgado.MusicWebHub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestMusicWebHubApplication {

	public static void main(String[] args) {
		SpringApplication.from(MusicWebHubApplication::main).with(TestMusicWebHubApplication.class).run(args);
	}

}
