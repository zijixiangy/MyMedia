package loaddata.mymedia.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import loaddata.mymedia.R;

/**
 * Created by svmsung on 2017-07-05.
 */

public class Fragmentmain extends Fragment {

    @BindView(R.id.main_tab)
    TabLayout mainTab;
    @BindView(R.id.fragment_main_viewpager)
    ViewPager viewpager;

    Unbinder unbinder;
    List<Fragment> fragments;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragments = new ArrayList<>();
        FragmentMusicList fm=new FragmentMusicList();
        FragmentVideo fv=new FragmentVideo();
        FragmentZB fz=new FragmentZB();
        fragments.add(fm);
        fragments.add(fv);
        fragments.add(fz);
        //FragmentPager适配器
        FragmentPagerAdapter fragmentPagerAdapter=new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return super.getPageTitle(position);
            }
        };
        viewpager.setAdapter(fragmentPagerAdapter);
        //把tablayout和viewPager绑定
        mainTab.setupWithViewPager(viewpager);
        setItem();
        //添加标签选择监听
        mainTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                setSelectTab(tab);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        tab.setIcon(R.mipmap.skin_tab_icon_now_normal);
                        break;
                    case 1:
                        tab.setIcon(R.mipmap.skin_tab_icon_plugin_normal);
                        break;
                    case 2:
                        tab.setIcon(R.mipmap.skin_tab_icon_contact_normal);
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewpager.setOffscreenPageLimit(3);//设置ViewPager预加载个数,设置屏幕以外的页面数
    }

    private void setSelectTab(TabLayout.Tab tab) {
        switch (tab.getPosition()){
            case 0:
                tab.setIcon(R.mipmap.skin_tab_icon_now_selected);
                break;
            case 1:
                tab.setIcon(R.mipmap.skin_tab_icon_plugin_selected);
                break;
            case 2:
                tab.setIcon(R.mipmap.skin_tab_icon_contact_selected);
                break;
        }
    }

    private void setItem() {
        mainTab.getTabAt(0).setIcon(R.mipmap.skin_tab_icon_now_normal);
        mainTab.getTabAt(1).setIcon(R.mipmap.skin_tab_icon_plugin_normal);
        mainTab.getTabAt(2).setIcon(R.mipmap.skin_tab_icon_contact_normal);


        setSelectTab(mainTab.getTabAt(mainTab.getSelectedTabPosition()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
