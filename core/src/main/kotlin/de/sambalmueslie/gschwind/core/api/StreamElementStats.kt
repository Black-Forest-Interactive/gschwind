package de.sambalmueslie.gschwind.core.api

interface StreamElementStats {
    val valuesReceived: Long
    val valuesSent: Long
    val errors: Int
}