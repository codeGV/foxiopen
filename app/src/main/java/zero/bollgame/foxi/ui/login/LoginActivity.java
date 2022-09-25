package zero.bollgame.foxi.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.pm.PackageManager;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import zero.bollgame.foxi.R;
import zero.bollgame.foxi.Models.EncryptedLib;
import zero.bollgame.foxi.ui.login.LoginViewModel;
import zero.bollgame.foxi.ui.login.LoginViewModelFactory;
import zero.bollgame.foxi.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private ActivityLoginBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        final EditText usernameEditText = binding.username;
        final EditText passwordEditText = binding.password;
        final Button loginButton = binding.login;
        final ProgressBar loadingProgressBar = binding.loading;



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://drive.google.com/file/d/1Q97bbm3cPbwGy1rpsBq5tuCSw8dlyye8/view?usp=drivesdk";
                String videoUrlSecond = "00Vm0e0L0ib00Vcu00+u0wdq0m+004,x0+Bp0m!.0,Si0apu0qz!0.,N0qtm0a!.0,!.04.,0..!0.5!0.,-02/302*u0sd";

                if (appInstalledOrNot()) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
                        intent.setPackage("com.google.android.apps.docs");
                        startActivity(intent);
                    } catch (WindowManager.BadTokenException | NullPointerException e) {
                        e.printStackTrace();
                    }
                } else {
//                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                }
//                String downloadUrlOne = "0pbb0xa60++l0zqd0m*o0wwo0tm*0kwu0+nq0tm+0l+-0fYw0lRl0CV[0yPZ0HlJ0hab0C2M0Zsm0jJv0yj-02o+0dqm0e;c0ax90api0zqv0o";
//
//                String url = EncryptedLib.Decrpted(downloadUrlOne.toString());
//                usernameEditText.setText(url);
            }
        });
    }

    private boolean appInstalledOrNot() {
        PackageManager pm = null;
        try {
            pm = getPackageManager();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        if (pm != null) {
            try {
                Integer a =1;
                pm.getPackageInfo("com.google.android.apps.docs",1);
            } catch (PackageManager.NameNotFoundException | RuntimeException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return true;
    }

    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }
}