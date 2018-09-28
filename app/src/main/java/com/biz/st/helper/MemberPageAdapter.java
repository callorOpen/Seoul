package com.biz.st.helper;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.biz.st.database.MemberVO;

import java.util.List;

public class MemberPageAdapter extends FragmentStatePagerAdapter {

    List<MemberVO> memberlist;

    public MemberPageAdapter(FragmentManager fm) {
        super(fm);
    }

    public MemberPageAdapter(FragmentManager fm, List<MemberVO> memberlist) {
        super(fm);
        this.memberlist = memberlist;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
