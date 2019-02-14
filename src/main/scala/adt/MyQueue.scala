package adt

trait MyQueue[A] { //Put [A] after the name of the queue instead of after the name of the method so all methods share the type
  def enqueue(a:A):Unit
  def dequeue():A //Stylistic, () indicates we are changing the queue. Note there are no () on peek
  def peek:A
  def isEmpty:Boolean
}