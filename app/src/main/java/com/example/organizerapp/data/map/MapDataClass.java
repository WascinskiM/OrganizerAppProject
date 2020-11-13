package com.example.organizerapp.data.map;

public class MapDataClass {
    public final static  MapDataClass SINGLETON_MAP = new MapDataClass();
    private  MapRepository mapRepository= new MapRepository();

    public MapDataClass() {
    }

    public MapRepository getMapRepository() {
        return mapRepository;
    }
}
