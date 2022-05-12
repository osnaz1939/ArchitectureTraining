package alex.mets.feature_one.data

import kotlinx.coroutines.delay

class RepositoryOne {
    suspend fun getNumber(): Int {
        delay(5000)
        return (0..10).random()
    }
}