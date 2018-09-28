package com.biz.st.helper;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.biz.st.database.BscVO;
import com.biz.st.frgment.MainFragment;

import java.util.List;

public class MainPageAdapter extends FragmentStatePagerAdapter {

    List<String> pageTitles;
    List<BscVO> bsclist;
    int buttonid;

    public MainPageAdapter(FragmentManager fm) {
        super(fm);
    }

    public MainPageAdapter(FragmentManager fm, List<BscVO> bsclist){
        super(fm);
        this.bsclist = bsclist;
    }

    public MainPageAdapter(FragmentManager fm, List<BscVO> bsclist, List<String> pageTitles){
        super(fm);
        this.bsclist = bsclist;
        this.pageTitles = pageTitles;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
//        return super.getPageTitle(position);
//        return bsclist.get(position).getBsc();

        return pageTitles.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return new MainFragment(bsclist, buttonid);
    }

    @Override
    public int getCount() {
        return pageTitles.size();
    }
}

