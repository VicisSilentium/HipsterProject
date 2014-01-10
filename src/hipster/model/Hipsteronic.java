package hipster.model;

/**
 * Creates the Hipster object.
 * 
 * @author Kyler Jensen
 * @version 1.3 11/20/13 added getter/setters, overloaded constructor for
 *          additional hipsters.
 */
public class Hipsteronic
{
	// Declaration Section
	/**
	 * name of the Hipster.
	 */
	private String name;
	/**
	 * type of the Hipster.
	 */
	private String hipsterType;
	/**
	 * phrase of the Hipster.
	 */
	private String hipsterPhrase;
	/**
	 * collection of the Hipster's books.
	 */
	private String[] hipsterBooks;

	/**
	 * Constructor for the Hipsteronic class.
	 */
	public Hipsteronic()
	{
		hipsterBooks = new String[5];
		name = "Kyler";
		hipsterType = "Band Hipster";
		hipsterPhrase = "Cool beans";

		fillTheBooks();
	}

	/**
	 * overloaded constructor for the Hipsteronic class.
	 * 
	 * @param name
	 *            of the Hipster.
	 * @param hipsterType
	 *            type of the Hipster.
	 * @param hipsterPhrase
	 *            phrase of the Hipster.
	 * @param hipsterBooks
	 *            An array of books for the Hipster
	 */
	public Hipsteronic(String name, String hipsterType, String hipsterPhrase, String[] hipsterBooks)
	{
		this.name = name;
		this.hipsterBooks = hipsterBooks;
		this.hipsterType = hipsterType;
		this.hipsterPhrase = hipsterPhrase;
	}

	/**
	 * Getter for the name object.
	 * 
	 * @return The name of the Hipster.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Getter for the hipsterType object.
	 * 
	 * @return The Hipster type.
	 */
	public String getHipsterType()
	{
		return hipsterType;
	}

	/**
	 * getter for the hipsterPhrase object.
	 * 
	 * @return The chatch-phrase fpr this Hipster.
	 */
	public String getHipsterPhrase()
	{
		return hipsterPhrase;
	}

	/**
	 * getter for the hipsterBooks array.
	 * 
	 * @return The array of Hipster books.
	 */
	public String[] getHipsterBooks()
	{
		return hipsterBooks;
	}

	/**
	 * Setter for the name object.
	 * 
	 * @param name
	 *            The noew name of the Hipster.
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Setter for the hipsterType object.
	 * 
	 * @param hipsterType
	 *            The new type of Hipster.
	 */
	public void setHipsterType(String hipsterType)
	{
		this.hipsterType = hipsterType;
	}

	/**
	 * Setter for the hipsterPhrase object.
	 * 
	 * @param hipsterPhrase
	 *            The new phrase of the Hipster.
	 */
	public void setHipsterPhrase(String hipsterPhrase)
	{
		this.hipsterPhrase = hipsterPhrase;
	}

	/**
	 * Setter for the hipsterBooks Array.
	 * 
	 * @param hipsterBooks
	 *            The new array of books for the Hipster.
	 */
	public void setHipsterBooks(String[] hipsterBooks)
	{
		this.hipsterBooks = hipsterBooks;
	}

	/**
	 * A helper method which fills the book array for the Hipster.
	 */
	private void fillTheBooks()
	{
		hipsterBooks[0] = "Oford Dictionary";
		hipsterBooks[1] = "Song of Ice and Fire";
		hipsterBooks[2] = "Enders Game";
		hipsterBooks[3] = "Thirteenth Reality";
		hipsterBooks[4] = "Rangers Apprentice";
	}
}
