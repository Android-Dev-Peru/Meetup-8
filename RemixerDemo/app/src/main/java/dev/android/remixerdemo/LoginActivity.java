package dev.android.remixerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.libraries.remixer.Remixer;
import com.google.android.libraries.remixer.annotation.RangeVariableMethod;
import com.google.android.libraries.remixer.annotation.RemixerBinder;
import com.google.android.libraries.remixer.annotation.StringListVariableMethod;
import com.google.android.libraries.remixer.ui.gesture.Direction;
import com.google.android.libraries.remixer.ui.view.RemixerFragment;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private TextView tvTitleLogin, tvRecoverPassword;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        tvTitleLogin = (TextView) findViewById(R.id.tv_title_login);
        tvRecoverPassword = (TextView) findViewById(R.id.tv_recover_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        RemixerBinder.bind(this);
        RemixerFragment remixerFragment = RemixerFragment.newInstance();
        remixerFragment.attachToGesture(this, Direction.UP, 2);
    }

    @RangeVariableMethod(
            key = "titleTextSize",
            minValue = 16, maxValue = 72, increment = 4, title = "Cambio de tamaño de fuente")
    void setTitleTextSize(Integer size) {
        tvTitleLogin.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }

    @StringListVariableMethod(
            title = "Texto de titulo",
            possibleValues = {"Ingresar", "Login", "Iniciar Sesión"})
    void setTitleText(String text) {
        tvTitleLogin.setText(text);
    }

}
