package com.study.andancas.domain

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable

sealed class RequestState<out T> {
    //  O <T> significa que RequestState pode "lidar" com qualquer tipo de informação.
    // o T é o "tipo de dado" que você espera receber se a busca for um sucesso.

    // Estados possíveis:
    data object Idle: RequestState<Nothing>()
    data object Loading: RequestState<Nothing>()
    data class Success<T>(val data: T): RequestState<T>()
    data class Error(val message: String): RequestState<Nothing>()

    // Funções de verificação do estado atual:
    fun isLoading() = this is Loading
    fun isSuccess() = this is Success
    fun isError() = this is Error

    fun getSuccessData() = (this as Success).data
    fun getSuccessDataOrNull() : T? {
        return try{
            (this as Success).data
        } catch(e: Exception){
            null
        }
    }

    // getSuccessDataOrNull(): Uma versão mais segura de getSuccessData().
    // Ela tenta pegar os dados, mas se der algum problema (se não for Success),
    // ela retorna null em vez de causar um erro no aplicativo.

    fun getErrorMessage() = (this as Error).message
    fun getErrorMessageOrEmpty(): String{
        return try{
            (this as Error).message
        } catch (e: Exception){
            ""
        }
    }

    @Composable
    fun DisplayResult(
        onIdle: (@Composable () -> Unit)? = null,
        onLoading: @Composable () -> Unit,
        onSuccess: @Composable (T) -> Unit,
        onError: @Composable (String) -> Unit,
        transitionSpec: AnimatedContentTransitionScope<*>.() -> ContentTransform = {
            fadeIn(tween(durationMillis = 300)) togetherWith
                    fadeOut(tween(durationMillis = 300))
        }
    ) {
        AnimatedContent(
            targetState = this,
            transitionSpec = transitionSpec,
            label = "Animated State"
        ) { state ->
            when (state) {
                is Idle -> {
                    onIdle?.invoke()
                }

                is Loading -> {
                    onLoading()
                }

                is Success -> {
                    onSuccess(state.getSuccessData())
                }

                is Error -> {
                    onError(state.getErrorMessage())
                }
            }
        }
    }

}