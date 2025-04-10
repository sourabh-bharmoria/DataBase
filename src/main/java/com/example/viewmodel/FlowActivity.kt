package com.example.viewmodel

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class FlowActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        GlobalScope.launch(Dispatchers.Main) {
            producer().collect {
                Log.d("Items", it.toString())
            }
        }
    }

    private fun producer(): Flow<Int>{
        return flow<Int>{
            val list = listOf<Int>(1,2,3,4,5,6)
            list.forEach {
                delay(1000)
                emit(it)
            }

        }

    }
}

/*There are also sharedflow and stateflow which are both hot stream mean they produce data
rather there are consumer or not. they both have the same operators as they are flow.
stateflow preserve the last element state. They both can serve multiple consumers.But if the consumer
get delayed they lost some data as these both are hot streams.

the difference between flow and livedata is that is
1. Livedata is lifecycle dependent
2. Livedata perfome operations on main Thread(flow can use different thread using .flowOn)
3. Operator are more in flows for different operations
*
*
* */