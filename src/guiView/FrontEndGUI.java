package guiView;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import managerController.FrontEndController;
import model.RegisteredUser;
import model.Seat;
import model.Ticket;

import javax.swing.*;

public class FrontEndGUI {

	private JFrame frame;
	private JPanel welcomePane, registerPane, guestMenuPane, guestCancelPane, guestPaymentPane;
	private JButton GuestButton, RegUserButton, RegisterButton;
	private WelcomeListener welcomeListener;
	private JTextField rgName, rgAddress, rgEmail, rgCreditCard; 
	private JButton rgRegisterButton;
	private JButton getMovieTicketButton, cancelMovieTicketButton;
	private JPanel fixedPanel;

	private DefaultListModel<String> offeringMovieModel, offeringTimeModel, userTicketsModel;
	private JList <String> offeringMovieDisplayList, offeringTimeDisplayList, userTicketsDisplayList;
	private JScrollPane scrollMovies, scrollTimes, scrollTickets;
	private JButton movieSelectButton;

	private GuestMenuListener gmuListener;
	private GuestCancelListener gcListener;
	private JTextField gcTicketField;
	private JButton gcCancelButton, gcCancelReturnButton;

	
	private JTextField gpName, gpAddress, gpCard, gpEmail, gpVoucher;
	private JButton gpConfirmButton;

	private JPanel ruLoginPane, ruMenuPane, ruCancelTicketPane, ruPaymentPane, ruDisplayNewsPane, ruPayAnnualPane;
	private JButton ruLoginButton;
	private JTextField ruLoginField;
	private RegularLoginListener ruLoginListener;

	private JButton payUserFeeButton, getNewsButton, bookTicketButton, cancelTicketButton;
	private RegisteredMenuListener rmListener;

	private JButton ufPaymentConfirmButton;
	private UserFeePaymentListener upListener;
	private JTextField userInfoPayment;

	private JTextField newsDisplayField;
	private JButton okNewsButton;
	private DisplayNewsListener dnListener;


	private JPanel movieselectPane, movieTimePane, seatSelectPane, seatGridPane;
	private TimeSelectListener tsListener;
	private MovieSelectListener msListener;
	private SeatSelectListener ssListener;
	private JButton timeSelectButton, seatSelectButton;
	private ButtonGroup seatButtonGroup;

	private JButton userPayCC, userPayVoucher;

	private JButton ruCancelTicketButton, ruStopCancelTicketButton;

	private JButton regHomeButton, guestHomeButton, rgHomeButton, loginHomeButton, ruPaymentHomeButton, ruFeePaymentHomeButton;

	private String movieString;
	private int timeIndex, seatIndex;
	private LocalDateTime movieTime;
	private ArrayList<Seat> seatList;

	/**
	 * The current user.
	 */
	private RegisteredUser user;
	/**
	 * Front end controller for the class.
	 */
	private FrontEndController fec;

