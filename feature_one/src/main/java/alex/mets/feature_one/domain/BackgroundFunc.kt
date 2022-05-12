package alex.mets.feature_one.domain

import alex.mets.baseinterfaces.BaseBackgroundWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn

class BackgroundFunc : BaseBackgroundWrapper<() -> Flow<Int>, (Int) -> Int> {

    //do in UIThread
    override fun doInBackground(input: () -> Flow<Int>, output: (Int) -> Int) {
        MainScope().async {
            input.invoke()
                .flowOn(Dispatchers.IO)
                .collect {
                    //do in UIThread
                    output.invoke(it)
                }
        }
    }

}