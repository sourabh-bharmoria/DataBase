package com.example.viewmodel

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.example.viewmodel.databinding.SharedactivityMainBinding

class EncrytedSharedPref: AppCompatActivity() {

    private lateinit var binding: SharedactivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SharedactivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val masterKey =  MasterKey.Builder(this)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build();

        val sharedPreferences: SharedPreferences = EncryptedSharedPreferences.create(this,
            "secret_shared_prefs",
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        );

        // use the shared preferences and editor as you normally would
        val editor = sharedPreferences.edit();

        binding.savebtn.setOnClickListener {
            val name = binding.EditText1.text.toString()
            val age = binding.EditText2.text.toString().toInt()
            val isAdult = binding.checkbox.isChecked


            editor.apply{
                putString("name",name)
                putInt("age",age)
                putBoolean("isAdult",isAdult)
                apply()
            }
        }

        binding.retrievebtn.setOnClickListener {
            val name = sharedPreferences.getString("name",null)
            val age = sharedPreferences.getInt("age",0)
            val isAdult = sharedPreferences.getBoolean("isAdult",false)

            binding.EditText1.setText(name)
            binding.EditText2.setText(age.toString())
            binding.checkbox.isChecked = isAdult

        }
    }

}