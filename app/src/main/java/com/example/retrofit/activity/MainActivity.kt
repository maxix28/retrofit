package com.example.retrofit.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.retrofit.databinding.ActivityMainBinding
import com.example.retrofit.models.UsersItem
import com.example.retrofit.models.user
import com.example.retrofit.utils.RetrofitInstance
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding
    lateinit var  users :List<UsersItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



       // postRequest()
//putReUest()
        //patchReuest()
deletePost()


/*
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
*/


    }

    private fun deletePost() {
        GlobalScope.launch (Dispatchers.IO){
            val response = try {

                //val user = user("new body",null,null,3)
                // RetrofitInstance.api.createPost(user)
                RetrofitInstance.api.deletePost(23)
            } catch (e:HttpException){
                Toast.makeText(applicationContext,"http error ${e.message}",Toast.LENGTH_SHORT).show()
                return@launch

            }catch (e:IOException){
                Toast.makeText(applicationContext,"app error ${e.message}",Toast.LENGTH_SHORT).show()
                return@launch

            }


            if(response.isSuccessful&& response.body()!=null){

                Snackbar.make(binding.root,"${response.code( )}",Snackbar.LENGTH_SHORT).show()
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

    private fun patchReuest() {
        GlobalScope.launch (Dispatchers.IO){
            val response = try {

                val user = user("new body",null,null,3)
                // RetrofitInstance.api.createPost(user)
                RetrofitInstance.api.patchPost(23,user)
            } catch (e:HttpException){
                Toast.makeText(applicationContext,"http error ${e.message}",Toast.LENGTH_SHORT).show()
                return@launch

            }catch (e:IOException){
                Toast.makeText(applicationContext,"app error ${e.message}",Toast.LENGTH_SHORT).show()
                return@launch

            }


            if(response.isSuccessful&& response.body()!=null){

                Snackbar.make(binding.root,"${response.code( )}",Snackbar.LENGTH_SHORT).show()
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

    private fun putReUest() {
        GlobalScope.launch (Dispatchers.IO){
            val response = try {

                 val user = user("new body",null,null,3)
                // RetrofitInstance.api.createPost(user)
                RetrofitInstance.api.putPost(1,user)
            } catch (e:HttpException){
                Toast.makeText(applicationContext,"http error ${e.message}",Toast.LENGTH_SHORT).show()
                return@launch

            }catch (e:IOException){
                Toast.makeText(applicationContext,"app error ${e.message}",Toast.LENGTH_SHORT).show()
                return@launch

            }


            if(response.isSuccessful&& response.body()!=null){

                Snackbar.make(binding.root,"${response.code( )}",Snackbar.LENGTH_SHORT).show()
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

    private fun postRequest() {
      GlobalScope.launch (Dispatchers.IO){
          val response = try {

             // val user = user("new body",null,"lalalala",3)
             // RetrofitInstance.api.createPost(user)
              RetrofitInstance.api.createUrlPost(1,"new new body","url title")
          } catch (e:HttpException){
                Toast.makeText(applicationContext,"http error ${e.message}",Toast.LENGTH_SHORT).show()
              return@launch

          }catch (e:IOException){
                Toast.makeText(applicationContext,"app error ${e.message}",Toast.LENGTH_SHORT).show()
              return@launch

          }


          if(response.isSuccessful&& response.body()!=null){

Snackbar.make(binding.root,"${response.code( )}",Snackbar.LENGTH_SHORT).show()
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