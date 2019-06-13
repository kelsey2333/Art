package dao;

import domain.Town;

import java.util.List;

public interface TownDao {
    List<Town> selectTownsByCitycode(String citycode);
}
