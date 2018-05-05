package OnlineReadBase;

import BusesShedule.Bus;

import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import java.util.ArrayList;
import java.util.List;

public class STAXBuilder {
    private List<String> name = new ArrayList<>();

    private String idCreate;
    private String busNumberCreat;
    private String locationStartCreat;
    private String locationEndCreat;
    private String priceCreat;
    private String dateStartCreat;
    private String dateEndCreat;
    private List<Bus> buses = new ArrayList<>();

    private boolean id = false;
    private boolean busNumber = false;
    private boolean locationStart = false;
    private boolean locationEnd = false;
    private boolean price = false;
    private boolean dateStart = false;
    private boolean dateEnd = false;
    private boolean waypoints = false;
    private boolean eventW = false;
    private List<String> plases = new ArrayList<>();

    public void startELem(String qName) {
        if (qName.equalsIgnoreCase("element")) {
            if (waypoints)
                eventW = true;
        } else if (qName.equalsIgnoreCase("busNumber")) {
            busNumber = true;
        } else if (qName.equalsIgnoreCase("id")) {
            id = true;
        } else if (qName.equalsIgnoreCase("locationStart")) {
            locationStart = true;
        } else if (qName.equalsIgnoreCase("locationEnd")) {
            locationEnd = true;
        } else if (qName.equalsIgnoreCase("price")) {
            price = true;
        } else if (qName.equalsIgnoreCase("dateStart")) {
            dateStart = true;
        } else if (qName.equalsIgnoreCase("dateEnd")) {
            dateEnd = true;
        } else if (qName.equalsIgnoreCase("waypoints")) {
            waypoints = true;
        }
    }

    public void body(Characters characters) {
        if (busNumber) {
            busNumberCreat = characters.getData();
            busNumber = false;
        }
        if (id) {
            idCreate = characters.getData();
            id = false;
        }
        if (locationStart) {
            locationStartCreat = characters.getData();
            locationStart = false;
        }
        if (locationEnd) {
            locationEndCreat = characters.getData();
            locationEnd = false;
        }
        if (price) {
            priceCreat = characters.getData();
            price = false;
        }
        if (dateStart) {
            dateStartCreat = characters.getData();
            dateStart = false;
        }
        if (dateEnd) {
            dateEndCreat = characters.getData();
            dateEnd = false;
        }
        if (eventW) {
            plases.add(characters.getData());
            eventW = false;
        }
    }

    public void endElement(EndElement endElement) {
        if (endElement.getName().getLocalPart().equalsIgnoreCase("element")) {
            if (!waypoints) {
                buses.add(new Bus.BusBuilder().setBusNumber(busNumberCreat).setID(idCreate).setDateEnd(dateEndCreat)
                        .setDateStart(dateStartCreat).setlocationEnd(locationEndCreat)
                        .setlocationStart(locationStartCreat).setPrice(priceCreat).setWaypoints(plases).create());
                plases.clear();
            }
        }

        if (endElement.getName().getLocalPart().equalsIgnoreCase("waypoints")) {
            waypoints = false;
        }
    }

    public List<Bus> getBuses() {
        return buses;
    }
}