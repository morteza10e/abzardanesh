package ir.abzardanesh.daneshjooyarapp.model

data class HelpModel(
    val message: String,
    val ok: Boolean,
    val report: List<Report>,
    val success: Int
)

data class Report(
    val ok: Boolean,
    val to: String
)