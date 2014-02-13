package foo.bar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Smartphone {

	private AbstractGraphics graphics;
	private Ram memory;

	@Autowired
	public Smartphone(@Qualifier("adreno") AbstractGraphics graphics, @Qualifier("ram2") Ram memory) {
		this.graphics = graphics;
		this.memory = memory;
	}

	public AbstractGraphics getGraphics() {
		return graphics;
	}

	public Ram getMemory() {
		return memory;
	}

	@Override
	public String toString() {
		return "Graphics: " + getGraphics().getName() + "\nRAM: " + getMemory();
	}
	
	

}
