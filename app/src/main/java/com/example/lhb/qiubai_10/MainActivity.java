package com.example.lhb.qiubai_10;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;

import com.example.lhb.qiubai_10.Live.view.LiveFragment;
import com.example.lhb.qiubai_10.Message.view.MessageFragment;
import com.example.lhb.qiubai_10.Mine.view.MineFragment;
import com.example.lhb.qiubai_10.qiuShi.qiushiFragment;
import com.example.lhb.qiubai_10.qiuYouQuan.view.qiuYouQuanFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Button qiushi_btn;
    private Button qiuyouquan_btn;
    private Button live_btn;
    private Button message_btn;
    private Button mine_btn;
    private List<Fragment>list;
    private Fragment currentFragment;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    private void initview() {
        radioGroup = ((RadioGroup) findViewById(R.id.main_bottom_group));
        qiushi_btn = ((Button) findViewById(R.id.qiushi_btn));
        qiuyouquan_btn = ((Button) findViewById(R.id.qiuyouquan_btn));
        live_btn = ((Button) findViewById(R.id.live_btn));
        message_btn = ((Button) findViewById(R.id.message_btn));
        mine_btn = ((Button) findViewById(R.id.mine_btn));
        currentFragment=new qiushiFragment();
        setImg(qiushi_btn,R.drawable.ic_qiushi_select);
        initdata();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.qiushi_btn:
                        setImg(qiushi_btn, R.drawable.ic_qiushi_select);
                        fragment=list.get(0);
                        break;
                    case R.id.qiuyouquan_btn:
                        setImg(qiuyouquan_btn, R.drawable.ic_qiuyoucircle_select);
                        fragment=list.get(1);
                        break;
                    case R.id.live_btn:
                        fragment=list.get(2);
                        setImg(live_btn, R.drawable.ic_live_select);
                        break;
                    case R.id.message_btn:
                        fragment=list.get(3);
                        setImg(message_btn, R.drawable.ic_message_select);
                        break;
                    case R.id.mine_btn:
                        fragment=list.get(4);
                        setImg(mine_btn, R.drawable.ic_mine_select);
                        break;
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                if (fragment.isAdded()){
                    transaction.hide(currentFragment).show(fragment).commit();
                }else {
                    transaction.hide(currentFragment).add(R.id.ll,fragment).commit();
                }
                currentFragment=fragment;
            }
        });
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.ll,currentFragment).commit();
    }

    private void initdata() {
        list=new ArrayList<>();
        list.add(currentFragment);
        list.add(new qiuYouQuanFragment());
        list.add(new LiveFragment());
        list.add(new MessageFragment());
        list.add(new MineFragment());
    }

    private void setImg(Button button, int id) {
        Drawable drawable1 = getResources().getDrawable(R.drawable.ic_qiushi_normal);
        Drawable drawable2 = getResources().getDrawable(R.drawable.ic_qiuyoucircle_normal);
        Drawable drawable3 = getResources().getDrawable(R.drawable.ic_live_normal);
        Drawable drawable4 = getResources().getDrawable(R.drawable.ic_message_normal);
        Drawable drawable5 = getResources().getDrawable(R.drawable.ic_mine_normal);
        Drawable drawable6 = getResources().getDrawable(id);
        drawable1.setBounds(0, 0, 46, 46);
        drawable2.setBounds(0, 0, 46, 46);
        drawable3.setBounds(0, 0, 46, 46);
        drawable4.setBounds(0, 0, 46, 46);
        drawable5.setBounds(0, 0, 46, 46);
        drawable6.setBounds(0, 0, 46, 46);
        qiushi_btn.setCompoundDrawables(null, drawable1, null, null);
        qiuyouquan_btn.setCompoundDrawables(null, drawable2, null, null);
        live_btn.setCompoundDrawables(null, drawable3, null, null);
        message_btn.setCompoundDrawables(null, drawable4, null, null);
        mine_btn.setCompoundDrawables(null, drawable5, null, null);
        button.setCompoundDrawables(null, drawable6, null, null);
    }

}
