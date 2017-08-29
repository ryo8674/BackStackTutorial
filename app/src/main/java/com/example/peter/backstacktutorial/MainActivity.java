package com.example.peter.backstacktutorial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * BackStackを確認するプログラム
 * メイン画面
 *
 * @author :ryo.yamada
 * @since :1.0 :2017/08/30
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //最初のFragmentを表示
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        Fragment newFragment = new Fragment1();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.add(R.id.container, newFragment);
        transaction.commit();
    }

    /**
     * fragment2へ遷移する
     *
     * @param view view
     */
    public void show2(View view) {
        // Fragment1で次へが押されるとFragment2を表示
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        Fragment newFragment = new Fragment2();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.replace(R.id.container, newFragment);
        // backstackに追加
        transaction.addToBackStack(null);
        transaction.commit();
    }

    /**
     * fragment3へ遷移する
     *
     * @param view view
     */
    public void show3(View view) {
        // Fragment2で次へが押されるとFragment3を表示
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 追加する前に一つ戻って、Fragment1が積まれた状態にしておく
        // これでFragment2は消える
        fragmentManager.popBackStack();
        Fragment newFragment = new Fragment3();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.replace(R.id.container, newFragment);
        // backstackに追加
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
