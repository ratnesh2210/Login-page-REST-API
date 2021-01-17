package com.example.loginpage_922;

        import android.content.DialogInterface;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AlertDialog;
        import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    TextView txtMsg;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_Second);

        txtMsg = findViewById(R.id.txtMsg);
        btnLogout = findViewById(R.id.btnLogout);

        String name = getIntent().getExtras().getString("iName");

        txtMsg.setText("Welocme " + name + "!");

        Toast.makeText(getApplicationContext(), "Login Successfull!!", Toast.LENGTH_LONG).show();

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertBox();
            }
        });
    }

    public void alertBox() {
        AlertDialog.Builder alert = new AlertDialog.Builder(SecondActivity.this);
        alert.setTitle("Alert!!");
        alert.setIcon(R.drawable.alert);
        alert.setMessage("Are you sure you want to logout?");
        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        alert.setCancelable(false);
        alert.create();
        alert.show();
    }
}