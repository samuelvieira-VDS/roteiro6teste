package com.example.myapplication2

interface OnConfigChangeListener {
    fun onConfigUpdated(configName: String, newValue: String)
}