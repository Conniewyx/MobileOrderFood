package com.example.connie.mobileorderfood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    static List<Map<String,Object>> mfoodinfo;
    public ListView mlistview;
    static SimpleAdapter mlistItemAdapter;
    public ArrayList<Dish>mDishes = new ArrayList<Dish>();

    private void FillDishesList(){
        Dish theDish = new Dish();
        theDish.mName = "宫保鸡丁";
        theDish.mInfo = "北京宫廷菜，入口鲜辣香脆";
        theDish.mImage = (R.raw.food1);
        mDishes.add(theDish);

        theDish = new Dish();
        theDish.mName = "椒盐玉米";
        theDish.mInfo = "色香味俱全，浙江菜";
        theDish.mImage = (R.raw.food2);
        mDishes.add(theDish);

        theDish = new Dish();
        theDish.mName = "清蒸武昌鱼";
        theDish.mInfo = "湖北鄂州传统名菜";
        theDish.mImage = (R.raw.food3);
        mDishes.add(theDish);

        theDish = new Dish();
        theDish.mName = "鱼香肉丝";
        theDish.mInfo = "经典汉族传统川菜";
        theDish.mImage = (R.raw.food4);
        mDishes.add(theDish);
    }

    private ArrayList<Map<String,Object>>getFoodData()
    {
        ArrayList<Map<String,Object>>fooddata = new ArrayList<Map<String, Object>>();
        int s = mDishes.size();
        for (int i = 0; i<s; i++)
        {
            Dish theDish = mDishes.get(i);
            Map<String,Object>map = new HashMap<String,Object>();
            map.put("image",theDish.mImage);
            map.put("title",theDish.mName);
            map.put("info",theDish.mInfo);
            fooddata.add(map);
        }
        return fooddata;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FillDishesList();

        mlistview = (ListView)findViewById(R.id.ListViewDemo);
        mfoodinfo = getFoodData();

        mlistItemAdapter = new SimpleAdapter(this, mfoodinfo,R.layout.listitem,
                new String[]{"image","title","info"},
                new int[]{R.id.img, R.id.title,R.id.info});
        mlistItemAdapter.notifyDataSetChanged();
        mlistview.setAdapter(mlistItemAdapter);

        this.mlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0,
                                    View arg1,
                                    int arg2,
                                    long arg3) {

                ListView templist = (ListView)arg0;
                View mView = templist.getChildAt(arg2);
                final TextView tvTitle = (TextView)mView.findViewById(R.id.title);
                Toast.makeText(MainActivity.this,tvTitle.getText().toString(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}




