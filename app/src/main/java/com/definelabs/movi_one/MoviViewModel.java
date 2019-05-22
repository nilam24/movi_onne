package com.definelabs.movi_one;

import rx.Observable;

public class MoviViewModel  {
    IMoviDataModel moviDataModel;
    public MoviViewModel(){

    }
    public MoviViewModel(IMoviDataModel moviDataModel){
        this.moviDataModel=moviDataModel;
    }

    Observable<MoviDataModel> getMovieList(){
       return moviDataModel.getMoviList();
    }
}
