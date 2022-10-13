package com.example.restservice;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/api")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/api/quote")
    public String getRandomQuote(){
        ArrayList<String> quotes = getQuotes();
        Random r = new Random();
        int idx = r.nextInt(quotes.size());
        return "{\"quote\":\""+quotes.get(idx)+"\"}";
    }

    @GetMapping("/api/shows")
    public String getShows(){
        String ret = "[";
        HashMap<String, ArrayList<String>> map = quotesMap();
        int id=0;
        for(String s: map.keySet()) {
            if (map.get(s).size()!=0)
                ret += "{\"id\":" + (id++) + ", \"show\":\"" + s + "\"},";
        }
        return ret.substring(0,ret.length()-1)+"]";
    }

    @GetMapping("/api/quotes")
    public String getQuotesByShow(@RequestParam(value="show", defaultValue = "0") int id){
        HashMap<String, ArrayList<String>> map = quotesMap();
        int i=0;
        Random rand = new Random();
        for(String s: map.keySet()) {
            if (id != i)
                i++;
            else
                return "{\"show_id\":"+id+", \"quote\":\""+map.get(s).get(rand.nextInt(map.get(s).size()))+"\"}";
        }
        return "{\"erro\":\"ID inválido\"}";
    }

    public HashMap<String, ArrayList<String>> quotesMap(){
        HashMap<String, ArrayList<String>> ret = new HashMap<>();

        ret.put("Curral de Moinas - Os Banqueiros do Povo", new ArrayList<>(Arrays.asList("Mas agora é tudo família? Estamos nos Açores ou quê?")));
        ret.put("O Pátio das Cantigas", new ArrayList<>(Arrays.asList("Ó Evaristo, tens cá disto?", "Podes ficar com ele, até lhe ponho um laço")));
        ret.put("Canção de Lisboa", new ArrayList<>(Arrays.asList("Chapéus há muitos, seu palerma!")));

        return ret;
    }

    public ArrayList<String> getQuotes(){
        ArrayList<String> quotes = new ArrayList<>();
        HashMap<String, ArrayList<String>> allQuotes = quotesMap();
        for(String s: allQuotes.keySet())
            quotes.addAll(allQuotes.get(s));
        return quotes;
    }

}