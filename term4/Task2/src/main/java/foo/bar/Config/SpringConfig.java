package foo.bar.Config;


import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import foo.bar.Computer;
import foo.bar.Graphics;
import foo.bar.Ram;

@Configuration
@ComponentScan("foo.bar")
public class SpringConfig {
	
	@Bean
	public Graphics ati() {
		return new Graphics("ATI_Radeon");
	}
	
	@Bean
	public Graphics adreno() {
		return new Graphics("Adreno 320");
	}
	
	@Bean
	public Ram ram1() {
		Ram ram = new Ram();
		ram.setCapacity(4);
		ram.setModel("Seagate");
		return ram;
	}
	
	@Bean
	public Ram ram2() {
		Ram ram = new Ram();
		ram.setCapacity(2);
		ram.setModel("LG");
		return ram;
	}
	
	@Bean
	public Computer computer() {
		Computer comp = new Computer();
		comp.setGraphics(ati());
		List<Ram> memory = new LinkedList<>();
		memory.add(ram1());
		memory.add(ram1());
		comp.setMemory(memory);
		return comp;
	}

}
