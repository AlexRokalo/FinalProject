package BusesShedule.Deserializer;

import BusesShedule.Bus;
import BusesShedule.BusSchedule;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BusScheduleDeserializer implements JsonDeserializer<BusSchedule> {
    @Override
    public BusSchedule deserialize(JsonElement jsonElement, Type type,
                                   JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();
        String name = object.get("name").getAsString();
        String date = object.get("date").getAsString();

        JsonArray array = object.getAsJsonArray("schedule");

        return new BusSchedule.BusScheduleBuilder().setName(name).setDate(date)
                .setSchedule(MakeBussList(array)).crate();

    }

    private List<Bus> MakeBussList(JsonArray array) {
        JsonDeserializationContext jsonDeserializationContext = null;
        List<Bus> buses = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            JsonElement element = array.get(i);
            buses.add(new BusDeserializer().deserialize(element, Bus.class, jsonDeserializationContext));
        }

        return buses;
    }
}