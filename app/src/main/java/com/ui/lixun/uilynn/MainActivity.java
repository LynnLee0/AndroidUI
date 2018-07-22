package com.ui.lixun.uilynn;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;


public class MainActivity extends AppCompatActivity {
//    private String[][] data = new String[3][3];
    ArrayList<String[]> dataList = new ArrayList<String[]>();
    ArrayList<String> gameList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_listview);
        intiGameList();
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new DataListViewAdapter(this));
        EditText tv_date = findViewById(R.id.ev_date);
        Button bt_search = findViewById(R.id.bt_search);
        DatePicker datePicker = findViewById(R.id.datePicker);
        EditText et_game = findViewById(R.id.et_game);
        ListView lv_gamelist = findViewById(R.id.lv_gamelist);
        lv_gamelist.setAdapter(new GameListViewAdapter(this));


        bt_search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                EditText tv_date = findViewById(R.id.ev_date);
                EditText et_game = findViewById(R.id.et_game);
                initData(tv_date.getText().toString(),et_game.getText().toString());
                ListView listView = findViewById(R.id.listView);
                listView.setVisibility(View.VISIBLE);
            }
        });
        et_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePicker datePicker = findViewById(R.id.datePicker);
                datePicker.setVisibility(View.GONE);
                ListView lv_gamelist = findViewById(R.id.lv_gamelist);
                lv_gamelist.setVisibility(View.VISIBLE);
            }
        });

        datePicker.init(2018, 1, 1, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {
                EditText tv_date = findViewById(R.id.ev_date);
                /*Calendar calendar = Calendar.getInstance();
                calendar.set(year,month,dayOfMonth);
                SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");*/
                String dateValue = year+"年"+month+"月"+dayOfMonth+"日";
                tv_date.setText(dateValue);
                datePicker.setVisibility(View.GONE);
            }
        });
       /* datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
            }
        });*/
        tv_date.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                DatePicker datePicker = findViewById(R.id.datePicker);
                ListView lv_gamelist = findViewById(R.id.lv_gamelist);
                lv_gamelist.setVisibility(View.GONE);
                datePicker.setVisibility(View.VISIBLE);
            }
        });
        lv_gamelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                EditText et_gameItem = findViewById(R.id.et_game);
                et_gameItem.setText(gameList.get(i));
                ListView lv_gamelist = findViewById(R.id.lv_gamelist);
                lv_gamelist.setVisibility(View.GONE);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"the "+i+"th is "+dataList.get(i)[0],Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void intiGameList(){
        gameList.add("新斗罗大陆");
        gameList.add("吞噬星空");
        gameList.add("何伟大");
        gameList.add("xxx");
    }
    private  void initData(){}
    private void initData(String date,String gameName){
        String[] dataItem1 = {date+gameName,"title2","title3"};
        String[] dataItem2 = {date+gameName,"title22","title33"};
        String[] dataItem3 = {date+gameName,"title222","title333"};
        dataList.add(dataItem1);
        dataList.add(dataItem2);
        dataList.add(dataItem3);
        dataList.add(dataItem1);
        dataList.add(dataItem2);
        dataList.add(dataItem3);
        dataList.add(dataItem1);
        dataList.add(dataItem2);
        dataList.add(dataItem3);
        dataList.add(dataItem1);
        dataList.add(dataItem2);
        dataList.add(dataItem3);
        dataList.add(dataItem1);
        dataList.add(dataItem2);
        dataList.add(dataItem3);
        dataList.add(dataItem1);
        dataList.add(dataItem2);
        dataList.add(dataItem3);
        dataList.add(dataItem1);
        dataList.add(dataItem2);
        dataList.add(dataItem3);
        dataList.add(dataItem1);
        dataList.add(dataItem2);
        dataList.add(dataItem3);
    }
    class GameListViewAdapter extends BaseAdapter{
        LayoutInflater layoutInflater;
        public GameListViewAdapter(Context context){
            layoutInflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return gameList.size();
        }

        @Override
        public Object getItem(int i) {
            return gameList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View viewItem = layoutInflater.inflate(R.layout.item_game_listview,null);
            TextView textView = viewItem.findViewById(R.id.gameName);
            textView.setText(gameList.get(i));
            return viewItem;
        }
    }
    class DataListViewAdapter extends BaseAdapter{
        private Context context;
        private LayoutInflater layoutInflater ;
        public DataListViewAdapter(Context context){
            layoutInflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return dataList.size();
        }

        @Override
        public Object getItem(int i) {
            return dataList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            View itemView = layoutInflater.inflate(R.layout.activity_data_listview_item,null);
            if(itemView == null){
                Log.e("itemView is null :","itemView is null true");
            }else {
                Log.e("itemView is null :","itemView is null false");
            }
            TextView textView1 = (TextView) itemView.findViewById(R.id.tv_title1);
            TextView textView2 = (TextView) itemView.findViewById(R.id.tv_title2);
            TextView textView3 = (TextView) itemView.findViewById(R.id.tv_title3);

            textView1.setText(dataList.get(i)[0]);
           textView2.setText(dataList.get(i)[1]);
           textView3.setText(dataList.get(i)[2]);
           return itemView;
        }
    }

}
