package foo.bar;

import java.util.List;

public class Computer {
	
	private AbstractGraphics graphics;
	
	private List<Ram> memory;
	
	public List<Ram> getMemory() {
		return memory;
	}

	public void setMemory(List<Ram> memory) {
		this.memory = memory;
	}

	public AbstractGraphics getGraphics() {
		return graphics;
	}

	@Override
	public String toString() {
		return "Graphics: " + getGraphics().getName() + "\nRAM: " + getMemory().toString();
	}

	public void setGraphics(AbstractGraphics graphics) {
		this.graphics = graphics;
	}


}
