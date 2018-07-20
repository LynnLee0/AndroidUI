package com.ui.lixun.uilynn;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends Activity {
    //private String userId = "lixun";
   // private String passWord = "123456";
    Map<String,String> userMap = new HashMap<String, String>();
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = this;
        initUser();

        Button btn_login = (Button) findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ;EditText userIdView = (EditText) findViewById(R.id.userId);
                String userId = userIdView.getText().toString();
                EditText userPwdView = (EditText) findViewById(R.id.userPwd);
                String userPwd = userPwdView.getText().toString();
                //Toast.makeText(mContext ,"密码错误",Toast.LENGTH_LONG).show();

                if(checkSign(userId,userPwd)){
                    Toast.makeText(mContext ,"登录成功",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(mContext ,"密码错误",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private  void initUser(){
        userMap.put("lixun","123456");
        userMap.put("hewei","654321");
    }
    private boolean checkSign(String userId,String passWord){
        String pwd = userMap.get(userId);
        if(pwd != null) Log.e("pwd",pwd);
        if( passWord.equals( userMap.get(userId) )){
            Log.e("pwd",userId + pwd);
            return true;
        }
        return  false;
    }
}
