package managerController;
import model.TicketReservationSystem;

public class FrontEndController {
	
	private LoginRegisteredUser login;
	private RegisterNewUser register;
	private GetMovieNews news;
	private ManageCancellation cancel;
	private SelectOffering offer;
	private ManagePayment payment;
	
	public FrontEndController() {
		
		TicketReservationSystem trs = new TicketReservationSystem();
		
		setLogin(new LoginRegisteredUser(trs));
		setRegister(new RegisterNewUser(trs));
		setNews(new GetMovieNews(trs));
		setCancel(new ManageCancellation(trs));
		setOffer(new SelectOffering(trs));
		setPayment(new ManagePayment(trs));
		
		
		
	}

	public LoginRegisteredUser getLogin() {
		return login;
	}

	public void setLogin(LoginRegisteredUser login) {
		this.login = login;
	}

	public RegisterNewUser getRegister() {
		return register;
	}

	public void setRegister(RegisterNewUser register) {
		this.register = register;
	}

	public GetMovieNews getNews() {
		return news;
	}

	public void setNews(GetMovieNews news) {
		this.news = news;
	}

	public ManageCancellation getCancel() {
		return cancel;
	}

	public void setCancel(ManageCancellation cancel) {
		this.cancel = cancel;
	}

	public SelectOffering getOffer() {
		return offer;
	}

	public void setOffer(SelectOffering offer) {
		this.offer = offer;
	}

	public ManagePayment getPayment() {
		return payment;
	}

	public void setPayment(ManagePayment payment) {
		this.payment = payment;
	}
	
	

}
