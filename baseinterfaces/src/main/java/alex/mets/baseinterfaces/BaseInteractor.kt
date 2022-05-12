package alex.mets.baseinterfaces

interface BaseInteractor<INPUT, OUtPUT> {
    suspend fun doWork(input: INPUT): OUtPUT
}