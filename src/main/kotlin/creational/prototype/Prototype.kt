package creational.prototype

// UIStatePrototype.kt

data class UIState(
    val username: String = "ProtoUser",
    val isLoading: Boolean = false,
    val errorMessage: String? = null
) {
    fun debug() {
        println("Username: $username")
        println("Loading: $isLoading")
        println("Error: $errorMessage")
    }
}

fun main() {
    // Initial state (empty)
    val initialState = UIState()

    // State while loading user profile
    val loadingState = initialState.copy(isLoading = true)

    // State when data is loaded
    val loadedState = loadingState.copy(
        isLoading = false,
    )

    // State with error
    val errorState = loadedState.copy(
        isLoading = false,
        errorMessage = "Failed to fetch data"
    )
}
