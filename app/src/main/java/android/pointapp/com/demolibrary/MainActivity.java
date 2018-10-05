package android.pointapp.com.demolibrary;


import android.graphics.Color;
import android.pointapp.com.mylibrary.DataModel.FacebookUserOutPutModel;
import android.pointapp.com.mylibrary.FacebookLogin;
import android.pointapp.com.mylibrary.Util;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin,btnShowAlert,btnShowNet,btnShowSnack;
    EditText edtSnack,edtAlert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.btnFacebook);
        btnShowAlert = findViewById(R.id.btnShowAlert);
        btnShowNet = findViewById(R.id.btnshowNet);
        btnShowSnack = findViewById(R.id.btnShowSnab);
        edtAlert = findViewById(R.id.edtMessgae);
        edtSnack = findViewById(R.id.edtSnack);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.setStatusBarColor(MainActivity.this, Color.RED);
                edtAlert.setVisibility(View.GONE);
                edtSnack.setVisibility(View.GONE);

            }
        });
        btnShowAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtAlert.setVisibility(View.GONE);
                edtSnack.setVisibility(View.GONE);
                Util.showAlert(MainActivity.this,"This is Alert","Alert");

            }
        });

        btnShowNet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtAlert.setVisibility(View.GONE);
                edtSnack.setVisibility(View.GONE);
                if(Util.isInternet(MainActivity.this)){

                    Toast.makeText(MainActivity.this, "Net is On", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Net is Off", Toast.LENGTH_SHORT).show();
                }


            }
        });

        btnShowSnack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtAlert.setVisibility(View.GONE);
                edtSnack.setVisibility(View.GONE);
//                Util.showSnackBar();
            }
        });



    }
}
