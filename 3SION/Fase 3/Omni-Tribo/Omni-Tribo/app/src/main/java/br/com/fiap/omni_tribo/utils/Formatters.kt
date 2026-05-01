package br.com.fiap.omni_tribo.utils

fun Int.toFormattedXp(): String =
    toString().reversed().chunked(3).joinToString(".").reversed()

fun Double.toBrlFormatted(): String =
    "R$ ${"%.2f".format(this).replace(".", ",")}"
