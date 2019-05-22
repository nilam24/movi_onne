package com.definelabs.movi_one;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observer;
import rx.Scheduler;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_text)
    TextView tv_text;
    MoviViewModel viewModel;
    IMoviDataModel iMoviDataModel;
    CompositeSubscription compositeSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        iMoviDataModel=new MoviDataModel();
        viewModel=new MoviViewModel(iMoviDataModel);
        compositeSubscription=new CompositeSubscription();
     }

    @Override
    protected void onStart() {
        super.onStart();
        compositeSubscription=new CompositeSubscription();
        compositeSubscription.add(viewModel.getMovieList()
                              .subscribeOn(Schedulers.io())
                               .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(this::settingText));
    }

    private void settingText(MoviDataModel moviDataModel) {
        String id=moviDataModel.getId();
        String title=moviDataModel.getTitle();
        tv_text.setText("..... :-)"+id+")"+title);
    }


}
