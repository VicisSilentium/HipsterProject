package hipster.controller;

import javax.swing.JOptionPane;
import hipster.model.Hipsteronic;
import hipster.view.HipsterFrame;

/**
 * Controller for the hipster project
 * 
 * @author Kyler Jensen
 * @version 1.2 11/21/13 Added constructor information and documentation.
 */
public class HipsterController
{
	// Declaration Section
	/**
	 * the HipsterFrame reference for MVC.
	 */
	private HipsterFrame appFrame;
	/**
	 * the Hipster object representing me.
	 */
	private Hipsteronic selfHipster;
	/**
	 * the array of hipsters for the cubicle.
	 */
	private Hipsteronic[] cubicleHipsters;
	/**
	 * The current inserted Hipster in the array.
	 */
	private int hipsterCount;

	/**
	 * The constructor for the HipsterController class
	 */
	public HipsterController()
	{
		selfHipster = new Hipsteronic();
		cubicleHipsters = new Hipsteronic[4];
		hipsterCount = 0;
	}

	/**
	 * Getter for the selfHipster object.
	 * 
	 * @return
	 */
	public Hipsteronic getSelfHipster()
	{
		return selfHipster;
	}

	/**
	 * Setter for the selfHipster object.
	 * 
	 * @param selfHipster
	 */
	public void setSelfHipster(Hipsteronic selfHipster)
	{
		this.selfHipster = selfHipster;
	}

	/**
	 * Used to start the application GUI to Unleash the Hipster project.
	 */
	public void start()
	{
		appFrame = new HipsterFrame(this);
	}

	public Hipsteronic[] getCubicleHipsters()
	{
		return cubicleHipsters;
	}

	/**
	 * used to retrieve a specified hipster object from the array of the
	 * Hipsteronic class.
	 * 
	 * @param position
	 * @return
	 */
	public Hipsteronic getSpecifiedHipster(int position)
	{
		Hipsteronic currentHipster = null;

		if (position < cubicleHipsters.length && position >= 0)
		{
			currentHipster = cubicleHipsters[position];
		}

		return currentHipster;
	}

	/**
	 * Used to retrieve a random Hipster object from the array of class
	 * Hipsteronic.
	 * 
	 * @return The randomly selected Hipster Method.
	 */
	public Hipsteronic getRandomHipster()
	{
		Hipsteronic currentHipster = null;

		int randomIndex = 0;
		double random = Math.random();
		randomIndex = (int) (random * cubicleHipsters.length);
		currentHipster = cubicleHipsters[randomIndex];

		return currentHipster;
	}

	/**
	 * Creates and adds a Hipster to the array of class Hipsteronic from the
	 * specified values.
	 * 
	 * @param books
	 *            The array of books for the current Hipster.
	 * @param name
	 *            The name of the current Hipster.
	 * @param type
	 *            The type of the current Hipster.
	 * @param phrase
	 *            This Hipster's current phrase of hipsterness.
	 */
	public void addHipster(String[] books, String name, String type, String phrase)
	{
		if (hipsterCount < cubicleHipsters.length)
		{
			Hipsteronic tempHipster = new Hipsteronic(name, type, phrase, books);
			cubicleHipsters[hipsterCount] = tempHipster;
			hipsterCount++;
		}
		else
		{
			JOptionPane.showMessageDialog(appFrame, "the cubicle is full, you're to mainstream to be added.");
		}
	}
}
