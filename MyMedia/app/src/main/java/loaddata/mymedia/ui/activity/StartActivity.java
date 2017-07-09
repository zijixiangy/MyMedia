package loaddata.mymedia.ui.activity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import loaddata.mymedia.R;
import loaddata.mymedia.presenter.contract.StartContract;
import loaddata.mymedia.presenter.impl.StartPrecenter;

import static loaddata.mymedia.R.id.start_tv;

/**
 * Created by svmsung on 2017-06-28.
 * 启动页
 */
public class StartActivity extends BaseActivity implements StartContract.View{
    @BindView(start_tv)
    TextView startTv;
    @BindView(R.id.start_img)
    ImageView startImg;
    @BindView(R.id.start_llay)
    LinearLayout startLlay;
    private Myconnt my;
    private AnimationDrawable ad;

    StartContract.Presenter presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置无标题，无状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //加载布局
        setContentView(R.layout.activity_start);

        //使用初始化布局的框架，绑定view
        ButterKnife.bind(this);

        initView();

        presenter=new StartPrecenter(this);
    }

    private void initView() {
        // 实例化一个持续4秒，间隔为一秒的计时器
        my = new Myconnt(8000, 1000);
        my.start();
        //设置，开始帧动画
        startImg.setBackgroundResource(R.drawable.lmhcr_amin);
        ad = (AnimationDrawable) startImg.getBackground();
        ad.start();
    }


    @Override
    public void intent2Act() {
        my.cancel();
        ad.stop();
        startActivity(new Intent(StartActivity.this, MainActivity.class));
        finish();
    }


    @OnClick({start_tv, R.id.start_img})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case start_tv:
                presenter.startIntent();
                break;
            case R.id.start_img:
                break;
        }
    }


    class Myconnt extends CountDownTimer {
        public Myconnt(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }
        /**
         * 每隔l的一段时间就会调用的方法。
         * @param l 剩余的时间
         */
        @Override
        public void onTick(long l) {
            startTv.setTextColor(getResources().getColor(R.color.colorAccent));
            startTv.setText("跳过" + l / 1000 + "s");
        }
        @Override
        public void onFinish() {
            presenter.startIntent();
        }
    }
}
