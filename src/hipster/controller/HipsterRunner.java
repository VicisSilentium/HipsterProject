package hipster.controller;

/**
 * Starts the hipster project
 * @author Kyler Jensen
 * @version 1.0 11/19/2013
 *
 */
public class HipsterRunner
{

	/**
	 * the runner for the project.
	 * @param args
	 */
	public static void main(String[] args)
	{
		HipsterController myHipster = new HipsterController();
		myHipster.start();
		
	}

}
