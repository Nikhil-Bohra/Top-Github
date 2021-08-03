package com.example.myapplication.presentation.view.base

import androidx.lifecycle.ViewModel


abstract class BaseViewModel<C> : ViewModel() {
    var callback : C? = null
}