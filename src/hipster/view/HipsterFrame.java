package hipster.view;

import javax.swing.JFrame;
import hipster.controller.HipsterController;

/**
 * Creates a JFrame for the project.
 * 
 * @author Kyler Jensen
 * @version 1.1 11/20/13
 */
public class HipsterFrame extends JFrame
{

	// Declaration Section
	/**
	 * The link to the Controller for the Constructor.
	 */
	private HipsterController baseController;
	/**
	 * The link to the Panel for the Frame.
	 */
	private HipsterPanel basePanel;

	/**
	 * The constructor for the HipsterFrame class.
	 * 
	 * @param baseController
	 *            Link to HipsterController.
	 */
	public HipsterFrame(HipsterController baseController)
	{
		this.baseController = baseController;
		basePanel = new HipsterPanel(baseController);

		setupFrame();
	}

	/**
	 * The method which sets up the frame size and visibility.
	 */
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(450, 450);
		this.setVisible(true);
	}

}
