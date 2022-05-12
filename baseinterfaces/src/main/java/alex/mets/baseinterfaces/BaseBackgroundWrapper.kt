package alex.mets.baseinterfaces

interface BaseBackgroundWrapper<INPUT, OUtPUT> {

    fun doInBackground(input: INPUT, output: OUtPUT)
}