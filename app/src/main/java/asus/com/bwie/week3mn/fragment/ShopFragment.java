package asus.com.bwie.week3mn.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import asus.com.bwie.week3mn.Apis;
import asus.com.bwie.week3mn.R;
import asus.com.bwie.week3mn.presenter.PresenterImpl;
import asus.com.bwie.week3mn.view.IView;

public class ShopFragment extends Fragment implements IView {

    private RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shopf_layout, container, false);


        return view;
    }
    @Override
    public void onSuccessData(Object data) {

    }

    @Override
    public void onFailsData(Exception e) {

    }
}
