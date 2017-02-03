package com.packt.movie.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;
import org.springframework.web.multipart.MultipartFile;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import org.hibernate.annotations.Parameter;


@Entity
@Table(name ="MOVIE_LIST")
@Cacheable
@Cache(region="movieList",usage=CacheConcurrencyStrategy.READ_WRITE )
public class MovieList implements Serializable {
//	public Date movieDate1;
	@Column(name = "movieDate")
	public String movieDate;
	@Id
	@Column(name = "movieID", unique = true, nullable = false)
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name = "gen", strategy = "foreign", 
				parameters = { @Parameter(name = "property", value = "movieList") })
	public Integer movieID;
	@Column(name = "movieName")
	public String movieName;
	@Column(name = "movieDuration")
	public Integer movieDuration;
	
	@Transient
	private MultipartFile  movieImage;
	//private File movieImage;
	//@Column(name = "movieName")
	@Transient
	private String movieImageFileName;
	
	@Column(name = "Show1")
	private Integer show1;
	
	@Column(name = "Show2")
	private Integer show2;
	
	@Column(name = "Show3")
	private Integer show3;
	
	@Column(name = "PriceID")
	private Integer priceID;
	
	//@ManyToMany (fetch= FetchType.LAZY,cascade = CascadeType.ALL)
	
	//@Transient
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name ="movie_time", joinColumns= { @JoinColumn(name="movieID")},
			inverseJoinColumns ={ @JoinColumn(name="TimeID")})
	private List<TimeInfo> timeInfo = new ArrayList<TimeInfo>();
	
	
	public List<TimeInfo> getTimeInfo() {
		return timeInfo;
	}

	public void setTimeInfo(List<TimeInfo> timeInfo) {
		this.timeInfo = timeInfo;
	}

	public String getMovieDate() {
		return movieDate;
	}
	
	public void setMovieDate(String movieDate) {
		this.movieDate = movieDate;
	}
	public Integer getMovieID() {
		return movieID;
	}
	public void setMovieID(Integer movieID) {
		this.movieID = movieID;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Integer getMovieDuration() {
		return movieDuration;
	}
	public void setMovieDuration(Integer movieDuration) {
		this.movieDuration = movieDuration;
	}
	public MultipartFile getMovieImage() {
		return movieImage;
	}
	public void setMovieImage(MultipartFile movieImage) {
		this.movieImage = movieImage;
	}
	public String getMovieImageFileName() {
		return movieImageFileName;
	}
	public void setMovieImageFileName(String movieImageFileName) {
		this.movieImageFileName = movieImageFileName;
	}

	public Integer getShow1() {
		return show1;
	}

	public void setShow1(Integer show1) {
		this.show1 = show1;
	}

	public Integer getShow2() {
		return show2;
	}

	public void setShow2(Integer show2) {
		this.show2 = show2;
	}

	public Integer getShow3() {
		return show3;
	}

	public void setShow3(Integer show3) {
		this.show3 = show3;
	}

	
	
	
}
