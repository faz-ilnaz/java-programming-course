package foo.bar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("notebook")
public class Notebook {
	
	@Autowired
	@Qualifier("integratedVideo")
	private AbstractGraphics integratedVideo;
	
	@Autowired
	@Qualifier("discreteVideo")
	private AbstractGraphics discreteVideo;
	
	public void getGraphics(String discrete, String integrated) {
		if(discreteVideo != null && integratedVideo != null) {
			System.out.println("Notebook has: " + discrete + " + " + integrated);
		}
	}
}
