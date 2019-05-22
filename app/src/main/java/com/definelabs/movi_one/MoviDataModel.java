package com.definelabs.movi_one;

import rx.Observable;

public class MoviDataModel implements IMoviDataModel {

    private String title="manikarnika";
    private String id="1";

    public MoviDataModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;

    }

    @Override
    public Observable<MoviDataModel> getMoviList() {
        return Observable.just(new MoviDataModel());
    }
}
