package asus.com.bwie.week3mn;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import asus.com.bwie.week3mn.adapter.MyPageAdapter;
import asus.com.bwie.week3mn.fragment.BillFragment;
import asus.com.bwie.week3mn.fragment.ShopCarFragment;
import asus.com.bwie.week3mn.fragment.ShopFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = findViewById(R.id.vp);
        rg = findViewById(R.id.rg);

        List<Fragment> list=new ArrayList<>();
        list.add(new ShopFragment());
        list.add(new ShopCarFragment());
        list.add(new BillFragment());

        MyPageAdapter myPageAdapter=new MyPageAdapter(getSupportFragmentManager(), (ArrayList<Fragment>) list);
        vp.setAdapter(myPageAdapter);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){

                    case R.id.shoprb:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.shopcarrb:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.billrb:
                        vp.setCurrentItem(2);
                        break;


                }
            }
        });




    }
}
