package videoCode

object WriteBinaryArrays extends App {
  import LoanPattern._
  
  val arr = Array.fill(10)(math.random)
  withDOS("array.bin") {dos => 
    dos.writeInt(arr.length)
    arr.foreach(dos.writeDouble)
  }
}