package com.packt.movie.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.packt.movie.exception.NoMovieFoundException;
import com.packt.movie.model.ExistingUser;
import com.packt.movie.model.MovieCart;
import com.packt.movie.model.MovieList;
import com.packt.movie.model.NewUser;
import com.packt.movie.model.PurchaseInfo;
import com.packt.movie.model.TicketPrice;
import com.packt.movie.model.TimeInfo;
import com.packt.movie.service.MovieImplService;
import com.packt.movie.service.NewUserImplService;

@ContextConfiguration(locations = { "classpath:applicationContext.xml" })

// comment1

@Controller
@SessionAttributes("purchaseInfo")
public class MovieController {
	public MovieCart movieCart;
	MovieImplService movieImplService = new MovieImplService();
	@Autowired
	ServletContext servletContext;
	@Autowired
	ApplicationContext context;
	
	DataSource dataSource;
	private MultipartFile movieImage;

	MovieController(){
		movieCart = new MovieCart();
	}
	
/*	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }*/
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	// add movies to the Database only Admin can add.
	@RequestMapping(value = "/addMovie", method = RequestMethod.POST)
	public String addMovies(@ModelAttribute("addMovie") MovieList movie) {
		System.out.println("addMovie method POST ");
		System.out.println("movie name = "+movie.getMovieName());
		System.out.println("Movie Date="+movie.getMovieDate());
		System.out.println("Movie Duration="+movie.getMovieDuration());
		System.out.println("Movie FileName="+movie.getMovieImageFileName());
		
		return null;

	}

	/// MovieTime/movie
	@RequestMapping(value = "/movie", method = RequestMethod.GET)
	public String hello(Model model) {
		System.out.println("Movie method GET");
		MovieList movieList1 = new MovieList();
		model.addAttribute("movieList", movieList1);
		return "hellopage";
	}

	@RequestMapping(value = "/movie", method = RequestMethod.POST)
	public String helloWorld(@ModelAttribute("movieList") MovieList movieList,HttpServletRequest req, ModelMap map)  {
		System.out.println("Movie method POST");
		String movieDate = "";
		if(req.getSession().getAttribute("movieDate")!=null){
			movieDate = (String) req.getSession().getAttribute("movieDate");
		}
		else{
			movieDate = movieList.getMovieDate();
			req.getSession().setAttribute("movieDate",movieDate);
		}
		System.out.println("MovieList movieDate=" + movieDate);
		List<MovieList> listMovies = new ArrayList<MovieList>();
		List<MovieList> finalListMovies = new ArrayList<MovieList>();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		MovieImplService movieImplService = new MovieImplService();
	
		try {
			listMovies = movieImplService.getMovieList(movieDate);
	
		} catch (SQLException e) {
			map.addAttribute("NODATA", "No MOvie found for the selected date");
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "MovieList";
		}
	
		map.addAttribute("movieDATE", movieDate);
		map.addAttribute("MovieList", listMovies);
		// ((Model) modelAndView).addAttribute("MovieList", movieList1);
		return "MovieList";
	}

	@RequestMapping(value = "/movie", params = "purchase")
	public String Purchase(@ModelAttribute("movieList") MovieList movieList) {

		System.out.println("Purchase is called");
		return "purchased";

	}

