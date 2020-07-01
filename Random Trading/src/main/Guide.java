package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import trader.RandName;
import trader.TraderInfo;

/*
Ideas for Future Releases: 
Use Ratios for resizing!
Add an option to log out, say that you are logged in as blank
Add a scenario page, ask the user to pick a scenario like minecraft chooser theme!
Create a txt file that indicates whether a user is logged in or not (true or false w/ username) && display logged in as...
Add a keylistener to scroll up and down!
*/

/**
 * This is the main method where it will guide the user into playing the game
 * 
 * @author suncloudsmoon
 * @version 0.8.0
 * @since 0.6.0
 *
 */

public class Guide implements ActionListener {

	// Game Objects
	private static TradingHub trade = new TradingHub();
	/**
	 * Used to indicate the progress of game that the user completes and provides an
	 * option to reset progress
	 * 
	 * @since 0.7.0
	 */
	public static int stage = 0;

	/**
	 * A String object that stores the trader's name
	 * 
	 * @since 0.7.0
	 */
	public static String tradername = null;
	/**
	 * A String object that stores the user input from JComboBox and a shortcut to
	 * access user input
	 * 
	 * @since 0.7.0
	 */
	public static String userinput;
	private int tradingcount = 0;

	// Frame and panel
	private static JFrame frame;
	private static JPanel panel;

	// Logger File
	private static Logger log;
	private static FileHandler handler;

	/* <<<<<<<MENU>>>>>>>> */

	// Menu Bar
	private static JMenuBar menubar;
	// File Menu
	private static JFileChooser file;
	private static JMenu filemenubar;
	private static JMenuItem exitmenubar;
	private static JMenuItem gobackmenubar;
	private static JMenuItem saveconversationmenu;
	// Help Menu
	private static JMenu helpmenubar;
	private static JMenuItem aboutmenubar;
	private static JMenuItem reportmenubar;
	private static JMenuItem checkforupdatesmenu;
	// Menu Buttons
	private static JButton playmenu;
	private static JButton settingsmenu;
	private static JButton helpmenu;
	// Game Menu
	private static JMenu game;
	private static JCheckBoxMenuItem machinelearning;

	// Playing the game screen...
	/**
	 * Can append text from other classes
	 * 
	 * @since 0.7.0
	 */
	public static JTextArea textarea;
	/**
	 * In other classes, you can change the text appearing in the JComboBox via this
	 * public function
	 * 
	 * @since 0.7.0
	 */
	public static JComboBox textfield;

	private static JButton sendmessage;
	private static JScrollPane scrollpane;

	// Menu Screen Labels
	private static JLabel welcome;

	// Menu Screen Button Sounds (for the future when I learn how to create new
	// sound!)
	/*
	 * private static AudioInputStream buttonsetup; private static Clip playbutton;
	 */

	// Help Screen Buttons
	private static JButton gotoplay;
	private static JButton goback;
	// Help Screen Labels
	private static JLabel helplabel;
	private static JTextArea helptextarea;

	// Login screen
	private static JLabel loginlabel;
	private static JLabel usernamelabel;
	private static JLabel or;
	private static JComboBox combinationbox;
	private static JButton loginbutton;
	private static JButton createnewuser;
	private static JButton continueasguest;
	// Login usernames stored here
	private static ArrayList<String> usernamestore = new ArrayList<>();

	// Create New Account screen
	private static JTextField usernamecreateauserfield;
	private static JButton createaccount;
	private static ButtonGroup difficultyradiobuttongrouped;
	private static JRadioButton noobradiobutton;
	private static JRadioButton entrepreneurradiobutton;
	private static JRadioButton businesstycoonradiobutton;
	private static JLabel createnewuserlabel;
	private static JLabel usernamecreatenewuserlabel;
	private static JLabel difficultynewuser;

	// Scenario Chooser List
	private static JButton edit;
	private static JButton createnew;
	private static JButton playgame;
	private static JList scenariolisted;
	private static JScrollPane scrollit;
	private static ArrayList<String> scenarioinhere = new ArrayList<>();

	// Settings page
	private static JButton settingsgoback;
	private static JLabel nicknamechange;
	private static JComboBox nicknamesuggest;

	/* <<<<<<Counters>>>>>> */
	private static int helpcounter = 0;

