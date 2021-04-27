///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package facades;
//
//import org.json.JSONObject;
//import java.io.IOException;
//import javax.persistence.EntityManagerFactory;
//import utils.HttpUtils;
//
//
///**
// *
// * @author Yones
// */
//public class FetchFacade {
//    private static EntityManagerFactory emf;
//    private static FetchFacade instance;
//    
//    public static FetchFacade getFetchFacade(EntityManagerFactory _emf) {
//        if (instance == null) {
//            emf = _emf;
//            instance = new FetchFacade();
//        }
//        return instance;
//    }
//    
//    https://devqa.io/how-to-parse-json-in-java/
//    public JokeDTO chuckJokes() throws IOException {
//        
//        String json = HttpUtils.fetchData("https://api.chucknorris.io/jokes/random");
//      JSONObject obj = new JSONObject(json);
//      JokeDTO jokeDTO = new JokeDTO();
//      String joke = obj.getString("value");
//     
//      jokeDTO.setValue(joke);
//        return jokeDTO;  
//    }
//    
//}