	FrontEndGUI () {

		fec = new FrontEndController();
		frame = new JFrame();
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.setTitle("Movie Reservation App");
		frame.setSize(700,550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		fixedPanel = new JPanel(new GridBagLayout());
		fixedPanel.setPreferredSize(frame.getSize());

		createWelcomePanel();

		fixedPanel.add(welcomePane);
		frame.add(fixedPanel, BorderLayout.CENTER);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private void createWelcomePanel() {
		welcomePane = new JPanel();
		welcomePane.setLayout(new BoxLayout(welcomePane, BoxLayout.Y_AXIS));
		GuestButton = new JButton("Guest");
		RegUserButton = new JButton("Registered User");
		RegisterButton = new JButton("Register");

		welcomeListener = new WelcomeListener();
		GuestButton.addActionListener(welcomeListener);
		RegUserButton.addActionListener(welcomeListener);
		RegisterButton.addActionListener(welcomeListener);



		welcomePane.add(GuestButton);
		welcomePane.add(Box.createRigidArea(new Dimension(0,20)));

		welcomePane.add(RegUserButton);
		welcomePane.add(Box.createRigidArea(new Dimension(0,20)));

		welcomePane.add(RegisterButton);
		welcomePane.add(Box.createRigidArea(new Dimension(0,20)));

	}


	private void createRegisterPanel() {
		registerPane = new JPanel();
		registerPane.setLayout(new BoxLayout(registerPane, BoxLayout.Y_AXIS));

		JLabel enterInfo = new JLabel ("Enter info:");
		registerPane.add(enterInfo, SwingConstants.CENTER);


		JLabel rgNameLabel = new JLabel ("Name: ");
		JPanel rgPanel1 = new JPanel();
		rgName = new JTextField(25);
		rgPanel1.add(rgNameLabel);
		rgPanel1.add(rgName);
		registerPane.add(rgPanel1);

		JLabel rgAddressLabel = new JLabel ("Address: ");
		JPanel rgPanel2 = new JPanel();
		rgAddress = new JTextField(25);
		rgPanel2.add(rgAddressLabel);
		rgPanel2.add(rgAddress);
		registerPane.add(rgPanel2);

		JLabel rgEmailLabel = new JLabel ("Email: ");
		JPanel rgPanel3 = new JPanel();
		rgEmail = new JTextField(25);
		rgPanel3.add(rgEmailLabel);
		rgPanel3.add(rgEmail);
		registerPane.add(rgPanel3);

		JLabel rgCCLabel = new JLabel ("Credit Card: ");
		JPanel rgPanel4 = new JPanel();
		rgCreditCard = new JTextField(25);
		rgPanel4.add(rgCCLabel);
		rgPanel4.add(rgCreditCard);
		registerPane.add(rgPanel4);

		rgRegisterButton = new JButton ("Register");
		registerPane.add(Box.createRigidArea(new Dimension(0,20)));
		registerPane.add(rgRegisterButton);
		rgRegisterButton.addActionListener(new RegisterNewUserListener());
		
		rgHomeButton = new JButton ("Return to Menu");
		registerPane.add(Box.createRigidArea(new Dimension(0,20)));
		registerPane.add(rgHomeButton);
		rgHomeButton.addActionListener(new RegisterNewUserListener());
	}

	private void createGuestMenu() {
		guestMenuPane = new JPanel();
		guestMenuPane.setLayout(new BoxLayout(guestMenuPane, BoxLayout.Y_AXIS));

		JLabel selectInfo = new JLabel ("Select an option:");
		guestMenuPane.add(selectInfo, SwingConstants.CENTER);
		guestMenuPane.add(Box.createRigidArea(new Dimension(0,20)));
		getMovieTicketButton = new JButton ("Get Movie Ticket");
		cancelMovieTicketButton = new JButton ("Cancel Movie Ticket");
		guestMenuPane.add(getMovieTicketButton);

		guestMenuPane.add(Box.createRigidArea(new Dimension(0,20)));
		guestMenuPane.add(cancelMovieTicketButton);

		gmuListener = new GuestMenuListener();
		getMovieTicketButton.addActionListener(gmuListener);
		cancelMovieTicketButton.addActionListener(gmuListener);



	}


	private void createGuestCancel() {
		guestCancelPane = new JPanel();
		guestCancelPane.setLayout(new BoxLayout(guestCancelPane, BoxLayout.Y_AXIS));

		gcListener = new GuestCancelListener();

		JLabel guestCancelLabel = new JLabel ("Enter Ticket #: ");
		JPanel gcPanel1 = new JPanel();
		gcTicketField = new JTextField(25);
		gcPanel1.add(guestCancelLabel);
		gcPanel1.add(gcTicketField);
		guestCancelPane.add(gcPanel1);
		guestCancelPane.add(Box.createRigidArea(new Dimension(0,20)));
		
		gcCancelButton = new JButton("Cancel Ticket");
		gcCancelButton.addActionListener(gcListener);
		guestCancelPane.add(gcCancelButton);
		guestCancelPane.add(Box.createRigidArea(new Dimension(0,20)));
		
		gcCancelReturnButton = new JButton("Return to Menu");
		gcCancelReturnButton.addActionListener(gcListener);
		guestCancelPane.add(gcCancelReturnButton);

	}


	private void createGuestPaymentGUI() {

		guestPaymentPane = new JPanel();
		guestPaymentPane.setLayout(new BoxLayout(guestPaymentPane, BoxLayout.Y_AXIS));

		JLabel enterInfo = new JLabel ("Enter info:");
		guestPaymentPane.add(enterInfo, SwingConstants.CENTER);


		JLabel rgNameLabel = new JLabel ("Name: ");
		JPanel rgPanel1 = new JPanel();
		gpName = new JTextField(25);
		rgPanel1.add(rgNameLabel);
		rgPanel1.add(gpName);
		guestPaymentPane.add(rgPanel1);

		JLabel rgAddressLabel = new JLabel ("Address: ");
		JPanel rgPanel2 = new JPanel();
		gpAddress = new JTextField(25);
		rgPanel2.add(rgAddressLabel);
		rgPanel2.add(gpAddress);
		guestPaymentPane.add(rgPanel2);

		JLabel rgEmailLabel = new JLabel ("Email: ");
		JPanel rgPanel3 = new JPanel();
		gpEmail = new JTextField(25);
		rgPanel3.add(rgEmailLabel);
		rgPanel3.add(gpEmail);
		guestPaymentPane.add(rgPanel3);

		JLabel rgCCLabel = new JLabel ("Credit Card: ");
		JPanel rgPanel4 = new JPanel();
		gpCard = new JTextField(25);
		rgPanel4.add(rgCCLabel);
		rgPanel4.add(gpCard);
		guestPaymentPane.add(rgPanel4);

		JLabel rgVoucherLabel = new JLabel ("Voucher Number: ");
		JPanel rgPanel5 = new JPanel();
		gpVoucher = new JTextField(25);
		rgPanel5.add(rgVoucherLabel);
		rgPanel5.add(gpVoucher);
		guestPaymentPane.add(rgPanel5);

		gpConfirmButton = new JButton ("Purchase Ticket");
		gpConfirmButton.addActionListener(new GuestPaymentListener());
		guestPaymentPane.add(Box.createRigidArea(new Dimension(0,20)));
		guestPaymentPane.add(gpConfirmButton);
		
		guestPaymentPane.add(Box.createRigidArea(new Dimension(0,20)));
		guestHomeButton = new JButton ("Return to Menu");
		guestHomeButton.addActionListener(new GuestPaymentListener());
		guestPaymentPane.add(guestHomeButton);

	}

	private void createRegUserLogin() {
		ruLoginPane = new JPanel();
		ruLoginPane.setLayout(new BoxLayout(ruLoginPane, BoxLayout.Y_AXIS));

		ruLoginListener = new RegularLoginListener();

		JLabel guestCancelLabel = new JLabel ("Enter Your Email: ");
		JPanel gcPanel1 = new JPanel();
		ruLoginField = new JTextField(25);
		gcPanel1.add(guestCancelLabel);
		gcPanel1.add(ruLoginField);
		ruLoginPane.add(gcPanel1);
		ruLoginPane.add(Box.createRigidArea(new Dimension(0,20)));
		ruLoginButton = new JButton("Login");
		ruLoginButton.addActionListener(ruLoginListener);
		ruLoginPane.add(ruLoginButton);
		
		ruLoginPane.add(Box.createRigidArea(new Dimension(0,20)));
		loginHomeButton = new JButton("Home");
		loginHomeButton.addActionListener(ruLoginListener);
		ruLoginPane.add(loginHomeButton);
	}

	private void createRegUserMenu() {
		ruMenuPane = new JPanel();
		ruMenuPane.setLayout(new BoxLayout(ruMenuPane, BoxLayout.X_AXIS));


		JPanel rgPanel1 = new JPanel();
		payUserFeeButton = new JButton("Pay Annual User Fee");
		rgPanel1.add(payUserFeeButton);
		ruMenuPane.add(rgPanel1);

		JPanel rgPanel2 = new JPanel();
		getNewsButton = new JButton("Get Movie News");
		rgPanel1.add(getNewsButton);
		ruMenuPane.add(rgPanel2);

		JPanel rgPanel3 = new JPanel();
		bookTicketButton = new JButton("Book a Ticket");
		rgPanel1.add(bookTicketButton);
		ruMenuPane.add(rgPanel3);
		

		JPanel rgPanel4 = new JPanel();
		cancelTicketButton = new JButton("Cancel a Ticket");
		rgPanel1.add(cancelTicketButton);
		ruMenuPane.add(rgPanel4);
		
		regHomeButton = new JButton("Home");
		ruMenuPane.add(regHomeButton);
		
		if(user.isAnnualPayment()) {
			bookTicketButton.setEnabled(true);
			cancelTicketButton.setEnabled(true);
			
		} else {
			bookTicketButton.setEnabled(false);
			cancelTicketButton.setEnabled(false);
		}
		
		rmListener = new RegisteredMenuListener();

		payUserFeeButton.addActionListener(rmListener);
		getNewsButton.addActionListener(rmListener);
		bookTicketButton.addActionListener(rmListener);
		cancelTicketButton.addActionListener(rmListener);
		regHomeButton.addActionListener(rmListener);
	}

	private void createUserCancelTicketMenu() {
		ruCancelTicketPane = new JPanel();
		ruCancelTicketPane.setLayout(new BoxLayout(ruCancelTicketPane, BoxLayout.Y_AXIS));

		userTicketsModel = new DefaultListModel<String>();
		userTicketsDisplayList = new JList<String>(userTicketsModel);
		userTicketsDisplayList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		userTicketsDisplayList.setVisibleRowCount(10);
		userTicketsDisplayList.setFixedCellHeight(15);
		userTicketsDisplayList.setFixedCellWidth(200);

		scrollTickets = new JScrollPane(userTicketsDisplayList);
		scrollTickets.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollTickets.setMinimumSize(new Dimension(200,500));

		JLabel selectInfo = new JLabel ("Select ticket to cancel:");

		ruCancelTicketPane.add(selectInfo, SwingConstants.CENTER);
		ruCancelTicketPane.add(Box.createRigidArea(new Dimension(0,40)));
		ruCancelTicketPane.add(scrollTickets);
		ruCancelTicketPane.add(Box.createRigidArea(new Dimension(0,40)));

		ruCancelTicketButton = new JButton("Cancel Ticket");
		ruCancelTicketButton.addActionListener(new UserCancelListener());
		ruCancelTicketPane.add(ruCancelTicketButton);

		ruStopCancelTicketButton = new JButton("Stop Cancellation");
		ruStopCancelTicketButton.addActionListener(new UserCancelListener());
		ruCancelTicketPane.add(ruStopCancelTicketButton);

	}

	private void createBookTicketMenu() {
		movieselectPane = new JPanel();
		movieselectPane.setLayout(new BoxLayout(movieselectPane, BoxLayout.Y_AXIS));
		msListener = new MovieSelectListener();

		offeringMovieModel = new DefaultListModel<String>();
		offeringMovieDisplayList = new JList<String>(offeringMovieModel);
		offeringMovieDisplayList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		offeringMovieDisplayList.setVisibleRowCount(10);
		offeringMovieDisplayList.setFixedCellHeight(15);
		offeringMovieDisplayList.setFixedCellWidth(100);

		scrollMovies = new JScrollPane (offeringMovieDisplayList);
		scrollMovies.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		JLabel selectInfo = new JLabel ("Select a movie:");
		movieselectPane.add(selectInfo, SwingConstants.CENTER);
		movieselectPane.add(Box.createRigidArea(new Dimension(0,20)));
		movieselectPane.add(scrollMovies);
		movieselectPane.add(Box.createRigidArea(new Dimension(0,20)));

		movieSelectButton = new JButton("Select");
		movieSelectButton.addActionListener(msListener);
		movieselectPane.add(movieSelectButton);
		


	}

	private void createUserPickTimeMenu() {
		movieTimePane = new JPanel();
		movieTimePane.setLayout(new BoxLayout(movieTimePane, BoxLayout.Y_AXIS));
		tsListener = new TimeSelectListener();

		offeringTimeModel = new DefaultListModel<String>();
		offeringTimeDisplayList = new JList<String>(offeringTimeModel);
		offeringTimeDisplayList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		offeringTimeDisplayList.setVisibleRowCount(10);
		offeringTimeDisplayList.setFixedCellHeight(15);
		offeringTimeDisplayList.setFixedCellWidth(100);

		JLabel selectInfo = new JLabel ("Select a Time:");
		movieTimePane.add(selectInfo, SwingConstants.CENTER);
		scrollTimes = new JScrollPane(offeringTimeDisplayList);
		scrollTimes.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		movieTimePane.add(Box.createRigidArea(new Dimension(0,20)));
		movieTimePane.add(scrollTimes);
		movieTimePane.add(Box.createRigidArea(new Dimension(0,20)));

		timeSelectButton = new JButton("Select");
		timeSelectButton.addActionListener(tsListener);
		movieTimePane.add(timeSelectButton);



	}

	private void createSeatSelector() {
		seatSelectPane = new JPanel();
		seatSelectPane.setLayout(new BoxLayout(seatSelectPane, BoxLayout.Y_AXIS));
		ssListener = new SeatSelectListener();
		
		seatGridPane = new JPanel();
		seatGridPane.setLayout(new GridLayout(2,5));
		JLabel selectInfo = new JLabel ("Select a Seat:");
		selectInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
		seatSelectPane.add(selectInfo);
		seatSelectPane.add(Box.createRigidArea(new Dimension(0,20)));
		seatButtonGroup = new ButtonGroup();
		seatSelectPane.add(seatGridPane);
		seatSelectPane.add(Box.createRigidArea(new Dimension(0,20)));
		seatSelectButton = new JButton("Select");
		seatSelectButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		seatSelectButton.addActionListener(ssListener);
		seatSelectPane.add(seatSelectButton);
	}

	private void createRUPaymentGUI() {

		ruPaymentPane = new JPanel();
		ruPaymentPane.setLayout(new BoxLayout(ruPaymentPane, BoxLayout.Y_AXIS));

		JLabel payPrompt = new JLabel ("Payment Information");
		JLabel userName = new JLabel ("Name: " + user.getName());
		JLabel userAddress = new JLabel ("Address: " + user.getAddress());
		JLabel userCC = new JLabel ("Credit Card: " + user.getCreditCardNumber());
		JLabel userEmail = new JLabel ("Email: " + user.getEmail());

		ruPaymentPane.add(payPrompt);
		ruPaymentPane.add(userName);
		ruPaymentPane.add(userAddress);
		ruPaymentPane.add(userCC);
		ruPaymentPane.add(userEmail);

		JLabel moviePrompt = new JLabel ("Movie Information");
		JLabel movie = new JLabel ("Movie: " + movieString);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		JLabel time = new JLabel ("Date & Time: " + movieTime.format(formatter));
		JLabel seat = new JLabel ("Seat #" + seatIndex);

		ruPaymentPane.add(moviePrompt);
		ruPaymentPane.add(movie);
		ruPaymentPane.add(time);
		ruPaymentPane.add(seat);

		int voucherNum = user.getRefundList().size();
		JLabel voucherPrompt = new JLabel ("User has " + voucherNum + " vouchers available. Select method of payment:");

		userPayCC = new JButton("Credit Card");
		userPayCC.addActionListener(new UserTicketPaymentListener());
		userPayVoucher = new JButton("Voucher");
		userPayVoucher.addActionListener(new UserTicketPaymentListener());
		ruPaymentHomeButton = new JButton("Return to Menu");
		ruPaymentHomeButton.addActionListener(new UserTicketPaymentListener());

		ruPaymentPane.add(voucherPrompt);
		ruPaymentPane.add(Box.createRigidArea(new Dimension(0,20)));
		ruPaymentPane.add(userPayCC);
		ruPaymentPane.add(Box.createRigidArea(new Dimension(0,20)));
		ruPaymentPane.add(userPayVoucher);
		ruPaymentPane.add(Box.createRigidArea(new Dimension(0,20)));
		ruPaymentPane.add(ruPaymentHomeButton);

	}

	private void createNewsDisplay() {
		ruDisplayNewsPane = new JPanel();
		ruDisplayNewsPane.setLayout(new BoxLayout(ruDisplayNewsPane, BoxLayout.Y_AXIS));

		okNewsButton = new JButton("OK");
		dnListener = new DisplayNewsListener();
		okNewsButton.addActionListener(dnListener);

		//		newsBackButton = new JButton ("Back");
		//		newsBackButton.addActionListener(dnListener);
		JPanel newsSelectPanel = new JPanel();
		newsSelectPanel.add(okNewsButton);
		//		newsSelectPanel.add(newsBackButton);

		ruDisplayNewsPane.add(newsSelectPanel, SwingConstants.CENTER);

		ruDisplayNewsPane.add(Box.createRigidArea(new Dimension(0,35)));

		newsDisplayField = new JTextField();
		//some kind of get the user  news then toString method
		newsDisplayField.setText(fec.getNews().getNews());
		ruDisplayNewsPane.add(newsDisplayField, SwingConstants.CENTER);
		ruDisplayNewsPane.add(Box.createRigidArea(new Dimension(0,20)));

		ruDisplayNewsPane.add(Box.createRigidArea(new Dimension(0,20)));
		JLabel price = new JLabel ("The movies available for early release viewing:");
		ruDisplayNewsPane.add(price, SwingConstants.CENTER);
	}

	private void createUserAnnualPaymentMenu() {

		ruPayAnnualPane = new JPanel();
		ruPayAnnualPane.setLayout(new BoxLayout(ruPayAnnualPane, BoxLayout.Y_AXIS));

		ruFeePaymentHomeButton = new JButton("Return to Menu");
		ruPayAnnualPane.add(ruFeePaymentHomeButton, SwingConstants.CENTER);
		ruPayAnnualPane.add(Box.createRigidArea(new Dimension(0,20)), SwingConstants.CENTER);
		ufPaymentConfirmButton = new JButton("Confirm");
		ruPayAnnualPane.add(ufPaymentConfirmButton, SwingConstants.CENTER);
		ruPayAnnualPane.add(Box.createRigidArea(new Dimension(0,20)), SwingConstants.CENTER);


		userInfoPayment = new JTextField();

		ruPayAnnualPane.add(userInfoPayment, SwingConstants.CENTER);
		ruPayAnnualPane.add(Box.createRigidArea(new Dimension(0,20)), SwingConstants.CENTER);

		upListener = new UserFeePaymentListener();
		ufPaymentConfirmButton.addActionListener(upListener);
		ruFeePaymentHomeButton.addActionListener(upListener);
		ruPayAnnualPane.add(Box.createRigidArea(new Dimension(0,20)), SwingConstants.CENTER);
		JLabel price = new JLabel ("Please pay your $20.00 annual fee.");
		ruPayAnnualPane.add(price, SwingConstants.CENTER);
		
		
	

	}

	class WelcomeListener implements ActionListener
	{


		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == GuestButton) {
				createGuestMenu();
				fixedPanel.removeAll();
				fixedPanel.add(guestMenuPane);
				fixedPanel.updateUI();

			} else if (e.getSource() == RegUserButton) {
				createRegUserLogin();
				fixedPanel.removeAll();
				fixedPanel.add(ruLoginPane);
				fixedPanel.updateUI();

			} else if (e.getSource() == RegisterButton) {
				createRegisterPanel();
				fixedPanel.removeAll();
				fixedPanel.add(registerPane);
				fixedPanel.updateUI();
			}
		}
	}

