package com.example.user.mymaterial;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mLinerButton;
    private Button mGridButton;
    private Button mStaggeredButton;

    private Bundle mBundle;

    // Layoutのタイプを設定する定数
    public static final String LAYOUT_TYPE = "layout_type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLinerButton = (Button) findViewById(R.id.linear_layout_button);
        mGridButton = (Button) findViewById(R.id.grid_layout_button);
        mStaggeredButton = (Button) findViewById(R.id.staggered_layout_button);

        mLinerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBundle = new Bundle();
                mBundle.putString(LAYOUT_TYPE, "Linear");
                setFragment();
            }
        });

        mGridButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBundle = new Bundle();
                mBundle.putString(LAYOUT_TYPE, "Grid");
                setFragment();
            }
        });

        mStaggeredButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBundle = new Bundle();
                mBundle.putString(LAYOUT_TYPE, "Staggered");
                setFragment();
            }
        });


    }

    public void setFragment() {
        /**
         * Fragmentの生成
         * Fragmentのインスタンス化
         * FragmentManeger: Fragmentを管理する
         * FragmentTransaction: Fragmentの追加や削除、置換を管理する
         *
         * supportの方じゃないと使えない？？
         */
        // Fragmentのインスタンス化
        RecyclerFragment fragment = new RecyclerFragment();
        fragment.setArguments(mBundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_image, fragment);
        fragmentTransaction.commit();
    }

}