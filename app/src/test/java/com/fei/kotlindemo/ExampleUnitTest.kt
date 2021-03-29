package com.fei.kotlindemo

import com.fei.kotlindemo.`interface`.ForecastDataSource
import com.fei.kotlindemo.domain.model.Forecast
import com.fei.kotlindemo.extension.toDateString
import com.fei.kotlindemo.provider.ForecastProvider
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import java.text.DateFormat

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
//        val list = listOf(1, 2, 3, 4, 5, 6)
//        assertEquals(listOf(1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7),
//            list.flatMap { listOf(it, it + 1) })

//        print(list.elementAtOrElse(10, { 2 * it }))
       /* assertEquals(mapOf("odd" to listOf(1, 3, 5),
            "even" to listOf(2, 4, 6)),
            list.groupBy { if (it % 2 == 0) "even" else "odd" })*/
//        assertEquals("2015-10-20",1445275635000L.toDateString(DateFormat.FULL))


        val ds = mock(ForecastDataSource::class.java)
        `when`(ds.requestDayForecast(0)).then{
            Forecast(0,0,"desc",20,0,"url")
        }

        val provider =ForecastProvider(listOf(ds))
        assertNotNull(provider.requestForecast(0))

    }
}