package com.example.retrofit.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.databinding.ActivityUsersBinding
import com.example.retrofit.models.UsersItem
import com.example.retrofit.rvAdapter
import com.example.retrofit.utils.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class UsersActivity : AppCompatActivity() {
    lateinit var  binding : ActivityUsersBinding
    lateinit var RvAdapter:rvAdapter
    lateinit var users :List<UsersItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        users= listOf()

        GlobalScope.launch(Dispatchers.IO) {

            val response = try {
                RetrofitInstance.apiUsers.getAllUser()

            } catch (e: HttpException){
                //  Toast.makeText(applicationContext,"http error ${e.message}",Toast.LENGTH_SHORT).show()
                return@launch

            }catch (e: IOException){
                //  Toast.makeText(applicationContext,"app error ${e.message}",Toast.LENGTH_SHORT).show()
                return@launch

            }

            if(response.isSuccessful&& response.body()!=null){
                withContext(Dispatchers.Main){

                    users = response.body()!!
                    binding.rvUsers.apply {
                        RvAdapter =rvAdapter(users)
                        adapter = RvAdapter
                        layoutManager =LinearLayoutManager(this@UsersActivity)

                    }
                }
            }
        }

    }
}