package basics

object Graphs extends App {
  val graph = Array(
      //    0,1,2,3,4,5
      Array(0,1,0,1,1,0), //0
      Array(0,0,1,0,0,1), //1
      Array(1,0,0,0,1,0), //2
      Array(0,0,1,0,0,0), //3
      Array(0,0,0,0,0,1), //4
      Array(0,0,0,0,0,0)) //5
      
  def reachable(node1:Int,node2:Int,connect:Array[Array[Int]], visited:Set[Int] = Set.empty):Boolean = {
    if (node1 == node2) true else {
      val newVisited = visited + node1
      var i = 0
      var ret = false
      while(!ret && i < connect.length){
        if(connect(node1)(i)!=0 && !visited(i)) ret ||= reachable(i, node2, connect, newVisited)
        i += 1
      }
      ret
    }
  }

  def shortestPath(node1: Int, node2: Int, connect: Array[Array[Int]], visited:Set[Int] = Set.empty): Int = {
    if (node1 == node2) 0 else {
      val newVisited = visited + node1
      var i = 0
      var ret = 1000000000
      while (i < connect.length) {
        if (connect(node1)(i) != 0 && !visited(i)) ret = ret min shortestPath(i, node2, connect, newVisited)
        i += 1
      }
      ret + 1
    }
  }
  
  println("Reachable:")
  println(reachable(0,5,graph)) //should be true
  println(reachable(4,3,graph)) //should be false
  
  println("\nShortest Path:")
  println(shortestPath(0,5,graph)) //should be 2
  println(shortestPath(4,3,graph)) //should be 1000000000+
  println(shortestPath(3,5,graph)) //should be 3
}