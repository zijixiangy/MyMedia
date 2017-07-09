package loaddata.mymedia.presenter.contract;

/**
 * Created by svmsung on 2017-07-07.
 */

public interface StartContract {
    /**
     * view接口
     */
    interface  View{
        void intent2Act();
    }

    /**
     * presenter接口
     */
    interface Presenter{
        void startIntent();
    }
}
