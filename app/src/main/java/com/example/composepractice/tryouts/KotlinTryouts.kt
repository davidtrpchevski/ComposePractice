package com.example.composepractice.tryouts

import android.util.Log
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

abstract class Human {

    // Protected: Visible only in subclass
    protected open val name: String = "David"

    // Abstract: Need of implementation
    protected abstract val surname: String

    var mother: String = ""
        get() = "Madre"
        protected set // If we don't do checks, leave it like this

    open fun laugh() {
        Log.d("HUMAN", "LAUGH")
    }

    fun live() {
        Log.d("HUMAN", "LIVE")
    }

    open fun love() {
        Log.d("HUMAN", "LOVE")
    }
}

class Kid : Human() {

    override val name: String
        get() = "Brane"

    override val surname: String
        get() = "Branko"

    override fun laugh() {
        // Override only in subclass
        mother = "Mojo"
        Log.d("KID", "LAUGH")
    }

    override fun love() {
        // Called the love method from inherited via super
        super.love()
    }

    fun smile() {
        // Method called from inherited class
        super.live()
        Log.d("KID", "SMILE")
    }

}


// To create the delegate class for the var type, you need to implement the ReadWriteProperty interface.
// Similarly, you need to implement the ReadOnlyProperty interface for the val type.
class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int = fieldData

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
            Log.d("VALUE", fieldData.toString())
        } else {
            Log.d("VALUE", "Not set")
        }
    }

}

fun trick() {
    println("Or treat")
}

fun oopPlayground() {
    val entity: Human = Kid()
    entity.laugh()
    entity.live()
}

fun delegationPlayground() {
    var smartRangeRegulator by RangeRegulator(1, 2, 10)
    smartRangeRegulator = 1
}


fun functionsPlayground() {

    val lambdaVariable = {
        100
    }

    val trickFun = trick()
    val referenceByValue = ::trick

    val trickOrTreat = {
        println("Lambda in val")
    }

    val variable = trickOrTreat

    val functionalVariable: (String) -> Int = {
        it.length
    }

    fun functionAsReturnType(isOkay: Boolean): () -> Unit {
        return variable
    }

    functionAsReturnType(true)

    repeat(12) {
        println("Cought number: $it")
    }
}

fun functionalReference() {
    fun giveName() = "David"
    val name = ::giveName

}

fun runPlayground() {
    oopPlayground()
    delegationPlayground()

}