	@RequestMapping(value = "/AddMovie", params = "AddMovie")
	public String addMovieLink(@ModelAttribute("movieList") MovieList movieList, BindingResult result,
			HttpServletRequest request) {
		System.out.println("AddMovie method ");
		MultipartFile movieImage = movieList.getMovieImage();
		System.out.println("movie image =" + movieImage);
		// String rootDirectory
		// =request.getSession().getServletContext().getRealPath("/");
		// System.out.println("rootDirectory="+rootDirectory);
		if (movieImage != null) { // Multipart
			String imageFileName = movieImage.getOriginalFilename();
			
			

			//String filePath = servletContext.getRealPath("WEB-INF/Images/");
			String filePath = request.getSession().getServletContext().getRealPath("WEB-INF/images");
			
			System.out.println("filePath=" + filePath);
			try {
				Writer writer = new FileWriter(filePath);
				writer.write(movieList.getMovieImageFileName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
			   File uploadingFileObj = new File(movieImage.getOriginalFilename());
			   movieImage.transferTo(uploadingFileObj);
			   
			   File destFile = new File(filePath,imageFileName);
			   
				FileUtils.copyFile( uploadingFileObj, destFile);
				destFile = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   
			   
			/*
			 * try{ movieImage.transferTo(new File(rootDirectory+
			 * "resources\\images\\"+movieList.getMovieName() + ".jpg"));
			 * }catch(Exception e){ e.printStackTrace(); }
			 */
		}
		System.out.println("Movie Date=" + movieList.movieDate);
		System.out.println("Movie duration" + movieList.movieDuration);
		System.out.println("AddMovie");
		return "AddMovies";
	}

	@ExceptionHandler(NoMovieFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, NoMovieFoundException exception) {
		System.out.println("NoMovieFoundException method ");
		ModelAndView mav = new ModelAndView();
		mav.addObject("invalidMovieId", exception.getMovieDate());
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL() + "?" + req.getQueryString());
		mav.setViewName("MovieNotFound");
		return mav;
	}

	
	@RequestMapping(value = "/NewUser1", params = "NewUser1", method = RequestMethod.GET)
	public String addNewUser(Model model) {	
		System.out.println("NewUser1 method GET");
		NewUser newUser = new NewUser();
		model.addAttribute("newUser", newUser);
		return "NewUser";		
	}

	@RequestMapping(value="/NewUser1",params="NewUser1",method=RequestMethod.POST)
	public String newUser(@ModelAttribute("newUser") @Valid NewUser newUser,BindingResult result,Model model){
		System.out.println("NewUser1 method POST");
		String page;
		NewUserImplService newUserImplService = new NewUserImplService();
		if(result.hasErrors()){
			System.out.println("New User ModeAttribute has error"+result.getFieldError());			
			return "NewUser";
		}
		//System.out.println("expiration month");
		page = newUserImplService.updateUserInfo(newUser);
		if(page.equals("NewUser")){
			model.addAttribute("existingUser","The Current user existing login");
			return "ExistingUser";
		}
		
		return page;
		
	}
	
	@RequestMapping(value = "/ExistingUser", method = RequestMethod.GET)
	public String getExistingUser(Model model) {
		System.out.println("ExistingUser method GET");
		NewUser existingUser = new NewUser();
		model.addAttribute("existingUser", existingUser);			
		model.addAttribute("message","The Current user existing login");
		return "ExistingUser";
		// return "index";
	}
	
	@RequestMapping(value="/ExistingUser",method=RequestMethod.POST)
	public String processExistingUser(@ModelAttribute("existingUser") @Valid NewUser User,BindingResult result,Model model){
		System.out.println("ExistingUser method POST");
		if(result.hasErrors()){
			System.out.println("New User ModeAttribute has error"+result.getFieldError());			
			return "ExistingUser";
		}
		NewUserImplService newUserImplService = new NewUserImplService();
		String result1 = newUserImplService.signInExistingUser( User);
		if(result1.equals("Success"))
			return "purchased";
		model.addAttribute("ExistingUser","The login or password is incorrect");
		return "ExistingUser";
	}
	
	/**
	 * parameter should contain the Movie information and the selected showtime
	 */
	
	/// MovieTime/movie
	 @RequestMapping(value ="/time/{movieID}",method = RequestMethod.GET) 	 //OLD working code
	//@RequestMapping(value = "/time", method = RequestMethod.GET)

	 public String getPriceInfo( @PathVariable("movieID")int movieID, Model
			 model ,HttpServletRequest request ,//OLD working code
	//public String getPriceInfo(@ModelAt("movieList") MovieList movieList, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		//??TODO check requestParam  how to read MovieDATE which send from movie. 12/6
		System.out.println("getPriceinfo for movieID=" + movieID + "GET method");
		// System.out.println("MovieName = "+movieName);
		PurchaseInfo purchaseInfo1 = new PurchaseInfo();
		request.setAttribute("clock", 30);
		MovieList movieList = new MovieList();
		movieList = movieImplService.getMovieListByMovieID(movieID);
		/*
		 * movieCart.setMovieID(movieID); movieCart.setTimeID(2);
		 */
		request.getSession().setAttribute("cart", movieCart);
		
		purchaseInfo1.setMovieID(movieList.getMovieID());
//		purchaseInfo1.setTimeID(movieList.getShow1());
		purchaseInfo1.setUserID((Integer)request.getSession().getAttribute("UserID"));
		// TODO need to get UserID,
		Cookie cookie = new Cookie("uid", request.getSession().getId()); // pass session id as second
													// arg read cookie if
													// expires will not get
													// cookie
		cookie.setMaxAge(2 * 60);
		response.addCookie(cookie);

//		Integer price = movieImplService.getTicketPrice(movieList.getMovieID(), movieList.getShow1());
//		purchaseInfo1.setTicketPrice(price);
		// model.addAttribute("NumberOfTickets",NumberOfTickets)
		model.addAttribute("purchaseInfo", purchaseInfo1);
		return "PurchaseInfo";
	}

		@RequestMapping(value="/purInfo",method = RequestMethod.POST)		
		public  String processPurchase(@ModelAttribute("purchaseInfo")  PurchaseInfo purchaseInfo1,BindingResult result,Model model,
					HttpServletRequest req){
			req.getSession().getAttribute("purchaseInfo");
			System.out.println("processPurchase number of tickets"+purchaseInfo1.getNumberOfMovieTickets());
			String processMovieTickets = null;
			
			//purchaseInfo1.setMovieID(movieCart.getMovieID());					//TODO update all PurchaseInfo1 info
//			purchaseInfo1.setTimeID(movieCart.get());
			
			//??TODO How to pass the movieInfo and UserInfo to the Purchaseinfo
			//purchaseInfo1.setUserID(movieCart.getUserID());
			//purchaseInfo.setNumberOfMovieTickets(purchaseInfo.);
			//purchaseInfo1.setTicketPrice(movieCart.getTiketPrice());
			System.out.println("MovieID = "+purchaseInfo1.getMovieID());
			System.out.println("Number of Tickets ="+purchaseInfo1.getNumberOfMovieTickets());
			Integer userID = (Integer) req.getSession().getAttribute("UserID");		//TODO to keep track is valid UserID in order to process
			System.out.println("userID ="+userID);
			System.out.println("userID from Session = "+req.getSession().getAttribute("UserID"));
			
			//TODO after login it lost UserID and not able to enter this part.
			//if(userID!= null && purchaseInfo1.getUserID()!=null && userID.intValue() == purchaseInfo1.getUserID().intValue() ){									//ticket purchase.
			if(userID!= null ){									//ticket purchase.
				//Check Cookie expired or not if its not proceed
				boolean cookieExpired = movieImplService.checkCookie(req);
				System.out.println("cookieExpired =" +cookieExpired);				
				
				//TODO
				processMovieTickets = movieImplService.upDatePurchase(purchaseInfo1);
				if(processMovieTickets!=null &&processMovieTickets.equalsIgnoreCase("Yes")){
					System.out.println("Email will send successfull to user ="+purchaseInfo1.getUserID());
					
				}
					
			}else{
				//TODO need to login after login come to the same page.
				
				System.out.println("User is not logged in, need to login inorder to purchase");
				return "forward:Login";								
			}
			model.addAttribute("isPurchased",processMovieTickets);
			model.addAttribute("movieCart", movieCart);
			
			return "purchased";		
			
		}
		
		@RequestMapping(value = "/Login", params = "Login", method = RequestMethod.GET)
		public String logIn(Model model) {
			
			NewUser newUser = new NewUser();
			
			model.addAttribute("newUser", newUser);
			return "Login";
			// return "index";
		}
		
		@RequestMapping(params = "/retrievePassWord", method = RequestMethod.POST)
		public String RetrievePassWord(@ModelAttribute("newUser")  NewUser newUser,HttpServletRequest req,BindingResult result,
				Model model){
			boolean retrievePassWordStatus =false;
			req.getSession().setAttribute("PasswordRetrieved", "false");
			System.out.println("RetrievePassWord");
			System.out.println("User name = "+newUser.getEmail());
			if(newUser.getEmail()!=null){
				retrievePassWordStatus = movieImplService.RetrievePassWord(newUser.getEmail());
			}
			if(retrievePassWordStatus){
				System.out.println("PasswordRetrieved");
				req.getSession().setAttribute("PasswordRetrieved", "true");
			}
					return null;
			
		}
		/**
		 * Existing user check for admin access then go AddMovies. else check the user is valid user or not 
		 * a)Valid user but the Payment information is missing then show new user with other fields except usrname and password.
		 * b)If Valid user and payment info then go to the previous page.
		 * c) if user does not exist need to show error message saying the user is not valid create new user. spring:message use
		 * d) if user is correct and password is wrong then retrieve the password , password will be send to email.
		 * @param newUser
		 * @param req
		 * @param result
		 * @param model
		 * @return
		 */
		@RequestMapping(value="/Login",method=RequestMethod.POST)
		public String logInPost(@ModelAttribute("newUser")  NewUser newUser,HttpServletRequest req,BindingResult result,
				Model model){
			boolean retrievePassWordStatus =false;
			boolean IsUserExists = false;
			boolean isPaymentInfoExist = false;
			
			req.getSession().setAttribute("PasswordIncorrect", "false");
			req.getSession().setAttribute("NeedToUpdatePaymentInfo", "false");
			System.out.println("email =  "+newUser.getEmail());
			System.out.println("Password = "+newUser.getPassWord());
			String action = req.getParameter("action");                     //TODO hack to call RetrievePassword
			if(action !=null && action.equalsIgnoreCase("retrievePassWord")){
				System.out.println("RetrievePassWord");
				System.out.println("User name = "+newUser.getEmail());
				if(newUser.getEmail()!=null){
					retrievePassWordStatus = movieImplService.RetrievePassWord(newUser.getEmail());
				}
				if(retrievePassWordStatus){
					req.getSession().setAttribute("PasswordRetrieved", "true");
				}
				return "Login";
			}
			
			if(newUser!=null )
				System.out.println(" Registered "+newUser.getRegister());
			if(newUser.getEmail()!=null && newUser.getEmail().contains("admin") && newUser.getPassWord().contains("admin") ){
				
				req.getSession().setAttribute("IsAdmin","Yes");
				MovieList movieList = new MovieList();	
				return "MovieList";
			}
			
			NewUser newUser1 = new NewUser();			
			model.addAttribute("newUser", newUser1);
			
			if(newUser.getEmail()!=null && newUser.getPassWord()!=null){
				NewUser newUserInfo = movieImplService.getUserInfo(newUser.getEmail()); //TODO return User and check payinfo
				if(newUserInfo != null && newUserInfo.getEmail().equalsIgnoreCase(newUser.getEmail())){
					
					if(newUserInfo.getPassWord().equalsIgnoreCase(newUser.getPassWord())){
						IsUserExists = true;
						req.getSession().setAttribute("UserID",newUserInfo.getUserID() );  //current session UserID will be used to purchase.
					}else{
						System.out.println("Password does not exist");
						req.getSession().setAttribute("PasswordIncorrect", "true");
						return "Login";
					}
				}else{
					System.out.println("User does not exist need to login again or register");
					req.getSession().setAttribute("RetryOrRegister", "true");					
					return "Login";
				}
						
				if(IsUserExists){
					
					if(!(newUserInfo.getCreditCardNumber() >0)){
						req.getSession().setAttribute("NeedToUpdatePaymentInfo", "true");
						newUser1.setEmail(newUser.getEmail());
						newUser1.setPassWord(newUser.getPassWord());  //TODO Mask show stars for password
						model.addAttribute("newUser", newUser1);
						return "forward:NewUser1";          //TODO sendnew.jsp with only paymentinfo
					}
					System.out.println("User Exists");
					req.getSession().setAttribute("IsAdmin","No");
					MovieList movieList1 = new MovieList();
					model.addAttribute("movieList", movieList1);
					return "forward:movie";
				}else{
					
					
				}
			}
			
			return  "Login";
		}
			
}
