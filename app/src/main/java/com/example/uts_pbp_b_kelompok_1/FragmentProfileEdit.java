package com.example.uts_pbp_b_kelompok_1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.uts_pbp_b_kelompok_1.Database.Database;
import com.example.uts_pbp_b_kelompok_1.Model.User;
import com.example.uts_pbp_b_kelompok_1.Preferences.UserPreferences;

public class FragmentProfileEdit extends Fragment {

    private ImageButton btnEditNama, btnEditUsername, btnEditEmail, btnEditAlamat;
    private Button btnCancel, btnConfirm, btnUpdate;
    private TextView tvNama, tvUsername, tvEmail, tvAlamat;
    private EditText textEdit;
    private UserPreferences userPreferences;
    private User user;

    public FragmentProfileEdit() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_edit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnCancel = view.findViewById(R.id.btnCancel);
        btnConfirm = view.findViewById(R.id.btnConfirm);
        btnEditNama = view.findViewById(R.id.btnNamaEdit);
        btnEditUsername = view.findViewById(R.id.btnUsernameEdit);
        btnEditEmail = view.findViewById(R.id.btnEmailEdit);
        btnEditAlamat = view.findViewById(R.id.btnAdressEdit);
        tvNama = view.findViewById(R.id.tvNamaEdit);
        tvUsername = view.findViewById(R.id.tvUsernameEdit);
        tvEmail = view.findViewById(R.id.tvEmailEdit);
        tvAlamat = view.findViewById(R.id.tvAlamatEdit);

        userPreferences = new UserPreferences(this.getContext());
        user = userPreferences.getUserLogin();

        tvNama.setText(user.getFullName());
        tvUsername.setText(user.getUsername());
        tvEmail.setText(user.getEmail());
        tvAlamat.setText(user.getAlamat());

        btnEditNama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                View newLayout = LayoutInflater.from(builder.getContext()).inflate(R.layout.dialog_edit_profile, null);

                textEdit = newLayout.findViewById(R.id.textEdit);
                btnUpdate = newLayout.findViewById(R.id.btnUpdate);

                textEdit.setText(tvNama.getText().toString());
                builder.setView(newLayout);
                builder.setTitle("Edit Data");

                AlertDialog popup = builder.create();
                popup.show();

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String editFullName = textEdit.getText().toString();
//                        String editUsername = user.getUsername();
//                        String editEmail = user.getEmail();
//                        String editAlamat = user.getAlamat();
                        tvNama.setText(editFullName);
//                        int idUser = user.getIduser();
//                        user.setFullName(editFullName);
//                        updateUser(user);
                        Toast.makeText(getContext(), "Berhasil update nama menjadi "+editFullName, Toast.LENGTH_SHORT).show();
                        popup.dismiss();
                    }
                });
            }
        });

        btnEditUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                View newLayout = LayoutInflater.from(builder.getContext()).inflate(R.layout.dialog_edit_profile, null);

                textEdit = newLayout.findViewById(R.id.textEdit);
                btnUpdate = newLayout.findViewById(R.id.btnUpdate);

                textEdit.setText(tvUsername.getText().toString());
                builder.setView(newLayout);
                builder.setTitle("Edit Data");

                AlertDialog popup = builder.create();
                popup.show();

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //tvUsername.setText(textEdit.getText().toString());
                        String editUsername = textEdit.getText().toString();
                        String editFullName = user.getFullName();
                        String editEmail = user.getEmail();
                        String editAlamat = user.getAlamat();
                        tvUsername.setText(editUsername);
                        int idUser = user.getIduser();
                        user.setUsername(editUsername);
//                        updateUser(user);
                        Toast.makeText(getContext(), "Berhasil Update Profile!", Toast.LENGTH_SHORT).show();
                        popup.dismiss();
                    }
                });
            }
        });

        btnEditEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                View newLayout = LayoutInflater.from(builder.getContext()).inflate(R.layout.dialog_edit_profile, null);

                textEdit = newLayout.findViewById(R.id.textEdit);
                btnUpdate = newLayout.findViewById(R.id.btnUpdate);

                textEdit.setText(tvEmail.getText().toString());
                builder.setView(newLayout);
                builder.setTitle("Edit Data");

                AlertDialog popup = builder.create();
                popup.show();

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //tvEmail.setText(textEdit.getText().toString());
                        String editUsername = user.getUsername();
                        String editFullName = user.getFullName();
                        String editEmail = textEdit.getText().toString();
                        String editAlamat = user.getAlamat();
                        tvEmail.setText(editEmail);
                        int idUser = user.getIduser();
                        user.setEmail(editEmail);
//                        updateUser(user);
                        Toast.makeText(getContext(), "Berhasil Update Profile!", Toast.LENGTH_SHORT).show();
                        popup.dismiss();
                    }
                });
            }
        });

        btnEditAlamat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                View newLayout = LayoutInflater.from(builder.getContext()).inflate(R.layout.dialog_edit_profile, null);

                textEdit = newLayout.findViewById(R.id.textEdit);
                btnUpdate = newLayout.findViewById(R.id.btnUpdate);

                textEdit.setText(tvAlamat.getText().toString());
                builder.setView(newLayout);
                builder.setTitle("Edit Data");

                AlertDialog popup = builder.create();
                popup.show();

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //tvAlamat.setText(textEdit.getText().toString());
                        String editUsername = user.getUsername();
                        String editFullName = user.getFullName();
                        String editEmail = user.getEmail();
                        String editAlamat = textEdit.getText().toString();
                        tvAlamat.setText(editAlamat);
                        int idUser = user.getIduser();
                        user.setAlamat(editAlamat);
//                        updateUser(user);
                        Toast.makeText(getContext(), "Berhasil Update Profile!", Toast.LENGTH_SHORT).show();
                        popup.dismiss();
                    }
                });
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(getContext(), "Berhasil Edit Profile!", Toast.LENGTH_SHORT).show();
                onBackPressed();
            }
        });
    }

    public void onBackPressed() {
       FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.popBackStack();
    }


    public void updateUser(User user){
        class UpdateUser extends AsyncTask<Void, Void,Void> {

            @Override
            protected Void doInBackground(Void... voids) {

                Database.getInstance(getContext())
                        .getDatabase()
                        .userDao()
                        .updateUser(user);
                return null;
            }
            @Override
            protected void onPostExecute(Void unused){
                super.onPostExecute(unused);
            }
        }
        UpdateUser updateUser = new UpdateUser();
        updateUser.execute();
    }

}