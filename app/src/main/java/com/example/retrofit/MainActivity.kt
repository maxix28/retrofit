package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.retrofit.databinding.ActivityMainBinding
import com.example.retrofit.utils.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        GlobalScope.launch(Dispatchers.IO) {

            val response = try {
                RetrofitInstance.api.getUser()

            } catch (e:HttpException){
              //  Toast.makeText(applicationContext,"http error ${e.message}",Toast.LENGTH_SHORT).show()
                return@launch

            }catch (e:IOException){
              //  Toast.makeText(applicationContext,"app error ${e.message}",Toast.LENGTH_SHORT).show()
                return@launch

            }

            if(response.isSuccessful&& response.body()!=null){
                withContext(Dispatchers.Main){
                    binding.apply {
                        id.text = response.body()!!.id.toString()
                        titleUser.text = response.body()!!.title.toString()
                        body.text = response.body()!!.body.toString()


                    }
                }
            }
        }



    }
}