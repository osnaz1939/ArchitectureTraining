package alex.mets.feature_one.domain

import alex.mets.baseinterfaces.BaseInteractor
import alex.mets.feature_one.data.RepositoryOne

class OneInteractor : BaseInteractor<Unit, Int> {

    //TODO add DI
    private val repo = RepositoryOne()

    override suspend fun doWork(input: Unit): Int {
        return repo.getNumber()
    }
}