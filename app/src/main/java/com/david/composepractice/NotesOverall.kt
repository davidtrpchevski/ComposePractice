package com.david.composepractice

// Kotlin Strings Playground

// Remove Prefix, Suffix or Both

fun main() {
    "Hello**".removeSuffix("**")
    "**Hello".removePrefix("**")
    "**Hello**".removeSurrounding("**")
    "--Hello**".removeSurrounding(
        prefix = "--",
        suffix = "**"
    ) // If we have different prefix/suffix
    val name1 = "George"
    val name2 = "GeorGe"
    name1.equals(name2, ignoreCase = true) // Compare strings ignoring lower/upper letters
    name1.contains(
        name2,
        ignoreCase = true
    ) // Check if string is another string ignoring lower/upper letters
    // String check functions have ignoreCase (endsWith or startsWith)
    val ingridients = listOf("Egg", "Bread", "Mayo", "Cheese")
    println(
        ingridients.joinToString(
            limit = 2,
            truncated = "And more",
            prefix = "<",
            postfix = ">"
        )
    ) // Returns  <Egg, Bread, And more>
}