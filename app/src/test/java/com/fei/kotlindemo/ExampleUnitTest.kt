package com.fei.kotlindemo

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val list = listOf(1, 2, 3, 4, 5, 6)
//        assertEquals(listOf(1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7),
//            list.flatMap { listOf(it, it + 1) })

        print(list.elementAtOrElse(10, { 2 * it }))
       /* assertEquals(mapOf("odd" to listOf(1, 3, 5),
            "even" to listOf(2, 4, 6)),
            list.groupBy { if (it % 2 == 0) "even" else "odd" })*/
    }
}