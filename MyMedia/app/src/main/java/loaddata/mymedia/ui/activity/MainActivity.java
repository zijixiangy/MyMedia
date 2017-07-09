package loaddata.mymedia.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import loaddata.mymedia.R;
import loaddata.mymedia.ui.fragment.FragmentMusicPlay;
import loaddata.mymedia.ui.fragment.Fragmentmain;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_navigation)
    NavigationView mainNavigation;
    @BindView(R.id.activity_main_drawerlayout)
    DrawerLayout activityMainDrawerlayout;
    @BindView(R.id.main_fragment_view)
    FrameLayout mainFragmentView;
    @BindView(R.id.main_fragment_music)
    FrameLayout mainFragmentMusic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //判断设备版本是否大于4.4  api19
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setFragment();

    }

    private void setFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        Fragmentmain mainFragment = new Fragmentmain();
        ft.add(R.id.main_fragment_view, mainFragment);
        FragmentMusicPlay musicPlay=new FragmentMusicPlay();
        ft.add(R.id.main_fragment_music,musicPlay);

        ft.commit();
    }

    // 设置状态栏透明状态
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

}
