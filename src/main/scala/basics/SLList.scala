package basics

import collection.mutable

class SLList[A] extends mutable.Buffer[A] {
  def +=(elem: A): this.type = ???
  def +=:(elem: A): this.type = ???
  def apply(n: Int): A = ???
  def clear(): Unit = ???
  def insertAll(n: Int,elems: Traversable[A]): Unit = ???
  def length: Int = ???
  def remove(n: Int): A = ???
  def update(n: Int,newelem: A): Unit = ???
  
  // Members declared in scala.collection.IterableLike
  def iterator: Iterator[A] = ???
}