package com.example.viewmodel

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import com.example.viewmodel.databinding.DatastoreActivityMainBinding
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


val Context.dataStore by preferencesDataStore(name = "profile")
class DataStore: AppCompatActivity() {

    private lateinit var binding: DatastoreActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DatastoreActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.savebtn.setOnClickListener {
            lifecycleScope.launch {
                val username = binding.key.text.toString()
                val value = binding.value.text.toString()

                save(username,value)
            }
        }

        binding.readbtn.setOnClickListener {
            lifecycleScope.launch {
                val value = read(binding.readkey.text.toString())
                binding.textView.text = value ?: "No value found"
            }
        }

    }

    private suspend fun save(key: String, value: String) {
        val dataStorekey = stringPreferencesKey(key)
        applicationContext.dataStore.edit {profile ->
            profile[dataStorekey] = value

        }
    }

    private suspend fun read(key: String) :String? {
        val dataStorekey = stringPreferencesKey(key)
        val username = applicationContext.dataStore.data.first()
        return username[dataStorekey]
    }
}