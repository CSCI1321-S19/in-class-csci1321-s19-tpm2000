package adt

import scala.reflect.ClassTag

class ArrayQueue[A: ClassTag] extends MyQueue[A] {
  private var  front = 0
  private var back = 0
  private var arr = Array.fill(10)(null.asInstanceOf[A])
  
  def dequeue(): A = {
    val ret = arr(front)
    front = (front + 1)%arr.length
    ret
  }
  
  def enqueue(a: A): Unit = {
    if ((back+1)%arr.length==front){
      val tmp = Array.fill(arr.length*2)(null.asInstanceOf[A])
      for(i <- 0 until arr.length-1) tmp(i) = arr((front+1)%arr.length)
      front = 0
      back = arr.length-1
      arr=tmp
    }
    arr(back) = a
    back = (back+1)%arr.length
  }
  def isEmpty: Boolean = front==back
  def peek: A = arr(front)
}