package com.example.user.mymaterial;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static com.example.user.mymaterial.MainActivity.LAYOUT_TYPE;


/**
 *
 * RecyclerViewを生成するフラグメント
 *
 */
public class RecyclerFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private String mLayoutType;

    private final String[] myDataset = {
            "a",
            "b",
            "c",
            "d",
            "e",
            "f",
            "g",
            "h",
            "i",
            "j",
            "k"
    };

    public RecyclerFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recycler, container, false);

        // fragmentを上書きする前に、前回の表示情報を消去
        container.removeAllViews();

        /**
         * RecyclerViewの生成
         * LayoutManagerをインスタンス化
         * RecyclerViewにLayoutManagerをセット
         * Adapterをインスタンス化
         * RecyclerViewにAdapterをセット
         */

        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        //setLayoutManager();

        Bundle bundle = getArguments();
        mLayoutType = bundle.getString(LAYOUT_TYPE);

        switch(mLayoutType){
            case "Linear":
                mLayoutManager = new LinearLayoutManager(getContext());
                Log.v("FragmentActivity", "selectButton");
                break;
            case "Grid":
                mLayoutManager = new GridLayoutManager(getContext(),2);
                break;
            case "Staggered":
                mLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
                break;
            default:
                Log.v("FragmentActivity", mLayoutType);
                break;
        }

        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyRecyclerAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

   /* private void setLayoutManager(){




    }*/

}
