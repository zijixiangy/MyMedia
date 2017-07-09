package loaddata.mymedia.presenter.impl;

import loaddata.mymedia.presenter.contract.StartContract;

/**
 * Created by svmsung on 2017-07-07.
 */

public class StartPrecenter implements StartContract.Presenter {
    StartContract.View view;

    public StartPrecenter(StartContract.View view) {
        this.view = view;
    }

    @Override
    public void startIntent() {
       view.intent2Act();
    }
}
