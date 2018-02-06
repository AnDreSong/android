package android.cms.ehsure.firstapplication;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Andre on 2018/2/5.
 */

public class ButtonClickListener implements View.OnClickListener{

  private Context c;

  public ButtonClickListener(Context x)
  {
      this.c=x;
  }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_connectPrinter:
                Toast.makeText(c,"Hello Click",Toast.LENGTH_LONG).show();
                break;
            default:
                break;


        }

    }
}
