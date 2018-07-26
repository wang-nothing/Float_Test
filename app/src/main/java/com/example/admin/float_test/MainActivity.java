package com.example.admin.float_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.library.AutoFlowLayout;
import com.example.library.FlowAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private AutoFlowLayout auto_layout;
    private ImageView select;
    private EditText etName;
    private TextView diss;
    private ImageView delete;
    private List<String> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mList = new ArrayList<>();
        auto_layout = findViewById(R.id.auto_layout);
        select = findViewById(R.id.select);
        etName = findViewById(R.id.et_name);
        diss = findViewById(R.id.diss);
        delete = findViewById(R.id.delete);
        select.setOnClickListener (this);
        diss.setOnClickListener (this);
        delete.setOnClickListener (this);
    }

    @Override
    public void onClick(View pView) {
        switch (pView.getId()){
            case R.id.select:
                String _s = etName.getText().toString();

                mList.add(_s);
                adapter();
                break;

            case R.id.diss:
                etName.getText().clear();

                mList.clear();
                break;

            case R.id.delete:
                etName.getText().clear();
                mList.clear();
                auto_layout.removeAllViews();
                break;
        }
    }

    public void adapter(){
        auto_layout.setAdapter(new FlowAdapter(mList) {

            private TextView mAuto_tv;
            private View mView;

            @Override
            public View getView(int pI) {
                mView = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_auto, null);
                mAuto_tv = mView.findViewById(R.id.auto_tv);
                mAuto_tv.setText(mList.get(pI));
                mList.clear();
                return mView;
            }
        });
    }
}
