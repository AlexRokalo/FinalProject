package BusesShedule.Deserializer;

import BusesShedule.Bus;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BusDeserializer implements JsonDeserializer<Bus> {

    @Override
    public Bus deserialize(JsonElement jsonElement, Type type,
                           JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();
        String id = object.get("id").getAsString();
        String busNumber = object.get("busNumber").getAsString();
        String locationStart = object.get("locationStart").getAsString();
        String locationEnd = object.get("locationEnd").getAsString();
        String price = object.get("price").getAsString();
        String dateStart = object.get("dateStart").getAsString();
        String dateEnd = object.get("dateEnd").getAsString();

        JsonArray array = object.getAsJsonArray("waypoints");

        return new Bus.BusBuilder().setID(id).setBusNumber(busNumber).setlocationStart(locationStart)
                .setlocationEnd(locationEnd).setPrice(price).setDateStart(dateStart).setDateEnd(dateEnd)
                .setWaypoints(MakeWaypoints(array)).create();
    }

    private List<String> MakeWaypoints(JsonArray array) {
        List<String> waypoints = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            waypoints.add(array.get(i).getAsString());
        }
        return waypoints;
    }
}