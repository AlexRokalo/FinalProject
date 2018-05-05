package OnlineReadBase;

import BusesShedule.BusSchedule;
import BusesShedule.Deserializer.BusScheduleDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OnlineReadJSON implements OnlineRead {
    public BusSchedule makeSchedule() throws Exception {
        URL url = new URL("https://raw.githubusercontent.com/AlexRokalo/JSONBASE/master/BASE.json");//("http://kiparo.ru/t/bus_schedule.json");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();

        Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(BusSchedule.class, new BusScheduleDeserializer())
                .create();

        BusSchedule busSchedule = gson.fromJson(new BufferedReader
                (new InputStreamReader(connection.getInputStream())), BusSchedule.class);

        return busSchedule;
    }
}