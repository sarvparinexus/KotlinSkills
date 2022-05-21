package kotlins.skills.remember.api.models

data class VersionFeatures(val androidVersion: AndroidVersion, val features: List<String>)
data class AndroidVersion(val apiLevel: Int, val name: String)