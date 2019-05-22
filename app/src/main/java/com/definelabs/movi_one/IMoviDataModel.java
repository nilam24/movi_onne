package com.definelabs.movi_one;



import java.util.ArrayList;

import rx.Observable;

public interface IMoviDataModel {

    //abstract method define in Arraylist
   Observable<MoviDataModel>getMoviList();

}
