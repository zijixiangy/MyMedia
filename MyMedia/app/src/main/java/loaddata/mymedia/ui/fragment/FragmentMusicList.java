package loaddata.mymedia.ui.fragment;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import loaddata.mymedia.R;
import loaddata.mymedia.ui.adapter.FragmentMusicListAdapter;

/**
 * Created by svmsung on 2017-07-05.
 */

public class FragmentMusicList extends Fragment {
    @BindView(R.id.fragment_music_localist)
    ImageView fragmentMusicBd;
    @BindView(R.id.fragment_music_xz)
    ImageView fragmentMusicXz;
    @BindView(R.id.fragment_music_zj)
    ImageView fragmentMusicZj;
    @BindView(R.id.fragment_music_wl)
    ImageView fragmentMusicWl;
    @BindView(R.id.fragment_music_xh_)
    ImageView fragmentMusicXh;
    @BindView(R.id.fragment_music_tj)
    ImageView fragmentMusicTj;
    @BindView(R.id.fragment_music_main_list)
    RecyclerView fragmentMusicMainList;
    Unbinder unbinder;

    //得到数据源
    List<String> musiclist = new ArrayList<>();
    private static final int ITEM_D = 5;
    @BindView(R.id.fragment_music_linear)
    LinearLayout fragmentMusicLinear;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        onViewClicked(view);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //设置上部分组件得到焦点，使一进去视图从上面开始
        fragmentMusicLinear.setFocusable(true);
        fragmentMusicLinear.setFocusableInTouchMode(true);
        fragmentMusicLinear.requestFocus();
        initList();
    }

    private void initList() {
        for (int i = 1; i < 20; i++) {
            musiclist.add("歌曲" + i);
        }
        //设置动画
        fragmentMusicMainList.setItemAnimator(new DefaultItemAnimator());
        //设置分割线
        fragmentMusicMainList.addItemDecoration(new RecyclerView.ItemDecoration() {

            @Override
            public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDrawOver(c, parent, state);
                Paint paint = new Paint();
                paint.setColor(getResources().getColor(R.color.colorPrimary));
                int left = parent.getPaddingLeft();
                int right = parent.getMeasuredWidth() - parent.getPaddingRight();
                int size = parent.getChildCount();
                for (int i = 0; i < size; i++) {
                    View childAt = parent.getChildAt(i);
                    int top = childAt.getBottom();
                    int bottom = top + ITEM_D;
                    c.drawRect(left, top, right, bottom, paint);
                }
            }

            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(5, 0, 0, ITEM_D);
            }
        });
        FragmentMusicListAdapter adapter = new FragmentMusicListAdapter(musiclist, getActivity());
        fragmentMusicMainList.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setStackFromEnd(false);
        fragmentMusicMainList.scrollToPosition(0);

        fragmentMusicMainList.setLayoutManager(llm);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.fragment_music_localist, R.id.fragment_music_xz, R.id.fragment_music_zj, R.id.fragment_music_wl, R.id.fragment_music_xh_, R.id.fragment_music_tj})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_music_localist:
                break;
            case R.id.fragment_music_xz:
                break;
            case R.id.fragment_music_zj:
                break;
            case R.id.fragment_music_wl:
                break;
            case R.id.fragment_music_xh_:
                break;
            case R.id.fragment_music_tj:
                break;
        }
    }
}