	/**
	 * This is where the actual gameplay happens
	 * 
	 * @since 0.6.0
	 */
	public Guide() {

		// Adding a Game Menu && rearranging help menu to the last
		menubar.remove(helpmenubar);
		menubar.add(game);
		menubar.add(helpmenubar);

		// Trader's Name
		TraderInfo.name = RandName.tradername();
		tradername = TraderInfo.name.substring(0, 1).toUpperCase()
				+ TraderInfo.name.substring(2, TraderInfo.name.length() - 1);

		// Adding a TextArea
		textarea = new JTextArea();
		textarea.append(tradername + ": How are you doing today?\nYou: ");

		textarea.setBounds(0, 26, 245, 135);
		textarea.setEditable(false);
		textarea.setWrapStyleWord(true);
		textarea.setLineWrap(true);
		panel.add(textarea);

		// Adding a ScrollPane to TextArea
		scrollpane = new JScrollPane(textarea);
		scrollpane.setBounds(0, 25, 340, 210);
		scrollpane.setBorder(new TitledBorder(new EtchedBorder(), "Trader " + tradername));
		scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.add(scrollpane, BorderLayout.EAST);

		// Adding a JButton...
		sendmessage = new JButton();
		sendmessage.setBounds(287, 243, 50, 30);
		sendmessage.addActionListener(this);
		sendmessage.setText("=>");
		panel.add(sendmessage);

		// Adding a TextField && true height of textarea = 165
		textfield = new JComboBox(usernamestore.toArray());
		textfield.setBounds(3, 243, 282, 30);
		textfield.setBorder(new LineBorder(Color.darkGray, 1, true));
		textfield.setOpaque(true);
		textfield.setEditable(true);
		panel.add(textfield);

		textfield.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
			int counter = 0;

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					trading();
				if (counter == 0)
					textfield.showPopup();
				counter++;
			}

		});

		/*
		 * // Adding Tabs JTabbedPane tabs = new JTabbedPane(); JComponent component =
		 * panel; tabs.addTab("lol", component);
		 */

		/*
		 * // Image Experiment String locationimage = "Small Sheep Icon.png"; ImageIcon
		 * image1 = new ImageIcon(locationimage); JLabel label1 = new JLabel(image1,
		 * JLabel.CENTER); label1.setBounds(200, 200, 200, 200); panel.add(label1);
		 */

		frame.setTitle("Trader's Destiny");

	}

	/**
	 * This is the main menu screen
	 * 
	 * @param Menu pass a condition of true or false to activate this constructor
	 * @since 0.6.0
	 */
	public Guide(boolean Menu) {

		log.info("User is in the main menu");

		if (helpcounter < 1) {
			// Setting up the main frame...
			frame = new JFrame();
			frame.setSize(350, 310);

			// Setting up the layout...
			panel = new JPanel();
			panel.setLayout(null);

			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				JOptionPane.showInternalMessageDialog(null, "Unable to access your os's icon theme:\n" + e.getMessage(),
						"UI Initialization Error", JOptionPane.ERROR_MESSAGE);
			} catch (UnsupportedLookAndFeelException e) {
				JOptionPane.showInternalMessageDialog(null, "Os's icon theme is missing:\n" + e.getMessage(),
						"UI Not Found", JOptionPane.ERROR_MESSAGE);
			}

		}

		// A Text label saying Welcome or something like that
		welcome = new JLabel("Welcome to Trader's Destiny!");
		welcome.setBounds(85, 55, 200, 25);
		panel.add(welcome);

		// Play button will wipe this panel and create a new panel! (75, 50, 100, 25)
		playmenu = new JButton("Play");
		playmenu.setBounds(110, 100, 100, 25);
		playmenu.addActionListener(this);
		panel.add(playmenu);

		// Help button for newbies
		helpmenu = new JButton("Help");
		helpmenu.setBounds(110, 135, 100, 25);
		helpmenu.addActionListener(this);
		panel.add(helpmenu, BorderLayout.NORTH);

		// Settings button for people to personalize their experience!
		settingsmenu = new JButton("Settings");
		settingsmenu.setBounds(110, 170, 100, 25);
		settingsmenu.addActionListener(this);
		panel.add(settingsmenu);

		if (helpcounter < 1) {
			// <<<<<<<<<<<<<<<<MENUBAR>>>>>>>>>>>>>>>>>>>>

			// Adding a menubar!
			menubar = new JMenuBar();
			menubar.setBounds(0, 0, 350, 25);
			panel.add(menubar);

			// Adding a file menu!
			filemenubar = new JMenu("File");
			menubar.add(filemenubar);

			// Adding go back item to file menu!
			gobackmenubar = new JMenuItem("Return to Main Menu");
			gobackmenubar.addActionListener(this);

			// Adding a save conversation menu item to file menu!
			saveconversationmenu = new JMenuItem("Save Conversation...");

			// Adding an option to save conversation...
			saveconversationmenu.addActionListener(this);
			filemenubar.add(saveconversationmenu);

			// Adding exit item to file menu!
			exitmenubar = new JMenuItem("Exit");
			exitmenubar.addActionListener(this);
			filemenubar.add(exitmenubar);

			// Adding a help menu!
			helpmenubar = new JMenu("Help");
			menubar.add(helpmenubar);

			// Adding Report bugs or crashes to help menu!
			reportmenubar = new JMenuItem("Report Bugs or Crashes...");
			reportmenubar.addActionListener(this);
			helpmenubar.add(reportmenubar);

			// Adding a check for updates option
			checkforupdatesmenu = new JMenuItem("Check for Updates");
			checkforupdatesmenu.addActionListener(this);
			helpmenubar.add(checkforupdatesmenu);

			// Adding about to help menu!
			aboutmenubar = new JMenuItem("About");
			aboutmenubar.addActionListener(this);
			helpmenubar.add(aboutmenubar);

			// Added Game Menu
			game = new JMenu("Game");

			// Added the option to reset all progress in the game...
			JMenuItem reset = new JMenuItem("Reset Progress...");
			reset.addActionListener(this);
			game.add(reset);

			// Added Autocomplete option to Game Menu
			JCheckBoxMenuItem autocomplete = new JCheckBoxMenuItem("Autocomplete");
			autocomplete.addActionListener(this);
			game.add(autocomplete);

			// Added machine learning option to Game menu
			machinelearning = new JCheckBoxMenuItem("Machine Learning");
			machinelearning.addActionListener(this);
			game.add(machinelearning);

			// Setting the frame visible...
			frame.add(panel, BorderLayout.CENTER);
			frame.setTitle("Trader's Destiny");
			frame.setResizable(true); // Temporarily only
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}

	/**
	 * If the user is new to our program, the user can go to the help section to
	 * learn more about our app
	 * 
	 * @param help pass in a String object to activate this constructor
	 * @since 0.6.0
	 */
	public Guide(String help) {
		log.info("In the help section...");

		// JLabel to highlight that this section is for help!
		helplabel = new JLabel("Help");
		helplabel.setBounds(145, 25, 30, 25);
		panel.add(helplabel);

		// TextArea describing how the game functions
		helptextarea = new JTextArea();
		helptextarea.setBounds(60, 50, 200, 100); // this was interfering with the buttons!
		helptextarea.setOpaque(false);
		helptextarea.setEditable(false);
		helptextarea.setLineWrap(true);
		helptextarea.append("To play this exiting game, type \nwhatever the game says and you will\nbe good to go!");
		panel.add(helptextarea);

		// Play Button
		gotoplay = new JButton("Play =>");
		gotoplay.setBounds(170, 245, 80, 25);
		gotoplay.addActionListener(this);
		panel.add(gotoplay);

		// Back Button
		goback = new JButton("<= Go Back");
		goback.setBounds(65, 245, 100, 25);
		goback.addActionListener(this);
		panel.add(goback);

		frame.setTitle("Help - Trader's Destiny");
	}

	/**
	 * The user is given the option to directly login, create new account, or
	 * continue as guest
	 * 
	 * @param login pass in a byte value to activate this constructor
	 * @since 0.6.0
	 */
	public Guide(byte login) {

		// Login text on the top of the page
		loginlabel = new JLabel("Login:");
		loginlabel.setBounds(160, 30, 50, 25);
		panel.add(loginlabel);

		// Username label
		usernamelabel = new JLabel("Username:");
		usernamelabel.setBounds(30, 60, 70, 25);
		panel.add(usernamelabel);

		// Finding all the available usernames...
		try {
			Guide.loginOptions();
		} catch (Exception e) {
			log.info("Unable to access login info: " + e.getMessage());
			// JOptionPane.showInternalMessageDialog(null, "Unable to access crucial login
			// info:\n" + e.toString(), "Login Error", JOptionPane.ERROR_MESSAGE);
		}

		// A JComboBox for login
		combinationbox = new JComboBox(usernamestore.toArray());
		combinationbox.setBounds(100, 60, 200, 25);
		combinationbox.setEditable(true);
		panel.add(combinationbox);

		combinationbox.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				
				if (!combinationbox.isPopupVisible()) {
					combinationbox.showPopup();
				}
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					logincheck();
				}
				

			}
		});

		// A JButton for login
		loginbutton = new JButton("Login");
		loginbutton.setBounds(125, 100, 100, 25);
		loginbutton.addActionListener(this);
		panel.add(loginbutton);

		// JLabel asking for signup
		Font big = new Font("boldfont", Font.BOLD, 15);
		or = new JLabel("or");
		or.setFont(big);
		or.setBounds(168, 125, 20, 30);
		panel.add(or);

		// Or create new user (175, 160, 150, 25)
		createnewuser = new JButton("Create new user");
		createnewuser.setBounds(20, 160, 150, 25);
		createnewuser.addActionListener(this);
		panel.add(createnewuser);

		// Or continue as guest (20, 160, 150, 25)
		continueasguest = new JButton("Continue as Guest");
		continueasguest.setBounds(175, 160, 150, 25);
		continueasguest.addActionListener(this);
		panel.add(continueasguest);

		// Removing JMenuItems for gobackmenubar to appear at the top of the list!
		filemenubar.remove(exitmenubar);
		filemenubar.remove(saveconversationmenu);

		// Adding JMenuItems...
		filemenubar.add(gobackmenubar);
		filemenubar.add(saveconversationmenu);
		filemenubar.add(exitmenubar);

		frame.setTitle("Login - Trader's Destiny");

	}

	/**
	 * The user is given the option to tweak and customize the features in this app
	 * 
	 * @param settings pass in a long parameter to activate this function
	 * @since 0.6.0
	 */
	public Guide(long settings) {

		// An option to change nickname
		nicknamechange = new JLabel("Nickname:");
		nicknamechange.setBounds(10, 40, 75, 25);
		panel.add(nicknamechange);

		// A combobox suggesting funny nicknames!
		nicknamesuggest = new JComboBox();
		nicknamesuggest.setBounds(80, 40, 125, 25);
		nicknamesuggest.setEditable(true);
		panel.add(nicknamesuggest);

		// JLabel for difficulty
		difficultynewuser = new JLabel("Difficulty:");
		difficultynewuser.setBounds(10, 90, 70, 25);
		panel.add(difficultynewuser);

		// Noob JRadioButton
		noobradiobutton = new JRadioButton("Noob");
		noobradiobutton.setBounds(75, 90, 110, 25);
		noobradiobutton.setSelected(true);
		panel.add(noobradiobutton);

		// Entrepreneur
		entrepreneurradiobutton = new JRadioButton("Entrepreneur");
		entrepreneurradiobutton.setBounds(75, 110, 100, 25);
		panel.add(entrepreneurradiobutton);

		businesstycoonradiobutton = new JRadioButton("Business Tycoon");
		businesstycoonradiobutton.setBounds(75, 130, 150, 25);
		panel.add(businesstycoonradiobutton);

		difficultyradiobuttongrouped = new ButtonGroup();

		difficultyradiobuttongrouped.add(noobradiobutton);
		difficultyradiobuttongrouped.add(entrepreneurradiobutton);
		difficultyradiobuttongrouped.add(businesstycoonradiobutton);

		// JButton for going back to the main menu!
		settingsgoback = new JButton("<= Go Back");
		settingsgoback.setBounds(110, 245, 100, 25);
		settingsgoback.addActionListener(this);
		panel.add(settingsgoback);
	}

	/**
	 * If the user clicks on the create new user in the login page, the user is
	 * directed to a create new user page where the user is asked to provide a new
	 * username and *nickname
	 * 
	 * @param createuser pass in a short primitive type parameter to activate this
	 *                   constructor
	 * @since 0.6.0
	 */
	public Guide(short createuser) {

		// A JLabel that informs the user that this page is dedicated for creating user
		// accounts!
		createnewuserlabel = new JLabel("Create your brand new user account:");
		createnewuserlabel.setBounds(60, 30, 230, 25);
		panel.add(createnewuserlabel);

		// JLabel indicating the user that JTextField usernamecreateauserfield is for
		// creating a new user account
		usernamecreatenewuserlabel = new JLabel("Username:");
		usernamecreatenewuserlabel.setBounds(15, 65, 70, 25);
		panel.add(usernamecreatenewuserlabel);

		// JTextField for creating new username
		usernamecreateauserfield = new JTextField();
		usernamecreateauserfield.setBounds(80, 65, 150, 25);
		panel.add(usernamecreateauserfield);

		// JLabel for difficulty
		difficultynewuser = new JLabel("Difficulty:");
		difficultynewuser.setBounds(15, 110, 70, 25);
		panel.add(difficultynewuser);

		// Noob JRadioButton
		noobradiobutton = new JRadioButton("Noob");
		noobradiobutton.setBounds(80, 110, 100, 25);
		noobradiobutton.setSelected(true);
		panel.add(noobradiobutton);

		// Entrepreneur
		entrepreneurradiobutton = new JRadioButton("Entrepreneur");
		entrepreneurradiobutton.setBounds(80, 130, 100, 25);
		panel.add(entrepreneurradiobutton);

		businesstycoonradiobutton = new JRadioButton("Business Tycoon");
		businesstycoonradiobutton.setBounds(80, 150, 150, 25);
		panel.add(businesstycoonradiobutton);

		difficultyradiobuttongrouped = new ButtonGroup();

		difficultyradiobuttongrouped.add(noobradiobutton);
		difficultyradiobuttongrouped.add(entrepreneurradiobutton);
		difficultyradiobuttongrouped.add(businesstycoonradiobutton);

		createaccount = new JButton("Create Account");
		createaccount.setBounds(95, 200, 130, 25);
		createaccount.addActionListener(this);
		panel.add(createaccount);

		frame.setTitle("Create new user - Trader's Destiny");

	}

	/**
	 * The user can create unlimited amount of scenarios (in which each of them are
	 * unique), edit those scenarios, and play them
	 * 
	 * @param scenariochooser pass in a char primitive type parameter to activate
	 *                        this constructor
	 * @since 0.6.0
	 */
	public Guide(char scenariochooser) {
		// Scenario chooser
		// There will be a triangle of options - edit, new, play
		// Down will be a JList and a scrollpaneconstants attached to it

		// Edit button
		edit = new JButton("Edit");
		edit.setBounds(125, 35, 60, 25);
		edit.addActionListener(this);
		panel.add(edit);

		// New button
		createnew = new JButton("New");
		createnew.setBounds(95, 60, 60, 25);
		createnew.addActionListener(this);
		panel.add(createnew);

		// Play button
		playgame = new JButton("Play");
		playgame.setBounds(155, 60, 60, 25);
		playgame.addActionListener(this);
		panel.add(playgame);

		// List of scenarios
		scenarioinhere.add("hello");
		scenariolisted = new JList(scenarioinhere.toArray());

		// Scrollpane containing all the list of scenarios!
		scrollit = new JScrollPane(scenariolisted);
		scrollit.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollit.setBounds(10, 95, 320, 150);
		panel.add(scrollit, BorderLayout.EAST);

		frame.setTitle("Scenario Chooser - Trader's Destiny");

	}

	/**
	 * The user is given the option to pick the *title for the new scenario,
	 * *difficulty level, and *machine learning methods
	 * 
	 * @param createnewscenario
	 * @since 0.6.0
	 */
	public Guide(double createnewscenario) {

	}

	/**
	 * Checks for the amount of usernames stored in the usernames.txt
	 * 
	 * @since 0.6.0
	 */
	private static void loginOptions() {

		// Collecting all login usernames...

		File login = new File("C:\\Trader's Destiny\\File Storage\\usernames.txt");
		BufferedReader checklogin = null;

		try {
			if (usernamestore != null) {
				FileReader reader1 = new FileReader(login);
				checklogin = new BufferedReader(reader1);
				String readline;
				while ((readline = checklogin.readLine()) != null) {
					String[] usernamessplit = readline.split("-");
					String[] usernamessplitcheck = usernamessplit[0].split("=");
					usernamestore.add(usernamessplitcheck[1]);

				}
			}

		} catch (FileNotFoundException e) {
			log.info("File path for username.txt is untraceable: " + e.getMessage());
			// JOptionPane.showInternalMessageDialog(null, "File path for username info is
			// missing:\n" + e.getMessage(), "Login Access Denied",
			// JOptionPane.ERROR_MESSAGE);

		} catch (IOException e) {
			log.info("System was unable to access username info due to an IOException: " + e.getMessage());
			JOptionPane.showInternalMessageDialog(null, "Unable to access username info:\n" + e.getMessage(),
					"Internal Error", JOptionPane.ERROR_MESSAGE);

		} finally {
			try {
				checklogin.close();
			} catch (IOException e) {
				JOptionPane.showInternalMessageDialog(null, "Unable to close login info file:\n" + e.getMessage(),
						"Internal Error", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	/**
	 * Located in the login page, this function checks whether the username input
	 * provided by the user matches a username in the usernames.txt database
	 * 
	 * @since 0.6.5
	 */
	private void logincheck() {
		boolean correctusername = false;
		for (int i = 0; i < usernamestore.size(); i++) {
			if (usernamestore.get(i).equals(combinationbox.getSelectedItem())) {
				correctusername = true;
			}
		}
		if (correctusername) {
			log.info("User successfully logged in");
			panel.remove(loginlabel);
			panel.remove(usernamelabel);
			panel.remove(combinationbox);
			panel.remove(loginbutton);
			panel.remove(or);
			panel.remove(createnewuser);
			panel.remove(continueasguest);
			panel.revalidate();
			panel.repaint();
			new Guide('a');
		} else {
			JOptionPane.showInternalMessageDialog(null, "Username is incorrect", "Username Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * If the user clicks on the sendmessage button or hits the enter key, this
	 * function is activated. Furthermore, this function sets up the interaction
	 * between the user and the interested merchant
	 * 
	 * @since 0.6.5
	 */
	private void trading() {
		if (tradingcount != 0) {
			textarea.append("You: " + textfield.getSelectedItem());
		} else {
			textarea.append((String) textfield.getSelectedItem());
			tradingcount++;
		}

		userinput = (String) textfield.getSelectedItem();

		if (stage == 0) {
			trade.traderprofile();
		} else if (stage == 1) {
			trade.buyinginterest();
		} else if (stage == 2) {
			trade.moneycheck();
		} else if (stage == 3) {
			trade.askreceipt();
		} else {
			JOptionPane.showMessageDialog(null, "Unable to fetch info", "Info Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String[] args) {
		try {
			new File("C:\\Trader's Destiny\\File Storage").mkdirs();

		} catch (SecurityException e) {
			JOptionPane.showInternalMessageDialog(null,
					"Unable to create resource folder for this app:\n" + e.getMessage(), "Internal Error",
					JOptionPane.ERROR_MESSAGE);
		}

		try {
			log = Logger.getLogger("");
			handler = new FileHandler("C:\\Trader's Destiny\\LogBook.log", true);
			SimpleFormatter logformat = new SimpleFormatter();
			handler.setFormatter(logformat);
			log.addHandler(handler);
		} catch (SecurityException e) {
			log.info("User encountered a SecurityException for log file: " + e.getMessage());
			JOptionPane.showInternalMessageDialog(null, "Log file breached security protocols:\n" + e.getMessage(),
					"Security Intrusion", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			log.info("User encountered an IOException for log file: " + e.getMessage());
			JOptionPane.showInternalMessageDialog(null, "Unable to access log file:\n" + e.getMessage(),
					"Internal Error", JOptionPane.ERROR_MESSAGE);
		}

		new Guide(true);
		/*
		 * if (menuorgame == true) {
		 * 
		 * } else if (menuorgame == false) { new Demo(); }
		 */

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// I don't know how to use this!
		if (e.getSource() == playmenu) {
			// menuorgame = false;
			/*
			 * try { buttonsetup = AudioSystem.getAudioInputStream(new
			 * File("219472__jarredgibb__button-01.wav").getAbsoluteFile()); playbutton =
			 * AudioSystem.getClip(); // playbutton.open(buttonsetup); playbutton.start();
			 * 
			 * } catch (UnsupportedAudioFileException e1) {
			 * JOptionPane.showInternalMessageDialog(null,
			 * "Failed to open unsupported audio file: " + e1.getMessage(), "Error",
			 * JOptionPane.ERROR_MESSAGE); } catch (IOException e1) {
			 * JOptionPane.showInternalMessageDialog(null, "Unable to open audio file:\n" +
			 * e1.getMessage(), "Internal Error", JOptionPane.ERROR_MESSAGE);
			 * 
			 * } catch (LineUnavailableException e1) {
			 * JOptionPane.showInternalMessageDialog(null,
			 * "Unable to play a part of music:\n" + e1.getMessage(),
			 * "Music Playback Error", JOptionPane.ERROR_MESSAGE); }
			 */
			// System.out.println("Playing directly from menu screen...");
			log.info("User clicked on play button in the main menu");

			panel.remove(welcome);
			panel.remove(playmenu);
			panel.remove(helpmenu);
			panel.remove(settingsmenu);
			panel.revalidate();
			panel.repaint();
			new Guide((byte) 100);

		} else if (e.getSource() == helpmenu) {
			log.info("User is in the help page");

			panel.remove(welcome);
			panel.remove(playmenu);
			panel.remove(helpmenu);
			panel.remove(settingsmenu);
			panel.revalidate();
			panel.repaint();
			new Guide("help");

		} else if (e.getSource() == settingsmenu) {
			log.info("User is in the settings page");

			panel.remove(welcome);
			panel.remove(playmenu);
			panel.remove(helpmenu);
			panel.remove(settingsmenu);
			panel.revalidate();
			panel.repaint();
			new Guide((long) (100));

		} else if (e.getSource() == gotoplay) {
			log.info("User clicked on play button in the help menu");

			panel.remove(helplabel);
			panel.remove(helptextarea);
			panel.remove(gotoplay);
			panel.remove(goback);
			panel.revalidate();
			panel.repaint();
			new Guide();

		} else if (e.getSource() == goback) {
			log.info("User requested to go back to main menu from the help screen");

			helpcounter++;
			panel.remove(helplabel);
			panel.remove(helptextarea);
			panel.remove(gotoplay);
			panel.remove(goback);
			panel.revalidate();
			panel.repaint();
			new Guide(true);

		} else if (e.getSource() == sendmessage) {
			// Create stages for execution of the code (and you can restart progress!
			// Starting stage == 0; counter++; at the end

			trading();

		} else if (e.getSource() == exitmenubar) {
			int exitornot = 0;
			exitornot = JOptionPane.showConfirmDialog(null, "Are you sure?");
			if (exitornot == 0) {
				log.info("User requested to exit from this program");
				System.exit(0);
			}

		} else if (e.getSource() == aboutmenubar) {
			log.info("User clicked on " + '"' + "about" + '"' + " in the menubar");

			JOptionPane.showMessageDialog(null,
					"About\nI am a noob who writes simple Java programs...\n© 2020 suncloudsmoon", "About",
					JOptionPane.INFORMATION_MESSAGE);

		} else if (e.getSource() == gobackmenubar) {
			log.info("User requested to go back to the menu screen from menubar");

			menubar.remove(game);
			panel.remove(textarea);
			panel.remove(scrollpane);
			panel.remove(textfield);
			panel.remove(sendmessage);
			panel.revalidate();
			panel.repaint();
			helpcounter++;
			new Guide(true);

		} else if (e.getSource() == reportmenubar) {
			log.info("User is trying to report bugs or crashes from report option in the menu bar");

			String errorfeedback = JOptionPane.showInputDialog(null, "Feedback: ", "Report",
					JOptionPane.OK_CANCEL_OPTION);
			if (errorfeedback != null) {
				try {
					File feedbackinput = new File("C:\\Trader's Destiny\\File Storage\\bugsorcrashes.txt");
					FileWriter feedbackwriter = new FileWriter(feedbackinput, true);
					BufferedWriter writeit = new BufferedWriter(feedbackwriter);
					writeit.append("User Error Feedback: " + errorfeedback);
					writeit.newLine();
					writeit.close();
				} catch (IOException e1) {
					log.info("User encountered an IOException for bugorcrashes.txt file: " + e1.getMessage());
					JOptionPane.showInternalMessageDialog(null,
							"Unable to save error feedback log:\n" + e1.getMessage(), "Internal Error",
							JOptionPane.ERROR_MESSAGE);
				}
				JOptionPane.showInternalMessageDialog(null,
						"Thank you for giving us your feedback!\nI hope you enjoy our program!", "Thank You",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} else if (e.getSource() == saveconversationmenu) {
			log.info("User requested to save conversation file");

			file = new JFileChooser();
			file.setFileFilter(new FileNameExtensionFilter("Text Files Only", "txt"));
			file.showDialog(null, "Save Conversation");
			file.setEnabled(true);
			panel.add(file);
			if (file.APPROVE_OPTION == 0) {
				panel.remove(file);
			}

			if (file.CANCEL_OPTION == 1) {
				panel.remove(file);
			}

		} else if (e.getSource() == loginbutton) {
			log.info("User clicked on the login button");

			logincheck();

		} else if (e.getSource() == createnewuser) {
			log.info("User requested to create a new account");
			panel.remove(loginlabel);
			panel.remove(usernamelabel);
			panel.remove(combinationbox);
			panel.remove(loginbutton);
			panel.remove(or);
			panel.remove(createnewuser);
			panel.remove(continueasguest);
			panel.revalidate();
			panel.repaint();
			new Guide((short) (100));
		} else if (e.getSource() == createaccount) {

			// Adding user to text file

			// Initializing the reader...
			FileReader readfirstfornull = null;
			BufferedReader readtocheck = null;

			// Initializing the writer...
			FileWriter createuser = null;
			BufferedWriter createuser1 = null;
			try {
				// Writing the file first
				File adduser = new File("C:\\Trader's Destiny\\File Storage\\usernames.txt");
				createuser = new FileWriter(adduser, true);
				createuser1 = new BufferedWriter(createuser);

				// Reading the file second
				readfirstfornull = new FileReader(adduser);
				readtocheck = new BufferedReader(readfirstfornull);
				if (usernamecreateauserfield.getText().contains("-")) {
					throw new IllegalArgumentException("It is illegal for a dash to be in the username!");
				}
				if (usernamecreateauserfield.getText().isEmpty()) {
					throw new NullPointerException("Username field is empty!");
				}

				// Checking if the username already exists
				String readline;
				while ((readline = readtocheck.readLine()) != null) {
					String[] usernamessplit = readline.split("-");
					// System.out.println("Removed -: " + usernamessplit[0]);
					String[] usernamessplitcheck = usernamessplit[0].split("=");
					// System.out.println("= remover and check: " + usernamessplitcheck[1]);
					if (usernamessplitcheck[1].contentEquals(usernamecreateauserfield.getText())) {
						// System.out.println("MATCHED USERNAMES!");
						throw new IllegalAccessError(
								"Username from textfield is already present in the username database!");

					}

				}

				// Reading the difficulty option selected by the user!
				String selecteddifficulty = null;
				if (noobradiobutton.isSelected()) {
					selecteddifficulty = "noob";
				} else if (entrepreneurradiobutton.isSelected()) {
					selecteddifficulty = "entrepreneur";
				} else if (businesstycoonradiobutton.isSelected()) {
					selecteddifficulty = "businesstycoon";
				}

				// Smashing all the user input info into the text file!
				createuser1
						.append("username=" + usernamecreateauserfield.getText() + "-difficulty=" + selecteddifficulty);
				createuser1.newLine();

				log.info("User successfully created a new account");
				panel.remove(createnewuserlabel);
				panel.remove(usernamecreatenewuserlabel);
				panel.remove(usernamecreateauserfield);
				panel.remove(difficultynewuser);
				panel.remove(noobradiobutton);
				panel.remove(entrepreneurradiobutton);
				panel.remove(businesstycoonradiobutton);
				panel.remove(createaccount);
				panel.revalidate();
				panel.repaint();
				new Guide('a');

			} catch (IOException e1) {
				log.info("User encountered an IOException error while creating a new account: " + e1.getMessage());
				JOptionPane.showInternalMessageDialog(null,
						"Unable to access text file to create new account:\n" + e1.getMessage(), "Internal Error",
						JOptionPane.ERROR_MESSAGE);

			} catch (IllegalArgumentException e1) {
				log.info("User encountered IllegalArgumentException by typing " + '"' + "-" + '"'
						+ " while trying to create new user account: " + e1.getMessage());
				JOptionPane.showInternalMessageDialog(null, "Username cannot contain " + '"' + "-" + '"' + "!",
						"Username Error", JOptionPane.WARNING_MESSAGE);

			} catch (IllegalAccessError e1) {
				log.info("User unsuccessfully tried to enter a username that already exists: " + e1.getMessage());
				JOptionPane.showInternalMessageDialog(null, "Sorry, that username already exists!", "Username Error",
						JOptionPane.WARNING_MESSAGE);

			} catch (NullPointerException e1) {
				log.info("User tried to create a username with null value: " + e1.getMessage());
				JOptionPane.showInternalMessageDialog(null, "Username cannot be blank!", "Username Error",
						JOptionPane.WARNING_MESSAGE);

			} finally {
				try {
					readtocheck.close();
					createuser1.close();

				} catch (IOException e1) {
					JOptionPane.showInternalMessageDialog(null, "Unable to close text file:\n" + e1.getMessage(),
							"Internal Error", JOptionPane.ERROR_MESSAGE);
				}
			}

		} else if (e.getSource() == continueasguest) {
			panel.remove(loginlabel);
			panel.remove(usernamelabel);
			panel.remove(combinationbox);
			panel.remove(loginbutton);
			panel.remove(or);
			panel.remove(createnewuser);
			panel.remove(continueasguest);
			panel.revalidate();
			panel.repaint();
			new Guide('a');

		} else if (e.getSource() == playgame) {
			if (!scenariolisted.isSelectionEmpty()) {
				log.info("User requested to play " + '"' + scenarioinhere.get(scenariolisted.getSelectedIndex()) + '"'
						+ " scenario");

				panel.remove(edit);
				panel.remove(createnew);
				panel.remove(playgame);
				panel.remove(scrollit);
				panel.revalidate();
				panel.repaint();
				new Guide();
			}

		} else if (e.getSource() == createnew) {
			log.info("User request to create a new scenario");
			panel.remove(edit);
			panel.remove(createnew);
			panel.remove(playgame);
			panel.remove(scrollit);
			panel.revalidate();
			panel.repaint();
			new Guide((double) 1.11);

		} else if (e.getSource() == edit) {

		} else if (e.getSource() == settingsgoback) {
			log.info("User requested to go back from the settings page");
			// Also, save the changes in settings!

			helpcounter++;
			panel.remove(nicknamechange);
			panel.remove(nicknamesuggest);
			panel.remove(difficultynewuser);
			panel.remove(noobradiobutton);
			panel.remove(entrepreneurradiobutton);
			panel.remove(businesstycoonradiobutton);
			panel.remove(businesstycoonradiobutton);
			panel.remove(settingsgoback);
			panel.revalidate();
			panel.repaint();
			new Guide(true);
		} else if (e.getSource() == checkforupdatesmenu) {
			JOptionPane.showMessageDialog(null, "Your program is up-to date!", "Update Status",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

}