	class RegisterNewUserListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == rgRegisterButton) {

				try {
					String name = rgName.getText();
					String address = rgAddress.getText();
					String ccNum = rgCreditCard.getText();
					String email = rgEmail.getText();

					if (!name.isEmpty() && !address.isEmpty() && !ccNum.isEmpty() && !email.isEmpty()) {

						fec.getRegister().createUser(name, address, ccNum, email);
						fixedPanel.removeAll();
						fixedPanel.add(welcomePane);
						fixedPanel.updateUI();

						JOptionPane pane = new JOptionPane();
						String message = "New member " + name + " added!";
						JOptionPane.showMessageDialog(pane, message);

					} else {
						JOptionPane pane = new JOptionPane();
						String message = "Please ensure all text fields are filled.";
						JOptionPane.showMessageDialog(pane, message);
					}

				} catch (Exception ex) {
					JOptionPane pane = new JOptionPane();
					String message = "Something went wrong, please try again.";
					JOptionPane.showMessageDialog(pane, message);

				}


			} else if(e.getSource() == rgHomeButton) {
				fixedPanel.removeAll();
				fixedPanel.add(welcomePane);
				fixedPanel.updateUI();
			}
		}
	}

	class GuestMenuListener implements ActionListener
	{


		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == getMovieTicketButton) {
				createBookTicketMenu();
				
				boolean userStatus = (user != null);

				ArrayList<String> movies = fec.getOffer().getMovieList(userStatus);

				offeringMovieModel.clear();

				for (String cursor : movies ) {
					offeringMovieModel.addElement(cursor);
				}
				
				fixedPanel.removeAll();
				fixedPanel.add(movieselectPane);
				fixedPanel.updateUI();

			} else if (e.getSource() == cancelMovieTicketButton) {
				createGuestCancel();
				fixedPanel.removeAll();
				fixedPanel.add(guestCancelPane);
				fixedPanel.updateUI();
			}
		}
	}


	class GuestCancelListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == gcCancelButton) {

				String id = gcTicketField.getText();
				
				String cancel = "Ticket not found, please try again.";
				
				
				for(Ticket t:fec.getCancel().getTrs().getTickets()) {
					
					if (t.getTicketID().equals(id)) {
						Duration timeDiff = Duration.between(LocalDateTime.now(), t.getMovieOffering().getTime());
						double hours = timeDiff.toHours();
						
						if(hours<72){
							cancel = "It is too late to cancel this ticket.";
						} else {
							cancel = fec.getCancel().cancelTicktGuest(id);
							fixedPanel.removeAll();
							fixedPanel.add(welcomePane);
							fixedPanel.updateUI();
							break;
						}
						
					}
					
				}
						
				JOptionPane pane = new JOptionPane();
				JOptionPane.showMessageDialog(pane, cancel);

			} else if (e.getSource() == gcCancelReturnButton) {
				fixedPanel.removeAll();
				fixedPanel.add(welcomePane);
				fixedPanel.updateUI();
				
			} else {
				JOptionPane pane = new JOptionPane();
				String message = "Something went wrong";
				JOptionPane.showMessageDialog(pane, message);
			}
			
		}
	}

	class MovieSelectListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == movieSelectButton && offeringMovieDisplayList.isSelectionEmpty() == false) {

				createUserPickTimeMenu();
				movieString = offeringMovieDisplayList.getSelectedValue();

				fixedPanel.removeAll();
				fixedPanel.add(movieTimePane);

				boolean userStatus = (user != null);

				offeringTimeModel.clear();
				ArrayList<LocalDateTime> times =  fec.getOffer().getTimeList(movieString, userStatus);

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

				for (LocalDateTime cursor : times) {
					String timeString = cursor.format(formatter);
					offeringTimeModel.addElement(timeString);
				}

				fixedPanel.updateUI();

			} else {
				JOptionPane pane = new JOptionPane();
				String message = "Ensure input is correct.";
				JOptionPane.showMessageDialog(pane, message);
			}
		}
	}

	class TimeSelectListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == timeSelectButton && offeringTimeDisplayList.isSelectionEmpty() == false) {

				createSeatSelector();

				timeIndex = offeringTimeDisplayList.getSelectedIndex();

				movieTime = fec.getOffer().getTimeList(movieString, true).get(timeIndex);

				seatList = fec.getOffer().getSeatList(movieString, movieTime);

				
				for(Seat s:seatList) {
					JToggleButton seatButton = new JToggleButton("#" + s.getSeatNo());
					seatButton.setActionCommand("" + s.getSeatNo());
					seatButton.setEnabled(!s.isTaken());
					seatGridPane.add(seatButton);
					seatButtonGroup.add(seatButton);
				}

				fixedPanel.removeAll();
				fixedPanel.add(seatSelectPane);
				fixedPanel.updateUI();

			} else {
				JOptionPane pane = new JOptionPane();
				String message = "Ensure input is correct.";
				JOptionPane.showMessageDialog(pane, message);
			}
		}
	}

	class SeatSelectListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == seatSelectButton && seatButtonGroup.getSelection() != null) {

				seatIndex = Integer.parseInt(seatButtonGroup.getSelection().getActionCommand());
				fixedPanel.removeAll();

				if (user == null) {
					createGuestPaymentGUI();
					fixedPanel.add(guestPaymentPane);
				} else {
					createRUPaymentGUI();
					fixedPanel.add(ruPaymentPane);
				}

				fixedPanel.updateUI();
			} else {
				JOptionPane pane = new JOptionPane();
				String message = "Ensure input is correct.";
				JOptionPane.showMessageDialog(pane, message);
			}
		}
	}

	class UserTicketPaymentListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == userPayCC) {

				String ticket = fec.getPayment().createRegisteredUserPayment(movieString, movieTime, seatIndex, 
						user.getCreditCardNumber(), user.getEmail());

				JOptionPane pane = new JOptionPane("Ticket Created");
				JOptionPane.showMessageDialog(pane, ticket);

				user = null;
				fixedPanel.removeAll();
				fixedPanel.add(welcomePane);
				fixedPanel.updateUI();

			} else if (e.getSource() == userPayVoucher) {

				String ticket = fec.getPayment().createRegisteredUserVoucherPayment(movieString, movieTime, seatIndex, user.getEmail());

				JOptionPane pane = new JOptionPane("Ticket Created");
				JOptionPane.showMessageDialog(pane, ticket);

				user = null;
				fixedPanel.removeAll();
				fixedPanel.add(welcomePane);
				fixedPanel.updateUI();
				
			} else if (e.getSource() == ruPaymentHomeButton) {
				
				fixedPanel.removeAll();
				fixedPanel.add(ruMenuPane);
				fixedPanel.updateUI();
				
			}
		}
	}

	class GuestPaymentListener implements ActionListener
	{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == gpConfirmButton) {

				try {
					String name = gpName.getText();
					String address = gpAddress.getText();
					String ccNum = gpCard.getText();
					String email = gpEmail.getText();
					
					

					if (!name.isEmpty() && !address.isEmpty() && !ccNum.isEmpty() && !email.isEmpty()) {
						
						String message;
						
						if(gpVoucher.getText().isEmpty()) {
							message = fec.getPayment().createRegisteredUserPayment(movieString, movieTime, seatIndex, ccNum, email);
							
							JOptionPane pane = new JOptionPane();
							JOptionPane.showMessageDialog(pane, message);
							
							fixedPanel.removeAll();
							fixedPanel.add(welcomePane);
							fixedPanel.updateUI();
							
						} else {
							int voucher = Integer.parseInt(gpVoucher.getText());
							message = fec.getPayment().createGuestVoucherPayment(movieString, movieTime, seatIndex, ccNum, email, voucher);
							
							if(!message.equals("Voucher not found, please try again")) {
								JOptionPane pane = new JOptionPane();
								JOptionPane.showMessageDialog(pane, message);
								fixedPanel.removeAll();
								fixedPanel.add(welcomePane);
								fixedPanel.updateUI();
								
							} else {
								JOptionPane pane = new JOptionPane();
								JOptionPane.showMessageDialog(pane, message);
							}
						
						}

					} else {
						JOptionPane pane = new JOptionPane();
						String message = "Please ensure all text fields are filled.";
						JOptionPane.showMessageDialog(pane, message);
					}

				} catch (Exception ex) {
					JOptionPane pane = new JOptionPane();
					String message = "Something went wrong, please try again.";
					JOptionPane.showMessageDialog(pane, message);

				}


			} else if (e.getSource() == guestHomeButton) {
				user = null;
				fixedPanel.removeAll();
				fixedPanel.add(welcomePane);
				fixedPanel.updateUI();
				
			}
		}
	}


	class RegularLoginListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == ruLoginButton) {
				
				String email = ruLoginField.getText().trim();
				user = fec.getLogin().login(email);
				
				

				if (user == null) {
					ruLoginField.setText("This user doesn't exist.");
				}
				else {
					createRegUserMenu();
					fixedPanel.removeAll();
					fixedPanel.add(ruMenuPane);
					fixedPanel.updateUI();
				


				}
			



			} else if (e.getSource() == loginHomeButton) {
				
				user=null;
				fixedPanel.removeAll();
				fixedPanel.add(welcomePane);
				fixedPanel.updateUI();
				
			}
		} 
	}

	class RegisteredMenuListener implements ActionListener
	{


		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == payUserFeeButton) {

				createUserAnnualPaymentMenu();

				if (user.isAnnualPayment() == false) {
					userInfoPayment.setText("Pay your annual user fee.");
				} else if (user.isAnnualPayment() == true) {
					userInfoPayment.setText("Annual payment already made. Please press Confirm to return to menu.");

				}
				fixedPanel.removeAll();
				fixedPanel.add(ruPayAnnualPane);
				fixedPanel.updateUI();

			} else if (e.getSource() == getNewsButton) {
				createNewsDisplay();
				fixedPanel.removeAll();
				fixedPanel.add(ruDisplayNewsPane);
				fixedPanel.updateUI();

			} else if (e.getSource() == bookTicketButton) {
				createBookTicketMenu();

				boolean userStatus = (user != null);

				ArrayList<String> movies = fec.getOffer().getMovieList(userStatus);

				offeringMovieModel.clear();

				for (String cursor : movies ) {
					offeringMovieModel.addElement(cursor);
				}

				fixedPanel.removeAll();
				fixedPanel.add(movieselectPane);
				fixedPanel.updateUI();

			} else if (e.getSource() == cancelTicketButton) {
				
				createUserCancelTicketMenu();
				
				userTicketsModel.clear();
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
				
				for(Ticket t:user.getTicketList()) {
					
					Duration timeDiff = Duration.between(LocalDateTime.now(), t.getMovieOffering().getTime());
					double hours = timeDiff.toHours();
					
					if(hours<72){
						continue;
					}
					
					String ticketString = t.getMovieOffering().getMovie() + "," + 
					t.getMovieOffering().getTime().format(formatter) + ", " + t.getTicketID();
					
					userTicketsModel.addElement(ticketString);
				} 
				
				
				fixedPanel.removeAll();
				fixedPanel.add(ruCancelTicketPane);
				fixedPanel.updateUI();
			} else if (e.getSource() == regHomeButton) {
				user = null;
				fixedPanel.removeAll();
				fixedPanel.add(welcomePane);
				fixedPanel.updateUI();
				
			}
		}
	}


	class UserFeePaymentListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == ufPaymentConfirmButton) {

				JOptionPane pane = new JOptionPane();
				String message = fec.getPayment().createYearlyPayment(user.getCreditCardNumber(), user.getEmail());
				JOptionPane.showMessageDialog(pane, message);
				
				user.setAnnualPayment(true);
				createRegUserMenu();
				fixedPanel.removeAll();
				fixedPanel.add(ruMenuPane);
				if(user.isAnnualPayment() == false) {
					user.setAnnualPayment(true);
				}


				fixedPanel.updateUI();



			} else if (e.getSource() == ruFeePaymentHomeButton) {
				
				fixedPanel.removeAll();
				fixedPanel.add(ruMenuPane);
				fixedPanel.updateUI();
				
			}
		}
	}

	class DisplayNewsListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == okNewsButton) {
				fixedPanel.removeAll();
				fixedPanel.add(ruMenuPane);
				fixedPanel.updateUI();
			
			}
		}
	}

	class UserCancelListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == ruStopCancelTicketButton) {
				fixedPanel.removeAll();
				fixedPanel.add(ruMenuPane);
				fixedPanel.updateUI();

			} else if (e.getSource() == ruCancelTicketButton) {
				
				int ticketIndex = userTicketsDisplayList.getSelectedIndex();
				
				Ticket ticket = user.getTicketList().get(ticketIndex);
				String cancellation = fec.getCancel().cancelTicketRU(ticket.getTicketID(), user.getEmail());
				
				JOptionPane pane = new JOptionPane("Ticket Cancelled");
				JOptionPane.showMessageDialog(pane, cancellation);

				user = null;
				fixedPanel.removeAll();
				fixedPanel.add(welcomePane);
				fixedPanel.updateUI();
				
			} else {
				JOptionPane pane = new JOptionPane();
				String message = "Ensure input is correct.";
				JOptionPane.showMessageDialog(pane, message);
			}
		}
	}

	public static void main (String [] args) {
		FrontEndGUI gui = new FrontEndGUI();
	}
}
