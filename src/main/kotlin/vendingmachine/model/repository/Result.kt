package vendingmachine.model.repository

sealed class Result<out T> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Failure(val error: Error) : Result<Nothing>()

}

enum class Error {
    NotExists, OutOfStock, InsufficientBalance,
}