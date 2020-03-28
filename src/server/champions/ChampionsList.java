package server.champions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michal Szarek
 **/
public class ChampionsList<T extends SimpleChampion> {
    private List<T> championsList = new ArrayList<>();

    public void addChampion(T champion) {
        championsList.add(champion);
    }

    @Override
    public String toString() {
        String list = "{\"champions\":[";

        for(SimpleChampion champion: championsList) {
            list = list + champion.toString() + ",";
        }

        list = list + "]}";
        return list;
    }
}
