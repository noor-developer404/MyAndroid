package com.example.android.others

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.android.fragments.tab_frag1
import com.example.android.fragments.tab_frag2
import com.example.android.fragments.tab_frag3


class tab_pageAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
       when(position){
           0-> return tab_frag1()
           1-> return tab_frag2()
           2-> return tab_frag3()
       }
        return tab_frag1()
    }

}