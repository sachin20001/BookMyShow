package org.example.book_my_show.Controllers;

import org.example.book_my_show.models.*;
import org.example.book_my_show.models.enums.Feature;
import org.example.book_my_show.models.enums.SeatStatus;
import org.example.book_my_show.models.enums.SeatType;
import org.example.book_my_show.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Controller
public class DataPopulator {


    @Autowired
    private AuditoriumRepository auditoriumRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private MovieShowRepository movieShowRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/generate")
    @ResponseBody
    public ResponseEntity<String> generateData()
    {
        //Delete Previous data;
        userRepository.deleteAll();
        auditoriumRepository.deleteAll();
        cityRepository.deleteAll();
        movieShowRepository.deleteAll();
        paymentRepository.deleteAll();
        seatRepository.deleteAll();
        showSeatRepository.deleteAll();
        theatreRepository.deleteAll();
        theatreRepository.deleteAll();

        User user=User.builder().username("Test User").email("Test@gmail.com").password("123456").build();
        User savedUsed=userRepository.save(user);

        //Adding the city
        City delhi=getCity("Delhi");

        return  ResponseEntity.ok("date has been generated successfully");



    }

    public City getCity(String cityName)
    {
        City city=City.builder().name(cityName).build();

        List<Theatre> theatreList=getTheatres();

        for(Theatre theatre:theatreList)
        {
            city.getTheatreList().add(theatre);
            theatre.setCity(city);
        }

        City savedCity=cityRepository.save(city);
        return savedCity;

    }

    public List<Theatre> getTheatres()
    {
        List<Theatre> theatreList=new ArrayList<>();
        theatreList.add(getTheatre("PVR_SAKET","SAKET"));


        theatreList=theatreRepository.saveAll(theatreList);
        return theatreList;
    }

    public Theatre getTheatre(String name,String address)
    {
        Theatre theatre=Theatre.builder().name(name).address(address).build();

        List<Auditorium> auditoriumList=getAuditoriums();

        for(Auditorium auditorium:auditoriumList)
        {
            theatre.getAuditoriums().add(auditorium);
            auditorium.setTheatre(theatre);

        }

        return theatre;
    }

    public List<Auditorium> getAuditoriums()
    {
        List<Auditorium> auditoriumList=new ArrayList<>();
        auditoriumList.add(getAuditorium("Screen 1",10,10));

        //auditoriumList=auditoriumRepository.saveAll(auditoriumList);
        return auditoriumList;
    }

    public Auditorium getAuditorium(String name,int rows,int cols)
    {
        Auditorium auditorium=Auditorium.builder().name(name).numRows(rows).numCols(cols).build();
        auditorium.getFeatures().add(Feature._3D);
        auditorium.getFeatures().add(Feature.DOLBY);

        auditorium=auditoriumRepository.save(auditorium);


        auditorium.getSeats().addAll(getSeats());
        for(Seat seat:auditorium.getSeats()) {

            seat.setAuditorium(auditorium);

        }




        List<MovieShow> movieShows=getMovieShows(auditorium);

        for(MovieShow movieShow:movieShows)
        {
            auditorium.getShows().add(movieShow);
            movieShow.setAuditorium(auditorium);

        }


        return auditorium;
    }

    public List<Seat> getSeats()
    {
        List<Seat> seatList=new ArrayList<>();
        seatList.add(getSeat("1A",SeatType.SILVER,100));
        seatList.add(getSeat("1B",SeatType.SILVER,100));
        seatList.add(getSeat("1C",SeatType.SILVER,100));
        seatList.add(getSeat("1D",SeatType.SILVER,100));
        seatList.add(getSeat("1E",SeatType.SILVER,100));

        seatList.add(getSeat("2A",SeatType.GOLD,200));
        seatList.add(getSeat("2B",SeatType.GOLD,200));
        seatList.add(getSeat("2C",SeatType.GOLD,200));
        seatList.add(getSeat("2D",SeatType.GOLD,200));
        seatList.add(getSeat("2E",SeatType.GOLD,200));

        seatList.add(getSeat("3A",SeatType.PLATINUM,300));
        seatList.add(getSeat("3B",SeatType.PLATINUM,300));
        seatList.add(getSeat("3C",SeatType.PLATINUM,300));
        seatList.add(getSeat("3D",SeatType.PLATINUM,300));
        seatList.add(getSeat("3E",SeatType.PLATINUM,300));

        seatList=seatRepository.saveAll(seatList);
        return seatList;
    }

    public Seat getSeat(String number, SeatType seatType,int price) {
        return Seat.builder().number(number).seatType(seatType).price(price).build();
    }

    public List<MovieShow> getMovieShows(Auditorium auditorium)
    {
        List<MovieShow> movieShowList=new ArrayList<>();
        movieShowList.add(getMovieShow("Animal",LocalDate.now(),LocalTime.now(),1.2f,auditorium));


        movieShowList=movieShowRepository.saveAll(movieShowList);
        return movieShowList;

    }

    public MovieShow getMovieShow(String name, LocalDate showDate, LocalTime startTime,float rateMultiplier,Auditorium auditorium) {
        MovieShow movieShow=MovieShow.builder().name(name).showDate(showDate).startTime(startTime).rateMultiplier(rateMultiplier).auditorium(auditorium).build();

        List<ShowSeat> showSeatList=getShowSeats(auditorium);

        for(ShowSeat showSeat:showSeatList)
        {
            movieShow.getShowSeatList().add(showSeat);
            showSeat.setMovieShow(movieShow);
            showSeat.setPrice((int)(showSeat.getSeat().getPrice()*movieShow.getRateMultiplier()));

        }

        return movieShow;
    }

    public List<ShowSeat> getShowSeats(Auditorium auditorium)
    {
        List<ShowSeat> showSeatList=new ArrayList<>();
        for(Seat seat:auditorium.getSeats())
        {
            showSeatList.add(getShowSeat(seat));
        }

        showSeatList=showSeatRepository.saveAll(showSeatList);

        return showSeatList;


    }

    public ShowSeat getShowSeat(Seat seat) {
        return  ShowSeat.builder().seat(seat).seatStatus(SeatStatus.AVAILABLE).build();
    }






}
