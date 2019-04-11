//broken, use RecursionPractice 2

package basics

object RecursionPractice extends App {

  println("Factorial of 5: " + recFactorial(5))
  println("Factorial of 6: " + recFactorial(6))
  println("\nFibonacci of 5: " + recFibonacci(5))
  println("Fibonacci of 6: " + recFibonacci(6))

  def recFactorial(x: Int): Int = if (x < 2) 1 else x * recFactorial(x - 1)
  def recFibonacci(x: Int): Int = if (x < 2) 1 else (recFibonacci(x - 1) + recFibonacci(x - 2))

}