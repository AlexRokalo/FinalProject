package OnlineReadBase;

import BusesShedule.BusSchedule;


public interface OnlineRead {
    BusSchedule makeSchedule() throws Exception;
}