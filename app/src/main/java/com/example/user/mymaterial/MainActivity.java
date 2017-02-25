package com.example.user.mymaterial;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mNextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_image, fragment);
                fragmentTransaction.commit();
            }
        });


    }


}