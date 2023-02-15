package com.novuspax.androidcleanarchitecture.ui.mainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.paging.map
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.novuspax.androidcleanarchitecture.databinding.ActivityMainBinding
import com.novuspax.androidcleanarchitecture.ui.mainActivity.adapter.MyPagingAdapter
import com.novuspax.androidcleanarchitecture.utils.DSL.lambdaWithCallBack
import com.novuspax.androidcleanarchitecture.utils.DSL.lambdaWithCallBackWithNoBody
import com.novuspax.androidcleanarchitecture.utils.DSL.lambdaWithReceiver
import com.novuspax.androidcleanarchitecture.utils.LoaderStateAdapter
import com.novuspax.androidcleanarchitecture.utils.Status
import com.novuspax.androidcleanarchitecture.viewmodel.MyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

// first time enters onCreate and onStart is called
// when user goes to background onPause and onStop is called
// when user comes back to app onRestart and onStart is called

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private val viewModel by viewModels<MyViewModel>()
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private var myPagingAdapter: MyPagingAdapter? = null
    private val page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        dslInitializations()
        initView()
        liveDataApi()
        pagingApi()
        Log.e(TAG, "onCreate: ")
    }

    private fun pagingApi() {

        lifecycleScope.launch {
            viewModel.pagingCharactersList.collectLatest {
//                call submitData() to adapter
                it.map {
                    Log.e(TAG, "Inside Paging Data: ${it.name}", )
                }
            }
        }

        myPagingAdapter?.addLoadStateListener {
            binding.apply {
                when (it.refresh) {
                    is LoadState.NotLoading -> {

                    }
                    LoadState.Loading -> {

                    }
                    is LoadState.Error -> {

                    }
                }
            }
        }
    }

    private fun liveDataApi() {
        viewModel.getCharactersWithCustomClass("$page")
        viewModel.characters.observe(this) {
            when(it.status) {
                Status.SUCCESS -> {
                    Log.e(TAG, "Inside LiveData ${it.data?.results?.get(10)?.name}", )
                    // response found here
                    // check page variable and set conditions accordingly
                }
                Status.FAIL -> {

                }
                Status.LOADING -> {

                }
            }
        }
    }

    private fun initView() {
        myPagingAdapter = MyPagingAdapter {

        }
        binding.rvCharacters.adapter =
            myPagingAdapter?.withLoadStateFooter(LoaderStateAdapter {
                myPagingAdapter?.retry()
            })
        binding.rvCharacters.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val layoutManager = LinearLayoutManager::class.java.cast(recyclerView.layoutManager)
                val itemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val pastVisibleItems = layoutManager.findFirstVisibleItemPosition()
                if (/*binding.pbBottomMfgDirectory.visibility == View.GONE && isMoreRecords*/ true) {
                    if (itemCount + pastVisibleItems >= totalItemCount) {
                        //check for internet connectivity
                        // increment page
                        // call the API
                    }
                }
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }
            /*override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (!recyclerView.canScrollVertically(1) && isMoreRecords) {
                    page++
                    getMfgDirectoryList(false)
                }
            }*/
        })
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "onStart: ")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop: ");
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(TAG, "onRestart: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy: ")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause: ")
    }

    private fun dslInitializations() {
        lambdaWithReceiver(fun(_:StringBuilder) {

        })

        lambdaWithReceiver {
            // this block
            append("asd")
        }

        lambdaWithCallBack {

        }

        lambdaWithCallBackWithNoBody {

        }
    }

}