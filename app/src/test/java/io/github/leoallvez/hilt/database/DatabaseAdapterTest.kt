package io.github.leoallvez.hilt.database

import android.content.Context
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.io.ByteArrayOutputStream
import java.io.PrintStream

@RunWith(MockitoJUnitRunner::class)
class DatabaseAdapterTest {

    @Mock
    lateinit var mockContext: Context

    @Mock
    lateinit var mockService: DataBaseService

    @Test
    fun testDataBaseAdapter() {
        val adapter = DatabaseAdapter(mockContext, mockService)

        val bo = ByteArrayOutputStream()
        System.setOut(PrintStream(bo))

        adapter.log("unit testing")

        bo.flush()
        val lines = String(bo.toByteArray())

        assert(lines.contains("DatabaseService"))
        assert(lines.contains("Context is available"))
        assert(lines.contains("unit testing"))
    }
}