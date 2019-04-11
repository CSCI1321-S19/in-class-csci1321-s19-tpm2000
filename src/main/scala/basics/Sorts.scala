package basics

object Sorts extends App {
  val nums = Array.fill(10)(util.Random.nextInt(100))
  val numsList = List.fill(10)(util.Random.nextInt(100))

  def bubbleSortInt(arr: Array[Int]): Unit = {
    for (i <- 0 until arr.length - 1; j <- 0 until arr.length - 1 - i) {
      if (arr(j) > arr(j + 1)) {
        val tmp = arr(j)
        arr(j) = arr(j + 1)
        arr(j + 1) = tmp
      }
    }
  }

  println("Quicksort (List): " + quicksort(numsList)(_ < _).mkString(", "))
  def quicksort[A](lst: List[A])(lt: (A, A) => Boolean): List[A] = lst match {
    case Nil => Nil
    case h :: Nil => lst
    case pivot :: t =>
      val (less, greater) = t.partition(a => lt(a, pivot))
      quicksort(less)(lt) ::: (pivot :: quicksort(greater)(lt))
  }

  //println("Quicksort (Array): " + quicksort(nums)(_ < _).mkString(", "))
  def quicksort[A](arr: Array[A])(lt: (A, A) => Boolean): Unit = {
    def helper(start: Int, end: Int): Unit = {
      if(end-start>1){
        val p = start+util.Random.nextInt(end-start)
        val tmp = arr(p)
        arr(p) = arr(start)
        arr(start)=tmp
        var low = start+1
        var high = end-1
        while(low<=high){
          if(lt(arr(low),arr(start))){
            low+=1
          } else {
            val tmp = arr(low)
            arr(low) = arr(high)
            arr(high) = tmp
            high -= 1
          }
        }
        val tmp2 = arr(start)
        arr(start) = arr(high)
        arr(high) = tmp2
        helper(start,high)
        helper(low,end)
      }
    }
  }
}