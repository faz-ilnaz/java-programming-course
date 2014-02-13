package foo.bar;

public class Graphics implements AbstractGraphics {
	
	private String name;

	public Graphics(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
