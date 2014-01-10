package hipster.view;

import hipster.controller.HipsterController;
import hipster.model.Hipsteronic;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class HipsterPanel extends JPanel
{
	// Declaration Section
	private HipsterController baseController;
	private JButton addHipsterButton;
	private JButton showRandomButton;
	private JButton showSpecificButton;
	private JButton showSelfButton;
	private JLabel nameLabel;
	private JLabel phraseLabel;
	private JLabel typeLabel;
	private JLabel booksLabel;
	private JComboBox selectedHipsterComboBox;
	private JTextField nameField;
	private JTextField phraseField;
	private JTextField typeField;
	private JTextArea booksArea;
	private PicturePanel picturePanel;
	private URL imageURL;
	private SpringLayout baseLayout;
	private String[] baseArray;

	/**
	 * Constructor for the HipsterPanel object. Uses a HipsterController to link
	 * to the MVC paradigm.
	 * 
	 * @param baseController
	 */
	public HipsterPanel(HipsterController baseController)
	{
		this.baseController = baseController;

		addHipsterButton = new JButton("Add a Hipster");
		showRandomButton = new JButton("Show a random Hipster");
		showSpecificButton = new JButton("Show a certian Hipster");
		showSelfButton = new JButton("Show the original Hipster");
		nameField = new JTextField(25);
		phraseField = new JTextField(25);
		typeField = new JTextField(25);
		nameLabel = new JLabel("Hipster's Name: ");
		booksLabel = new JLabel("Hipster's Books: ");
		phraseLabel = new JLabel("Hipster's Phrase: ");
		typeLabel = new JLabel("Hipster's Type: ");
		booksArea = new JTextArea(5, 25);
		baseArray = new String[3];

		imageURL = getClass().getResource("/hipster/view/images/BatSpoon.jpg");
		picturePanel = new PicturePanel(imageURL, 200, 200);

		baseLayout = new SpringLayout();

		setupComboBox();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupComboBox()
	{
		baseArray[0] = "Me";
		baseArray[1] = "Myself";
		baseArray[2] = "I";

		selectedHipsterComboBox = new JComboBox(baseArray);
	}

	/**
	 * Populates the fields based on the current Hipster object.
	 * 
	 * @param currentHipster
	 *            The current specified Hipster.
	 */
	private void populateFields(Hipsteronic currentHipster)
	{
		// imageURL = getClass().getResource("/Hipster Project/ veiw/images/" +
		// currentHipster.getName() + ".jpg");
		// picturePanel.setPictureSource(imageURL);

		nameField.setText(currentHipster.getName());
		typeField.setText(currentHipster.getHipsterType());
		phraseField.setText(currentHipster.getHipsterType());
		booksArea.setText("");
		for (String temp : currentHipster.getHipsterBooks())
		{
			booksArea.append(temp + ", ");
		}

	}

	private void blankFields(boolean poorInput)
	{
		nameField.setText("");
		typeField.setText("");
		phraseField.setText("");
		booksArea.setText("");
		if (poorInput)
		{
			JOptionPane.showMessageDialog(this, "please use valid options");
		}
	}

	/**
	 * Sends information to the HipsterController.
	 */
	private void sendHipsterInfoToController()
	{
		String[] books = booksArea.getText().split(", ");
		baseController.addHipster(books, nameField.getText(),
				typeField.getText(), phraseField.getText());
		JOptionPane.showMessageDialog(this, "Hipster " + nameField.getText()
				+ " added to the array.");
	}

	/**
	 * Helper method to add components to the panel as well as set secondary
	 * values for GUI components.
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(addHipsterButton);
		this.add(showRandomButton);
		this.add(showSpecificButton);
		this.add(showSelfButton);
		this.add(nameLabel);
		this.add(phraseLabel);
		this.add(typeLabel);
		this.add(booksLabel);
		this.add(nameField);
		this.add(phraseField);
		this.add(typeField);
		this.add(booksArea);
		this.add(picturePanel);
		this.add(selectedHipsterComboBox);

		this.setBackground(new Color(130, 100, 50));
		this.setSize(1000, 450);
		booksArea.setWrapStyleWord(true);
		booksArea.setLineWrap(true);

	}

	/**
	 * method that sets up the layout of the content of the panel.
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, showSelfButton, 65,
				SpringLayout.SOUTH, showRandomButton);
		baseLayout.putConstraint(SpringLayout.WEST, showSpecificButton, 263,
				SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, showSpecificButton, -83,
				SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, showSelfButton, 0,
				SpringLayout.WEST, nameLabel);
		baseLayout.putConstraint(SpringLayout.WEST, showRandomButton, 0,
				SpringLayout.WEST, nameLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, addHipsterButton, 22,
				SpringLayout.SOUTH, booksArea);
		baseLayout.putConstraint(SpringLayout.WEST, addHipsterButton, 0,
				SpringLayout.WEST, nameLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, selectedHipsterComboBox,
				18, SpringLayout.SOUTH, showRandomButton);
		baseLayout.putConstraint(SpringLayout.WEST, selectedHipsterComboBox, 0,
				SpringLayout.WEST, addHipsterButton);
		baseLayout.putConstraint(SpringLayout.NORTH, booksLabel, 0,
				SpringLayout.NORTH, booksArea);
		baseLayout.putConstraint(SpringLayout.WEST, booksLabel, 0,
				SpringLayout.WEST, nameLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, nameField, 22,
				SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, nameLabel, 6,
				SpringLayout.NORTH, nameField);
		baseLayout.putConstraint(SpringLayout.WEST, nameLabel, 0,
				SpringLayout.WEST, phraseLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, typeLabel, 6,
				SpringLayout.NORTH, typeField);
		baseLayout.putConstraint(SpringLayout.WEST, typeLabel, 0,
				SpringLayout.WEST, phraseLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, phraseLabel, 6,
				SpringLayout.NORTH, phraseField);
		baseLayout.putConstraint(SpringLayout.WEST, phraseLabel, 10,
				SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, booksArea, 18,
				SpringLayout.SOUTH, phraseField);
		baseLayout.putConstraint(SpringLayout.WEST, booksArea, 0,
				SpringLayout.WEST, nameField);
		baseLayout.putConstraint(SpringLayout.NORTH, phraseField, 17,
				SpringLayout.SOUTH, typeField);
		baseLayout.putConstraint(SpringLayout.NORTH, typeField, 11,
				SpringLayout.SOUTH, nameField);
		baseLayout.putConstraint(SpringLayout.WEST, typeField, 0,
				SpringLayout.WEST, nameField);
		baseLayout.putConstraint(SpringLayout.WEST, phraseField, 0,
				SpringLayout.WEST, nameField);
		baseLayout.putConstraint(SpringLayout.WEST, nameField, 175,
				SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, picturePanel, -220,
				SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, picturePanel, -200,
				SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, picturePanel, -20,
				SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, picturePanel, -20,
				SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, showRandomButton, 18,
				SpringLayout.SOUTH, addHipsterButton);
	}

	/**
	 * Helper method to get the contents of the HIpster array and extracting the
	 * names of the Hipster's in it.
	 * 
	 * @return A String [] Containing all of the names of the existing members
	 *         of the Hipster array.
	 */
	private String[] getNamesForComboBox()
	{
		int realValues = 0;
		for (int count = 0; count < baseController.getCubicleHipsters().length; count++)
		{
			if (baseController.getCubicleHipsters()[count] != null)
			{
				realValues++;
			}
		}

		String[] tempNames = new String[realValues];

		for (int realSize = 0; realSize < realValues; realSize++)
		{
			tempNames[realSize] = baseController.getCubicleHipsters()[realSize]
					.getName();
		}

		return tempNames;
	}

	/**
	 * Helper method to re-populate the JComboBox after adding Hipster's to the
	 * array.
	 */
	private void updateHipsterComboBox()
	{
		String[] comboValues = getNamesForComboBox();
		selectedHipsterComboBox.setModel(new DefaultComboBoxModel(comboValues));
	}

	/**
	 * Helper method for creating all the needed listeners for the GUI.
	 */
	private void setupListeners()
	{
		addHipsterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				sendHipsterInfoToController();
				updateHipsterComboBox();
				blankFields(false);
			}

		});

		showSelfButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Hipsteronic selfHipster = baseController.getSelfHipster();
				populateFields(selfHipster);
			}

		});

		showSpecificButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				Hipsteronic selectedHipster = baseController
						.getSpecifiedHipster(0);
				if (selectedHipster != null)
				{
					populateFields(selectedHipster);
				}
				else
				{
					blankFields(true);
				}
			}
		});

		showRandomButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Hipsteronic randomHipster = baseController.getRandomHipster();
				if (randomHipster != null)
				{
					populateFields(randomHipster);
				}
				else
				{
					blankFields(true);
				}
			}
		});

		selectedHipsterComboBox.addItemListener(new ItemListener()
		{

			@Override
			public void itemStateChanged(ItemEvent itemSelected)
			{
				int currentSelection = selectedHipsterComboBox
						.getSelectedIndex();
				if (currentSelection >= 0)
				{
					Hipsteronic selectedHipster = baseController
							.getSpecifiedHipster(currentSelection);
					if (selectedHipster != null)
					{
						populateFields(selectedHipster);
					}
					else
					{
						blankFields(true);
					}
				}
			}
		});
	}

}
