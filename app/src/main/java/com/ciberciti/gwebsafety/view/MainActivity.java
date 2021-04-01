package com.ciberciti.gwebsafety.view;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.ciberciti.gwebsafety.R;
import com.ciberciti.gwebsafety.model.SiteSummaryResponse;
import com.ciberciti.gwebsafety.viewmodel.SharedViewModel;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    SharedViewModel mainActivityViewModel;
    StillFragment stillFragment;
    QueryFragment queryFragment;
    ResultFragment resultFragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    EditText edtLinkInput;
    TextInputLayout textInputLayout;
    Button scanButton;

    @Override
    protected void onResume() {
        super.onResume();
        edtLinkInput.setText(mainActivityViewModel.getSite());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityViewModel = new ViewModelProvider(this).get(SharedViewModel.class);

        edtLinkInput = findViewById(R.id.edt_link_input);
        textInputLayout = findViewById(R.id.linkField);
        scanButton = findViewById(R.id.testButton);
        stillFragment = StillFragment.newInstance();
        queryFragment = QueryFragment.newInstance();
        resultFragment = ResultFragment.newInstance();

        edtLinkInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mainActivityViewModel.setSite(edtLinkInput.getText().toString());
            }
        });

        if (savedInstanceState == null) {
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.main_activity_fragment_container, stillFragment)
                    .commit();
        }

        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard();

                mainActivityViewModel.setHost();
                replaceFragment(queryFragment);
                new CountDownTimer(3000, 1000) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        replaceFragment(resultFragment);
                    }
                }.start();
            }
        });

    }

    private void querySite() {

        mainActivityViewModel.getSiteSummaryResponse().observe(this, new Observer<SiteSummaryResponse>() {
            @Override
            public void onChanged(SiteSummaryResponse siteSummaryResponse) {

//                Toast.makeText(getApplicationContext(),"reviewedSite :"+siteSummaryResponse.getReviewedSite()+
//                        "\n abusiveStatus :"+siteSummaryResponse.getAbusiveStatus(),Toast.LENGTH_LONG).show();
            }
        });

    }

    public void replaceFragment(Fragment fragment) {

        try {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.main_activity_fragment_container, fragment);
            fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
            fragmentTransaction.commitAllowingStateLoss();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public void hideKeyboard() {
        try {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}