package basics

object RecursionPractice2 extends App {

  println("Factorial of 5: " + recFactorial(5))
  println("Factorial of 6: " + recFactorial(6))
  println("\nFibonacci of 5: " + recFibonacci(5))
  println("Fibonacci of 6: " + recFibonacci(6))

  def recFactorial(x: Int): Int = if (x < 2) 1 else x * recFactorial(x - 1)
  def recFibonacci(x: Int): Int = if (x < 2) 1 else (recFibonacci(x - 1) + recFibonacci(x - 2))

  def knapsack(items:List[(Double,Double)], weightLeft:Double): Double = items match {
    case Nil => 0.0
    case (value, weight) :: t => 
      knapsack(t, weightLeft) max (if(weight>weightLeft) 0.0 else value + knapsack(t,weightLeft-weight))
  }
  
//  def binPack(bins:Array[Double], objs:List[Double]):Boolean= objs match {
//    case Nil => true
//    case obj :: t =>
//      
//  }
}