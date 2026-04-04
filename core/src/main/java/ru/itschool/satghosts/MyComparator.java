package ru.itschool.satghosts;

import java.util.Comparator;

public class MyComparator implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        return p1.time.compareTo(p2.time);
    }
}
