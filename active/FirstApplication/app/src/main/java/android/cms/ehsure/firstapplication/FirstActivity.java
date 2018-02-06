package android.cms.ehsure.firstapplication;
import android.content.Intent;
import android.net.Uri;
import android.print.PrintManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
public class FirstActivity extends AppCompatActivity  {
private Button btnTotast;
private Button btnClose;
private Button btnShowActivity;
private Button btnsteaactivity;
private Button btnBrower;
private Button btnDataPush;
private Button btnConnectPrinter;
    Socket client;
    PrintManager printManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        btnTotast=(Button)findViewById(R.id.button1);
        btnClose=(Button)findViewById(R.id.button2);
        btnShowActivity=(Button)findViewById(R.id.btn_showActive);
        btnShowActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnTotast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this,"This is Toast",Toast.LENGTH_LONG).show();
            }
        });
        btnsteaactivity=(Button)findViewById(R.id.btn_steatchActive);
        btnsteaactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("android.cms.ehsure.firstapplication.ACTION_START");
                intent.addCategory("android.cms.ehsure.firstapplication.MY_CATEGORY");
                startActivity(intent);
            }
        });
        btnBrower=findViewById(R.id.btn_brower);
        btnBrower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBrower=new Intent(Intent.ACTION_VIEW);
                intentBrower.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intentBrower);
                /*Intent intentTel=new Intent(Intent.ACTION_DIAL);
                intentTel.setData(Uri.parse("tel:18521039557"));
                startActivity(intentTel);*/
            }
        });

        btnDataPush=findViewById(R.id.btn_datapush);
        btnDataPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentdatapush=new Intent(FirstActivity.this,ResultActivity.class);
                startActivityForResult(intentdatapush,1);
            }
        });
        btnConnectPrinter=findViewById(R.id.btn_connectPrinter);

        btnConnectPrinter.setOnClickListener(new ButtonClickListener(this));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.add_item:
                Toast.makeText(this,"You Click Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You Click Remove",Toast.LENGTH_LONG).show();
                break;
            default:
        }
        return true;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       switch (requestCode)
       {
           case 1:
               if (resultCode==RESULT_OK)
               {
                   String returnData=data.getStringExtra("data_return");
                   Toast.makeText(this,returnData,Toast.LENGTH_LONG).show();
               }
       }
    }
    public void SendMsg(final String msg)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (client!=null&&client.isConnected())
                {
                    OutputStream os;
                    try {
                        os = client.getOutputStream();
                        os.write(msg.getBytes("UTF-8"));
                        os.flush();

                    } catch (IOException e) {

                        e.printStackTrace();
                    }

                }
                else {

                }
            }
        }) .start();
    }


}
