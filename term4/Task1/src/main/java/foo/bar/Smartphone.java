package foo.bar;

public class Smartphone {

	private AbstractGraphics graphics;

	private Ram memory;

	public Smartphone(AbstractGraphics graphics, Ram memory) {
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
