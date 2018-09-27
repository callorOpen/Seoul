package com.biz.st.frgment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.biz.st.frgment.frg_model.PagerVO;

import java.util.List;

public class BCS_PagerAdapter extends FragmentStatePagerAdapter{

    List<String> stringList ;
    List<PagerVO> pageList_BCS ;

    public BCS_PagerAdapter(FragmentManager fm) {
        super(fm);
    }
//
//    public MainPagerAdapter(FragmentManager fm, List<String> list) {
//        super(fm);
//        this.stringList = list ;
//    }

    public BCS_PagerAdapter(FragmentManager fm, List<PagerVO> list) {
        super(fm);
        this.pageList_BCS = list ;

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
       // return super.getPageTitle(position);
        return  pageList_BCS.get(position).getPageTitle();
    }

    @Override
    public Fragment getItem(int position) {
//        return MainFragment.newInstance(pageList.get(position).getPageTitle(), "연습");
        return new MainFragment(pageList_BCS.get(position).getTextList());
    }

    @Override
    public int getCount() {
        return pageList_BCS.size();
    }


}
