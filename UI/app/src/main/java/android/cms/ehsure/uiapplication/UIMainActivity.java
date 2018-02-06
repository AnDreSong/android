package android.cms.ehsure.uiapplication;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Region;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class UIMainActivity extends AppCompatActivity implements View.OnClickListener  {
private ProgressBar progressBar;
private Button btnClick;
private ImageView img;
private Button btn_process;
    Button btnAlter=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uimain);
        progressBar=findViewById(R.id.processbar);
        btnClick= findViewById(R.id.button);
        img=findViewById(R.id.imageshow);
        btnClick.setOnClickListener(this);
       btnAlter= (Button)findViewById(R.id.btn_alertDialog);
       btnAlter.setOnClickListener(this);
       btn_process=(Button)findViewById(R.id.btn_processDialog);
       btn_process.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_alertDialog://AlertDialog
                AlertDialog.Builder dialog=new AlertDialog.Builder(UIMainActivity.this);
                dialog.setTitle("This is Dialog");
                dialog.setMessage("Something importtant.");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(UIMainActivity.this,"OK",Toast.LENGTH_LONG).show();
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(UIMainActivity.this,"Cancel",Toast.LENGTH_LONG).show();
                    }
                });
                dialog.show();
                break;
            case  R.id.btn_processDialog:
                ProgressDialog progressDialog=new ProgressDialog(UIMainActivity.this);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("Loading……");
                progressDialog.setCancelable(true);
                progressDialog.show();


                break;
            default:
                 break;
        }
    }
}
