package com.packt.movie.controller.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;


import com.packt.movie.controller.MovieController;
import com.packt.movie.model.MovieList;
import com.packt.movie.service.MovieImplService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContext.class, WebAppContext.class})
@WebAppConfiguration
public class MovieControllerTest {
	private MockMvc mockMVC;
	@Autowired
	MovieController movieController;
	
	MovieImplService movieImplService  = Mockito.mock(MovieImplService.class);
@Test
	public void getMovieListByMovieIDTest() throws Exception{
	when(movieImplService.getMovieListByMovieID(12).thenReturn(new MovieList());
/*	when(movieController.getPriceInfo(isA(TodoDTO.class))).thenReturn(added);
	
	
	MovieList movieList = new MovieList();
	movieList = movieImplService.getMovieListByMovieID(movieID);*/
}
}
