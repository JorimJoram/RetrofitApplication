package com.example.retrofitapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.retrofitapplication.login.UserInfo;
import com.example.retrofitapplication.retrofit.RetrofitService;
import com.example.retrofitapplication.retrofit.RetrofitSettings;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private String id;
    private String pw;
    private final UserInfo userInfo = new UserInfo();
    private final RetrofitSettings retrofit = new RetrofitSettings();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.testButton);
        button.setOnClickListener(view -> {
            System.out.println("clicked");
            test();
            read();
        });
    }

    private void test(){
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);

        this.userInfo.setId(username.getText().toString());
        this.userInfo.setPw(password.getText().toString());
    }

    private void read() {
        RetrofitService service = retrofit.init().create(RetrofitService.class);
        Call<String> callValue = service.getEmailVerify(userInfo.getId());
        callValue.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                System.out.println(response);
                ResponseTest(response);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                FailureTest(t);
            }
        });
    }

    private void ResponseTest(Response<String> response){
        if(response.isSuccessful()) {
            Log.v("Response Test", response.body());
        }
    }

    private void FailureTest(Throwable t){
        Log.e("error", t.getMessage());
    }
}