package com.ksv.atlantissalary.controller.datasaver

interface DataSaver<T> {
    fun save(data: T)

    fun load() : T
}